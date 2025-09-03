package hotel.management.system;

import hotel.management.system.util.DigitFilter;
import hotel.management.system.util.DigitListner;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.AbstractDocument;

public class UpdateCheck extends JFrame implements ActionListener {

    Choice ccoustmer;
    JTextField froom, fname, checkintime, famountp, fpamount, feamount;
    JButton check, update, back;
    JTextField roomPrice = new JTextField();
    JLabel errorMsg, originalDAmt = new JLabel(), originalPAmt = new JLabel();

    UpdateCheck() {

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel text = new JLabel("UPDATE CHECKING STATUS");
        text.setBounds(90, 20, 250, 30);
        text.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(text);

        JLabel id = new JLabel("COUSTMER ID");
        id.setBounds(30, 80, 100, 30);
        add(id);

        ccoustmer = new Choice();     //for choicebox
        ccoustmer.setBounds(200, 80, 150, 30);
        add(ccoustmer);
        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from coustmer");
            while (rs.next()) {
                ccoustmer.add(rs.getString("number"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        add(ccoustmer);

        JLabel room = new JLabel("ROOM NUMBER");
        room.setBounds(30, 120, 100, 20);
        add(room);

        froom = new JTextField();
        froom.setBounds(200, 120, 150, 25);
        add(froom);

        JLabel name = new JLabel("NAME");
        name.setBounds(30, 160, 100, 20);
        add(name);

        fname = new JTextField();
        fname.setBounds(200, 160, 150, 25);
        add(fname);

        JLabel checkin = new JLabel("CHECKIN TIME");
        checkin.setBounds(30, 200, 100, 20);
        add(checkin);

        checkintime = new JTextField();
        checkintime.setBounds(200, 200, 150, 25);
        add(checkintime);

        JLabel amountp = new JLabel("AMOUNT PAID");
        amountp.setBounds(30, 240, 100, 20);
        add(amountp);

        famountp = new JTextField();
        famountp.setBounds(200, 240, 150, 25);
        famountp.setEditable(false);
        add(famountp);

        JLabel pamount = new JLabel("PENDIG AMOUNT");
        pamount.setBounds(30, 280, 100, 20);
        add(pamount);

        fpamount = new JTextField();
        fpamount.setBounds(200, 280, 150, 25);
        fpamount.setEditable(false);
        add(fpamount);

        JLabel eamount = new JLabel("ENTER AMOUNT");
        eamount.setBounds(30, 320, 100, 20);
        add(eamount);

        errorMsg = new JLabel();
        errorMsg.setBounds(200, 345, 500, 20);
        errorMsg.setForeground(Color.red);
        errorMsg.setText("Invalid Amount Enterd");
        errorMsg.setVisible(false);
        add(errorMsg);

        feamount = new JTextField();
        feamount.setBounds(200, 320, 150, 25);
        ((AbstractDocument) feamount.getDocument()).setDocumentFilter(new DigitFilter());
        feamount.getDocument().addDocumentListener(new DigitListner(famountp, fpamount, feamount, roomPrice, errorMsg, originalDAmt, originalPAmt));
        feamount.setEditable(false);
        add(feamount);

        check = new JButton("CHECK");
        check.setBounds(30, 400, 100, 30);
        check.setBackground(Color.BLACK);
        check.setForeground(Color.WHITE);
        check.addActionListener(this);
        add(check);

        update = new JButton("UPDATE");
        update.setBounds(150, 400, 100, 30);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
        update.setEnabled(false);
        if (!update.isEnabled()) {
            update.setBackground(Color.GRAY);
        }
        add(update);

        back = new JButton("BACK");
        back.setBounds(270, 400, 100, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        //for image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/nine.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(400, 50, 500, 300);
        add(image);

        setBounds(230, 150, 950, 500);
        setVisible(true);
        setTitle("Update Checkin");

    }

    public static void main(String[] args) {
        new UpdateCheck();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == check) {
            String id = ccoustmer.getSelectedItem();
            String query = "select * from coustmer where number='" + id + "'";
            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                while (rs.next()) {
                    froom.setText(rs.getString("room"));
                    fname.setText(rs.getString("name"));
                    checkintime.setText(rs.getString("checkin"));
                    famountp.setText(rs.getString("deposit"));
                    originalDAmt.setText(rs.getString("deposit"));
                }
                ResultSet rs2 = c.s.executeQuery("select * from room where roomno ='" + froom.getText() + "'");
                while (rs2.next()) {
                    String price = rs2.getString("price");
                    roomPrice.setText(price);
                    Double pendingAmount = Double.parseDouble(price) - Double.parseDouble(famountp.getText()); //to convert string into integer
                    System.out.println("amountpaid:" + pendingAmount);
                    fpamount.setText(String.valueOf(pendingAmount));
                    originalPAmt.setText(String.valueOf(pendingAmount));
                }

                if (roomPrice.getText().length() > 0) {
                    feamount.setEditable(true);
                    update.setEnabled(true);
                    update.setBackground(Color.BLACK);
                }

            } catch (Exception ee) {
                ee.printStackTrace();
            }

        } else if (e.getSource() == update) {
            String number = ccoustmer.getSelectedItem();
            String room = froom.getText();
            String name = fname.getText();
            String checkin = checkintime.getText();
            String deposit = famountp.getText();
            try {
                Conn c = new Conn();
                c.s.executeUpdate("update coustmer set room='" + room + "', name='" + name + "', checkin='" + checkin + "', deposit='" + deposit + "'where number= '" + number + "'");
                JOptionPane.showMessageDialog(null, "DATA UPDATED SUCCESSFULLY");
                setVisible(false);
                new Reception();
            } catch (Exception ee) {
                ee.printStackTrace();
            }

        } else {
            setVisible(false);
            new Reception();
        }
    }

}

package hotel.management.system;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Checkout extends JFrame implements ActionListener {

    Choice ccoustmer;
    JLabel blank, bcheckin, bcheckout;
    JButton checkoutb, back;

    Checkout() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel text = new JLabel("CHECKOUT");
        text.setBounds(140, 20, 100, 30);
        text.setForeground(Color.BLACK);
        text.setFont(new Font("Tohana", Font.BOLD, 16));
        add(text);

        JLabel id = new JLabel("COUSTMER ID");
        id.setBounds(30, 80, 100, 30);
        add(id);

        ccoustmer = new Choice();     //for choicebox
        ccoustmer.setBounds(150, 80, 150, 25);
        add(ccoustmer);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/tick.png"));
        Image i2 = i1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(310, 80, 20, 20);
        add(image);

        JLabel rno = new JLabel("Room Number");
        rno.setBounds(30, 130, 100, 30);
        add(rno);

        blank = new JLabel();
        blank.setBounds(150, 130, 100, 30);
        add(blank);

        JLabel checkin = new JLabel("Checkin Time");
        checkin.setBounds(30, 180, 100, 30);
        add(checkin);

        bcheckin = new JLabel();
        bcheckin.setBounds(150, 180, 200, 30);
        add(bcheckin);

        JLabel checkout = new JLabel("Checkout Time");
        checkout.setBounds(30, 230, 100, 30);
        add(checkout);

        Date date = new Date();
        bcheckout = new JLabel("" + date);
        bcheckout.setBounds(150, 230, 200, 30);
        add(bcheckout);

        checkoutb = new JButton("CHECKOUT");
        checkoutb.setBounds(30, 280, 120, 30);
        checkoutb.setBackground(Color.BLACK);
        checkoutb.setForeground(Color.WHITE);
        checkoutb.addActionListener(this);
        add(checkoutb);

        back = new JButton("BACK");
        back.setBounds(170, 280, 120, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from coustmer");
            while (rs.next()) {
                ccoustmer.add(rs.getString("number"));
                blank.setText(rs.getString("room"));
                bcheckin.setText(rs.getString("checkin"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/sixth.jpg"));
        Image i5 = i4.getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image1 = new JLabel(i6);
        image1.setBounds(400, 50, 400, 250);
        add(image1);

        setBounds(280, 200, 850, 400);
        setVisible(true);
        setTitle("Checkout");

    }

    public static void main(String[] args) {
        new Checkout();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == checkoutb) {

            String query1 = "delete from coustmer where number='" + ccoustmer.getSelectedItem() + "'";
            String query2 = "update room set availability ='Available' where roomno = '" + blank.getText() + "'";

            try {
                Conn conn = new Conn();
                conn.s.executeUpdate(query1);
                conn.s.executeUpdate(query2);

                JOptionPane.showMessageDialog(null, "CHECKOUT DONE");

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

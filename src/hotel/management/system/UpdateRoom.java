package hotel.management.system;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;  
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class UpdateRoom extends JFrame implements ActionListener {

    Choice ccoustmer;
    JTextField froom, favailable, cstatus;
    JButton check, update, back;

    UpdateRoom() {

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel text = new JLabel("UPDATE ROOM STATUS");
        text.setBounds(80, 20, 250, 30);
        text.setFont(new Font("Tahoma", Font.BOLD, 20));
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
        room.setBounds(30, 130, 100, 20);
        add(room);

        froom = new JTextField();
        froom.setBounds(200, 130, 150, 25);
        add(froom);

        JLabel available = new JLabel("AVAILABILITY");
        available.setBounds(30, 180, 100, 20);
        add(available);

        favailable = new JTextField();
        favailable.setBounds(200, 180, 150, 25);
        add(favailable);

        JLabel status = new JLabel("CLEANING STATUS");
        status.setBounds(30, 230, 100, 20);
        add(status);

        cstatus = new JTextField();
        cstatus.setBounds(200, 230, 150, 25);
        add(cstatus);

        check = new JButton("CHECK");
        check.setBounds(30, 300, 100, 30);
        check.setBackground(Color.BLACK);
        check.setForeground(Color.WHITE);
        check.addActionListener(this);
        add(check);

        update = new JButton("UPDATE");
        update.setBounds(150, 300, 100, 30);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
        add(update);

        back = new JButton("BACK");
        back.setBounds(270, 300, 100, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        //for image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/seventh.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 50, 500, 300);
        add(image);

        setBounds(230, 150, 950, 450);
        setVisible(true);
         setTitle("Room Update");
       
    }

    public static void main(String[] args) {
        new UpdateRoom();
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
                }
                ResultSet rs2 = c.s.executeQuery("select * from room where roomno = '"+froom.getText()+"'");
                while (rs2.next()) {
                    favailable.setText(rs2.getString("availability"));
                     cstatus.setText(rs2.getString("cleaning_status"));
                }
            } catch (Exception ee) {
                ee.printStackTrace();
            }

        } else if (e.getSource() == update) {
            String number = ccoustmer.getSelectedItem();
            String room = froom.getText();
            String available = favailable.getText();
            String status = cstatus.getText();
            try {
                Conn c = new Conn();
                c.s.executeUpdate("update coustmer set availability='" + favailable + "', cleaning_status='" + cstatus + "' where roomno= '"+ room +"'");
                JOptionPane.showMessageDialog(null,"DATA UPDATED SUCCESSFULLY");
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

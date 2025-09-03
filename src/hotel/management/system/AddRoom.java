package hotel.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class AddRoom extends JFrame implements ActionListener {

    JButton add, cancel;
    JComboBox availablecombo, cleancombo, typecombo;
    JTextField froomno, fprice;

    AddRoom() {

        setLayout(null);

        //For heading
        JLabel heading = new JLabel("ADD ROOM");
        heading.setBounds(150, 20, 200, 20);
        heading.setFont(new Font("Tahoma", Font.BOLD, 18));
        add(heading);

        JLabel roomno = new JLabel("ROOM NUMBER");
        roomno.setBounds(60, 80, 130, 30);
        roomno.setFont(new Font("Tahoma", Font.PLAIN, 12));
        add(roomno);

        froomno = new JTextField();
        froomno.setBounds(200, 80, 150, 30);
        add(froomno);

        JLabel available = new JLabel("AVAILABLE");
        available.setBounds(60, 130, 130, 30);
        available.setFont(new Font("Tahoma", Font.PLAIN, 12));
        add(available);

        String availableoption[] = {"AVAILABLE", "OCCUPIED"};
        availablecombo = new JComboBox(availableoption);
        availablecombo.setBounds(200, 130, 150, 30);
        availablecombo.setBackground(Color.WHITE);
        add(availablecombo);

        JLabel clean = new JLabel("CLEANING STATUS");
        clean.setBounds(60, 180, 130, 30);
        clean.setFont(new Font("Tahoma", Font.PLAIN, 12));
        add(clean);

        String cleanoption[] = {"CLEAN", "DURTY"};
        cleancombo = new JComboBox(cleanoption);
        cleancombo.setBounds(200, 180, 150, 30);
        cleancombo.setBackground(Color.WHITE);
        add(cleancombo);

        //for price
        JLabel price = new JLabel("PRICE");
        price.setBounds(60, 230, 130, 30);
        price.setFont(new Font("Tahoma", Font.PLAIN, 12));
        add(price);

        fprice = new JTextField();
        fprice.setBounds(200, 230, 150, 30);
        add(fprice);

        //for selecting bed type
        JLabel bed = new JLabel("BED TYPE");
        bed.setBounds(60, 280, 130, 30);
        bed.setFont(new Font("Tahoma", Font.PLAIN, 12));
        add(bed);

        String typeoption[] = {"SINGLE BED", "DOUBLE BED"};
        typecombo = new JComboBox(typeoption);
        typecombo.setBounds(200, 280, 150, 30);
        typecombo.setBackground(Color.WHITE);
        add(typecombo);

        // add button
        add = new JButton("ADD ROOM");
        add.setBounds(60, 350, 130, 30);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        add(add);

        //cancel button
        cancel = new JButton("CANCEL");
        cancel.setBounds(220, 350, 130, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);

        //for adding image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/twelve.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(400, 80, 500, 300);
        add(image);

        setTitle("Add Room");
        getContentPane().setBackground(Color.WHITE);
        setBounds(250, 150, 940, 470);
        setVisible(true);

    }

    public static void main(String[] args) {
        new AddRoom();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == add) {

            String roomno = froomno.getText();
            String available = (String) availablecombo.getSelectedItem();
            String clean = (String) cleancombo.getSelectedItem();
            String price = fprice.getText();
            String bed = (String) typecombo.getSelectedItem();

            try {
                Conn conn = new Conn();
                String str = "insert into room values('" + roomno + "','" + available + "','" + clean + "','" + price + "','" + bed + "')";
                conn.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null, "NEW ROOM ADDED SUCCESSFULLY");
                setVisible(false);
                new Dashboard();
            } catch (Exception ae) {
                ae.printStackTrace();
            }
        } else {
            setVisible(false);
            new Dashboard();
        }
    }

}

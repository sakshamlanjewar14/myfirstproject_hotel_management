package hotel.management.system;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class AddCoustmer extends JFrame implements ActionListener {

    JComboBox comboid;
    JTextField fno, fname, fcountry, fdeposit;
    JRadioButton rbmale, rbfemale;
    Choice croom;
    JLabel checkintime;
    JButton add, back;

    AddCoustmer() {

        setLayout(null);

        JLabel cform = new JLabel("NEW  COUSTMER  FORM");
        cform.setBounds(100, 20, 300, 30);
        cform.setFont(new Font("Raleway", Font.BOLD, 16));
        add(cform);

        JLabel id = new JLabel("ID");
        id.setBounds(35, 80, 150, 25);
        id.setFont(new Font("Raleway", Font.PLAIN, 16));
        add(id);

        String option[] = {"AADHAR CARD", "PASSPORT", "DRIVING LICENSE", "VOTER ID CARD", "Ration Card"};
        comboid = new JComboBox(option);
        comboid.setBounds(200, 80, 150, 25);
        comboid.setBackground(Color.WHITE);
        add(comboid);

        JLabel number = new JLabel("NUMBER");
        number.setBounds(35, 120, 150, 25);
        number.setFont(new Font("Raleway", Font.PLAIN, 16));
        add(number);

        fno = new JTextField();
        fno.setBounds(200, 120, 150, 25);
        add(fno);

        JLabel name = new JLabel("NAME");
        name.setBounds(35, 160, 150, 25);
        name.setFont(new Font("Raleway", Font.PLAIN, 16));
        add(name);

        fname = new JTextField();
        fname.setBounds(200, 160, 150, 25);
        add(fname);

        //For gender
        JLabel gender = new JLabel("GENDER");
        gender.setBounds(35, 200, 150, 25);
        gender.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(gender);

        rbmale = new JRadioButton("MALE");
        rbmale.setBounds(200, 200, 70, 25);
        rbmale.setFont(new Font("Tahoma", Font.PLAIN, 12));
        rbmale.setBackground(Color.WHITE);
        add(rbmale);

        rbfemale = new JRadioButton("FEMALE");
        rbfemale.setBounds(270, 200, 70, 25);
        rbfemale.setFont(new Font("Tahoma", Font.PLAIN, 12));
        rbfemale.setBackground(Color.WHITE);
        add(rbfemale);

        //Button Grouping for radio button
        ButtonGroup bg = new ButtonGroup();
        bg.add(rbmale);
        bg.add(rbfemale);

        JLabel country = new JLabel("COUNTRY");
        country.setBounds(35, 240, 150, 25);
        country.setFont(new Font("Raleway", Font.PLAIN, 16));
        add(country);

        fcountry = new JTextField();
        fcountry.setBounds(200, 240, 150, 25);
        add(fcountry);

        JLabel aroom = new JLabel("ROOM NUMBER");
        aroom.setBounds(35, 280, 150, 25);
        aroom.setFont(new Font("Raleway", Font.PLAIN, 16));
        add(aroom);

        croom = new Choice();
        croom.setBounds(200, 280, 150, 25);
        try {
            Conn conn = new Conn();
            String query = "select * from room";   //for getting data from db
            ResultSet rs = conn.s.executeQuery(query);
            while (rs.next()) {
                croom.add(rs.getString("roomno"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        add(croom);

        JLabel checkin = new JLabel("CHECKIN TIME");
        checkin.setBounds(35, 320, 150, 25);
        checkin.setFont(new Font("Raleway", Font.PLAIN, 16));
        add(checkin);

        Date date = new Date();//getting screen window time
        JLabel checkintime = new JLabel("" + date);
        checkintime.setBounds(200, 320, 150, 25);
        checkintime.setFont(new Font("Raleway", Font.PLAIN, 15));
        add(checkintime);

        JLabel deposit = new JLabel("DEPOSIT");
        deposit.setBounds(35, 360, 150, 25);
        deposit.setFont(new Font("Raleway", Font.PLAIN, 16));
        add(deposit);

        fdeposit = new JTextField();
        fdeposit.setBounds(200, 360, 150, 25);
        add(fdeposit);

        //For add button
        add = new JButton("ADD");
        add.setBounds(35, 400, 150, 30);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        add(add);

        back = new JButton("BACK");
        back.setBounds(200, 400, 150, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        //for image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fifth.png"));
        Image i2 = i1.getImage().getScaledInstance(300, 400, Image.SCALE_DEFAULT);    //for scaling image
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 50, 300, 400);
        add(image);

        setTitle("AddCoustmer");
        getContentPane().setBackground(Color.WHITE);
        setBounds(350, 230, 800, 550);
        setLocationRelativeTo(null); // Center the frame
        setVisible(true);

    }

    public static void main(String[] args) {
        new AddCoustmer();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == add) {

            String id = (String) comboid.getSelectedItem();
            String number = fno.getText();
            String name = fname.getText();
            String gender = null;

            if (rbmale.isSelected()) {
                gender = "MALE";
            } else if (rbfemale.isSelected()) {
                gender = "FEMALE";
            }

            String country = fcountry.getText();
            String room = croom.getSelectedItem();
            String time = checkintime.getText();
             String deposit = fdeposit.getText();

        } else if(e.getSource()== back){
            
        }
    }

}

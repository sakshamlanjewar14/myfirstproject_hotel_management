package hotel.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class AddEmployee extends JFrame implements ActionListener {

    JTextField fname, fage, fsalary, fphone, femail, faadhar;
    JRadioButton rbmale, rbfemale;
    JButton submit;
    JComboBox cbjob;

    AddEmployee() {
        setLayout(null);

        //For Name
        JLabel name = new JLabel("NAME");
        name.setBounds(60, 30, 120, 30);
        name.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(name);

        fname = new JTextField();
        fname.setBounds(200, 30, 150, 30);
        add(fname);

        //For Age
        JLabel age = new JLabel("AGE");
        age.setBounds(60, 80, 120, 30);
        age.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(age);

        fage = new JTextField();
        fage.setBounds(200, 80, 150, 30);
        add(fage);

        //For gender
        JLabel gender = new JLabel("GENDER");
        gender.setBounds(60, 130, 120, 30);
        gender.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(gender);

        rbmale = new JRadioButton("MALE");
        rbmale.setBounds(200, 130, 70, 30);
        rbmale.setFont(new Font("Tahoma", Font.PLAIN, 12));
        rbmale.setBackground(Color.WHITE);
        add(rbmale);

        rbfemale = new JRadioButton("FEMALE");
        rbfemale.setBounds(280, 130, 70, 30);
        rbfemale.setFont(new Font("Tahoma", Font.PLAIN, 12));
        rbfemale.setBackground(Color.WHITE);
        add(rbfemale);

        //Button Grouping
        ButtonGroup bg = new ButtonGroup();
        bg.add(rbmale);
        bg.add(rbfemale);

        //For job
        JLabel job = new JLabel("JOB");
        job.setBounds(60, 180, 120, 30);
        job.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(job);

        String str[] = {"Govt. Servent","Private Job","Bussiness","Manager"};
        cbjob = new JComboBox(str);
        cbjob.setBounds(200, 180, 150, 30);
        cbjob.setBackground(Color.WHITE);
        add(cbjob);

        //for salary
        JLabel salary = new JLabel("SALARY");
        salary.setBounds(60, 230, 120, 30);
        salary.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(salary);

        fsalary = new JTextField();
        fsalary.setBounds(200, 230, 150, 30);
        add(fsalary);

        //For Phone
        JLabel phone = new JLabel("PHONE NO.");
        phone.setBounds(60, 280, 120, 30);
        phone.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(phone);

        fphone = new JTextField();
        fphone.setBounds(200, 280, 150, 30);
        add(fphone);

        //For Email
        JLabel email = new JLabel("E-MAIL ID");
        email.setBounds(60, 330, 120, 30);
        email.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(email);

        femail = new JTextField();
        femail.setBounds(200, 330, 150, 30);
        add(femail);

        //for AAdhar
        JLabel aadhar = new JLabel("AADHAR");
        aadhar.setBounds(60, 380, 120, 30);
        aadhar.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(aadhar);

        faadhar = new JTextField();
        faadhar.setBounds(200, 380, 150, 30);
        add(faadhar);

        //For submit button
        submit = new JButton("SUBMIT");
        submit.setBounds(200, 430, 150, 30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);

        //for image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/tenth.jpg"));
        Image i2 = i1.getImage().getScaledInstance(450, 450, Image.SCALE_DEFAULT);//for scaling image
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(380, 60, 450, 370);
        add(image);

        setTitle("Add Employee");
       getContentPane().setBackground(Color.WHITE);
        setBounds(270, 150, 850, 540);
        setVisible(true);
        

    }

    public static void main(String[] args) {
        new AddEmployee();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String name = fname.getText();
        String age = fage.getText();
        String salary = fsalary.getText();
        String phone = fphone.getText();
        String email = femail.getText();
        String aadhar = faadhar.getText();

        //getting values from radio button
        String gender = null;
        if (rbmale.isSelected()) {
            gender = "MALE";
        } else if (rbfemale.isSelected()) {
            gender = "FEMALE";
        }

        //getting values from combo box
        String job = (String) cbjob.getSelectedItem();

        try {
            Conn conn = new Conn();
            String query = "insert into employee values('"+ name+"','"+age+"','"+gender+"','"+job+"','"+salary+"','"+phone+"','"+ email +"','"+ aadhar +"' )";
            conn.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "EMPLOYEE DATA ADDED SUCCESSFULLY");
            setVisible(false);
        } catch (Exception ae) {
            ae.printStackTrace();
        }
    }
}

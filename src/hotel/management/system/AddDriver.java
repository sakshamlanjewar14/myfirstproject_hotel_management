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

public class AddDriver extends JFrame implements ActionListener {

    JButton add, cancel;
    JComboBox availablecombo, cleancombo, typecombo;
    JTextField fname, fage, fcompany, fmodel, flocation;
    JRadioButton rbmale, rbfemale;

    AddDriver() {

        setLayout(null);

        //For heading
        JLabel heading = new JLabel("ADD DRIVER");
        heading.setBounds(150, 5, 200, 20);
        heading.setFont(new Font("Tahoma", Font.BOLD, 18));
        add(heading);

        JLabel name = new JLabel("NAME");
        name.setBounds(60, 50, 130, 30);
        name.setFont(new Font("Tahoma", Font.PLAIN, 12));
        add(name);

        fname = new JTextField();
        fname.setBounds(200, 40, 150, 30);
        add(fname);

        JLabel age = new JLabel("AGE");
        age.setBounds(60, 80, 130, 30);
        age.setFont(new Font("Tahoma", Font.PLAIN, 12));
        add(age);

        fage = new JTextField();
        fage.setBounds(200, 80, 150, 30);
        add(fage);

        JLabel gender = new JLabel("GENDER");
        gender.setBounds(60, 120, 130, 30);
        gender.setFont(new Font("Tahoma", Font.PLAIN, 12));
        add(gender);

        rbmale = new JRadioButton("MALE");
        rbmale.setBounds(200, 120, 70, 30);
        rbmale.setFont(new Font("Tahoma", Font.PLAIN, 12));
        rbmale.setBackground(Color.WHITE);
        add(rbmale);

        rbfemale = new JRadioButton("FEMALE");
        rbfemale.setBounds(280, 120, 70, 30);
        rbfemale.setFont(new Font("Tahoma", Font.PLAIN, 12));
        rbfemale.setBackground(Color.WHITE);
        add(rbfemale);
        
        //Button Grouping
        ButtonGroup bg = new ButtonGroup();
        bg.add(rbmale);
        bg.add(rbfemale);


        JLabel company = new JLabel("CAR COMPANY");
        company.setBounds(60, 160, 130, 30);
        company.setFont(new Font("Tahoma", Font.PLAIN, 12));
        add(company);

        fcompany = new JTextField();
        fcompany.setBounds(200, 160, 150, 30);
        add(fcompany);

        JLabel model = new JLabel("CAR MODEL");
        model.setBounds(60, 200, 200, 30);
        model.setFont(new Font("Tahoma", Font.PLAIN, 12));
        add(model);

        fmodel = new JTextField();
        fmodel.setBounds(200, 200, 150, 30);
        add(fmodel);

        JLabel available = new JLabel("AVAILABLE");
        available.setBounds(60, 240, 130, 30);
        available.setFont(new Font("Tahoma", Font.PLAIN, 12));
        add(available);

        String availableoption[] = {"AVAILABLE", "OCCUPIED"};
        availablecombo = new JComboBox(availableoption);
        availablecombo.setBounds(200, 240, 150, 30);
        availablecombo.setBackground(Color.WHITE);
        add(availablecombo);

        JLabel location = new JLabel("LOCATION");
        location.setBounds(60, 280, 130, 30);
        location.setFont(new Font("Tahoma", Font.PLAIN, 12));
        add(location);

        flocation = new JTextField();
        flocation.setBounds(200, 280, 150, 30);
        add(flocation);

        //for  add button
        add = new JButton("ADD DRIVER");
        add.setBounds(60, 340, 130, 30);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        add(add);

        //for cancel button
        cancel = new JButton("CANCEL");
        cancel.setBounds(210, 340, 130, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);

        //for adding image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/eleven.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);//for scaling an image
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 50, 500, 300);
        add(image);

        setTitle("Add Driver");
        getContentPane().setBackground(Color.WHITE);
        setLocationRelativeTo(null); // Center the frame
        setBounds(300, 280, 980, 450);
        setVisible(true);

    }

    public static void main(String[] args) {
        new AddDriver();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
          //getting values from radio button
            String gender = null;
            if (rbmale.isSelected()) {
                gender = "MALE";
            } else if (rbfemale.isSelected()) {
                gender = "FEMALE";
            }

        if (e.getSource() == add) {
            
            String name = fname.getText();//from field
            String age = fage.getText();
            String company = fcompany.getText();
            String model = fmodel.getText();
            String available = (String) availablecombo.getSelectedItem();//from combobox
            String location = flocation.getText();

            try {
                Conn conn = new Conn();
                String str = "insert into driver values('" + name + "','" + age + "','" + gender + "','" + company + "','" + model + "','" + available + "','" + location + "')";
                conn.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null, "NEW DRIVER ADDED SUCCESSFULLY");
                setVisible(false);
            } catch (Exception ae) {
                ae.printStackTrace();
            }
       
        } else {
            setVisible(false);
        }
    }

}

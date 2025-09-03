package hotel.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

public class Login extends JFrame implements ActionListener {

    JTextField username;
    JPasswordField password;
    JButton login, cancel;

    Login() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel user = new JLabel("Username");
        user.setBounds(40, 20, 100, 30);
        add(user);

        username = new JTextField();
        username.setBounds(150, 20, 150, 30);
        add(username);

        JLabel pass = new JLabel("Password");
        pass.setBounds(40, 70, 100, 30);
        add(pass);

        password = new JPasswordField();
        password.setBounds(150, 70, 150, 30);
        add(password);

        login = new JButton("Login");
        login.setBounds(40, 150, 120, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.setFont(new Font("italic", Font.PLAIN, 13));
        login.addActionListener(this);
        add(login);

        cancel = new JButton("Cancel");
        cancel.setBounds(180, 150, 120, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("italic", Font.PLAIN, 13));
        cancel.addActionListener(this);
        add(cancel);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);//for adjusting image
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 10, 200, 200);
        add(image);

        setTitle("Login");
        setBounds(500, 200, 600, 300);
        setLocationRelativeTo(null); // Center the frame inside window
        setVisible(true);
    }

    public static void main(String[] args) {
        new Login();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == login) {
            String user = username.getText();
            char[] passwordChars = password.getPassword();
            String enteredPassword = new String(passwordChars); // Convert to String for comparison (use carefully)

            try {
                Conn c = new Conn();
                String query = "select * from login where username = '" + user + "' and password='" + enteredPassword + "'";
                ResultSet rs = c.s.executeQuery(query);
                if (rs.next()) {
                    setVisible(false);
                    new Dashboard();
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Username And Password");
                    setVisible(false);
                     new Login();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == cancel) {
            setVisible(false);

        }
    }

}

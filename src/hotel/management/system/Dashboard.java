package hotel.management.system;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Dashboard extends JFrame implements ActionListener {

    Dashboard() {
        //(For finding screens dynamic width and height....in px)
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;
        System.out.println("screenWidth:" + screenWidth);
        System.out.println("screenHeight:" + screenHeight);

        setBounds(0, 0, screenWidth - 200, screenHeight - 200);

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
        Image i2 = i1.getImage().getScaledInstance(screenWidth, screenHeight, Image.SCALE_DEFAULT);//for adjusting image
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, screenWidth, screenHeight);
        add(image);

        JLabel text = new JLabel("THE TAJ GROUP WELCOMES YOU");
        text.setBounds(290, 60, 1000, 50);
        text.setForeground(Color.white);
        text.setFont(new Font("italic", Font.PLAIN, 50));
        image.add(text); //to add text on image

        JMenuBar mb = new JMenuBar();
        mb.setBounds(0, 0, 1550, 30);
        image.add(mb);

        JMenu hotel = new JMenu("HOTEL MANAGEMENT");
        hotel.setForeground(Color.red);
        mb.add(hotel);

        JMenuItem reception = new JMenuItem("RECEPTION");
        reception.addActionListener(this);
        hotel.add(reception);

        JMenu admin = new JMenu("ADMIN");
        admin.setForeground(Color.BLUE);
        mb.add(admin);

        JMenuItem employee = new JMenuItem("ADD EMPLOYEE");
        employee.addActionListener(this);
        admin.add(employee);

        JMenuItem room = new JMenuItem("ADD ROOM");
        room.addActionListener(this);
        admin.add(room);

        JMenuItem driver = new JMenuItem("ADD DRIVER");
        driver.addActionListener(this);
        admin.add(driver);

        setExtendedState(JFrame.MAXIMIZED_BOTH); ///open screen in maximise mode
        setLocationRelativeTo(null); // Center the frame
        setVisible(true);
        setTitle("Dashboard");
    }

    @Override
    //for click event
    public void actionPerformed(ActionEvent ae) {
        //for get menu deta....getActionCommond
        if (ae.getActionCommand().equals("ADD EMPLOYEE")) {
            new AddEmployee();
        } else if (ae.getActionCommand().equals("ADD ROOM")) {
            new AddRoom();
        } else if (ae.getActionCommand().equals("ADD DRIVER")) {
            new AddDriver();
        } else if (ae.getActionCommand().equals("RECEPTION")) {
            new Reception();
        }

    }

    public static void main(String[] args) {
        new Dashboard();
    }

}

package hotel.management.system;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Reception extends JFrame {

    Reception() {
        setLayout(null);

        JButton newcoustmer = new JButton("NEW COUSTMER FORM");
        newcoustmer.setBounds(10, 30, 200, 30);
        newcoustmer.setBackground(Color.BLACK);
        newcoustmer.setForeground(Color.WHITE);
        add(newcoustmer);

        JButton room = new JButton("ROOMS");
        room.setBounds(10, 70, 200, 30);
        room.setBackground(Color.BLACK);
        room.setForeground(Color.WHITE);
        add(room);

        JButton department = new JButton("DEPATMENT");
        department.setBounds(10, 110, 200, 30);
        department.setBackground(Color.BLACK);
        department.setForeground(Color.WHITE);
        add(department);

        JButton allemployee = new JButton("ALL EMPLOYEE");
        allemployee.setBounds(10, 150, 200, 30);
        allemployee.setBackground(Color.BLACK);
        allemployee.setForeground(Color.WHITE);
        add(allemployee);

        JButton cinfo = new JButton("COUSTMER INFO");
        cinfo.setBounds(10, 190, 200, 30);
        cinfo.setBackground(Color.BLACK);
        cinfo.setForeground(Color.WHITE);
        add(cinfo);

        JButton minfo = new JButton("MANAGER INFO");
        minfo.setBounds(10, 230, 200, 30);
        minfo.setBackground(Color.BLACK);
        minfo.setForeground(Color.WHITE);
        add(minfo);

        JButton checkout = new JButton("CHECKOUT");
        checkout.setBounds(10, 270, 200, 30);
        checkout.setBackground(Color.BLACK);
        checkout.setForeground(Color.WHITE);
        add(checkout);

        JButton ustatus = new JButton("UPDATE STATUS");
        ustatus.setBounds(10, 310, 200, 30);
        ustatus.setBackground(Color.BLACK);
        ustatus.setForeground(Color.WHITE);
        add(ustatus);

        JButton rstatus = new JButton("UPDATE ROOM STATUS");
        rstatus.setBounds(10, 350, 200, 30);
        rstatus.setBackground(Color.BLACK);
        rstatus.setForeground(Color.WHITE);
        add(rstatus);

        JButton pickup = new JButton("PICKUP SERVICE");
        pickup.setBounds(10, 390, 200, 30);
        pickup.setBackground(Color.BLACK);
        pickup.setForeground(Color.WHITE);
        add(pickup);

        JButton searchr = new JButton("SEARCH ROOM");
        searchr.setBounds(10, 430, 200, 30);
        searchr.setBackground(Color.BLACK);
        searchr.setForeground(Color.WHITE);
        add(searchr);

        JButton logout = new JButton("LOGOUT");
        logout.setBounds(10, 430, 200, 30);
        logout.setBackground(Color.BLACK);
        logout.setForeground(Color.WHITE);
        add(logout);

        //for adding image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fourth.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(250, 30, 500, 450);
        add(image);

        setTitle("Reception");
        getContentPane().setBackground(Color.WHITE);
        setBounds(350, 230, 800, 550);
        setLocationRelativeTo(null); // Center the frame
        setVisible(true);

    }

    public static void main(String[] args) {
        new Reception();
    }

}

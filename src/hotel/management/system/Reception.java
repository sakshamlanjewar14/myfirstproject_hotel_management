package hotel.management.system;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Reception extends JFrame implements ActionListener {

    JButton newcoustmer, room, department, allemployee, cinfo,
            minfo, searchr,ustatus,rstatus,pickup,checkout,logout;

    Reception() {
        setLayout(null);

        newcoustmer = new JButton("NEW COUSTMER FORM");
        newcoustmer.setBounds(10, 30, 200, 30);
        newcoustmer.setBackground(Color.BLACK);
        newcoustmer.setForeground(Color.WHITE);
        newcoustmer.addActionListener(this);
        add(newcoustmer);

        room = new JButton("ROOMS");
        room.setBounds(10, 70, 200, 30);
        room.setBackground(Color.BLACK);
        room.setForeground(Color.WHITE);
        room.addActionListener(this);
        add(room);

        department = new JButton("DEPATMENT");
        department.setBounds(10, 110, 200, 30);
        department.setBackground(Color.BLACK);
        department.setForeground(Color.WHITE);
        department.addActionListener(this);
        add(department);

        allemployee = new JButton("ALL EMPLOYEE");
        allemployee.setBounds(10, 150, 200, 30);
        allemployee.setBackground(Color.BLACK);
        allemployee.setForeground(Color.WHITE);
        allemployee.addActionListener(this);
        add(allemployee);

        cinfo = new JButton("COUSTMER INFO");
        cinfo.setBounds(10, 190, 200, 30);
        cinfo.setBackground(Color.BLACK);
        cinfo.setForeground(Color.WHITE);
        cinfo.addActionListener(this);
        add(cinfo);

        minfo = new JButton("MANAGER INFO");
        minfo.setBounds(10, 230, 200, 30);
        minfo.setBackground(Color.BLACK);
        minfo.setForeground(Color.WHITE);
        minfo.addActionListener(this);
        add(minfo);

        checkout = new JButton("CHECKOUT");
        checkout.setBounds(10, 270, 200, 30);
        checkout.setBackground(Color.BLACK);
        checkout.setForeground(Color.WHITE);
        checkout.addActionListener(this);
        add(checkout);

         ustatus = new JButton("UPDATE CHECKIN STATUS");
        ustatus.setBounds(10, 310, 200, 30);
        ustatus.setBackground(Color.BLACK);
        ustatus.setForeground(Color.WHITE);
        ustatus.addActionListener(this);
        add(ustatus);

         rstatus = new JButton("UPDATE ROOM STATUS");
        rstatus.setBounds(10, 350, 200, 30);
        rstatus.setBackground(Color.BLACK);
        rstatus.setForeground(Color.WHITE);
        rstatus.addActionListener(this);
        add(rstatus);

        pickup = new JButton("PICKUP SERVICE");
        pickup.setBounds(10, 390, 200, 30);
        pickup.setBackground(Color.BLACK);
        pickup.setForeground(Color.WHITE);
        pickup.addActionListener(this);
        add(pickup);

        searchr = new JButton("SEARCH ROOM");
        searchr.setBounds(10, 430, 200, 30);
        searchr.setBackground(Color.BLACK);
        searchr.setForeground(Color.WHITE);
        searchr.addActionListener(this);
        add(searchr);

         logout = new JButton("LOGOUT");
        logout.setBounds(10, 470, 200, 30);
        logout.setBackground(Color.BLACK);
        logout.setForeground(Color.WHITE);
        logout.addActionListener(this);
        add(logout);

        //for adding image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fourth.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(250, 30, 500, 450);
        add(image);

        setTitle("Reception");
        getContentPane().setBackground(Color.WHITE);
        setBounds(300, 150, 800, 550);
        //setLocationRelativeTo(null); // Center the frame
        setVisible(true);

    }

    public static void main(String[] args) {
        new Reception();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == newcoustmer) {
            setVisible(false);
            new AddCoustmer();
        } else if (e.getSource() == room) {
            setVisible(false);
            new Room();
        } else if (e.getSource() == department) {
            setVisible(false);
            new Department();
        } else if (e.getSource() == allemployee) {
            setVisible(false);
            new EmployeeInfo();
        } else if (e.getSource() == minfo) {
            setVisible(false);
            new ManagerInfo();
        } else if (e.getSource() == cinfo) {
            setVisible(false);
            new CoustmerInfo();
        } else if (e.getSource() == searchr) {
            setVisible(false);
            new SearchRoom();
        } else if (e.getSource() == ustatus) {
            setVisible(false);
            new UpdateCheck();
        }else if (e.getSource() == rstatus) {
            setVisible(false);
            new UpdateRoom();
        }else if (e.getSource() == pickup) {
            setVisible(false);
            new Pickup();
        }
        else if (e.getSource() == checkout) {
            setVisible(false);
            new Checkout();
        }else if (e.getSource() == logout) {
            setVisible(false);
          System.exit(0);
        }
    }

}

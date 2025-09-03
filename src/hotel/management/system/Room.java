package hotel.management.system;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import java.sql.*;
import javax.swing.JButton;
import net.proteanit.sql.DbUtils;

public class Room extends JFrame implements ActionListener {

    JTable table;
    JButton back;

    Room() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/eight.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 600, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(500, 0, 600, 600);
        add(image);

        table = new JTable();
        table.setBounds(0, 40, 500, 400);
        add(table);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from room");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel l1 = new JLabel("ROOM NUMBER");
        l1.setBounds(0, 10, 100, 20);
        add(l1);

        JLabel l2 = new JLabel("AVAILABILITY");
        l2.setBounds(105, 10, 100, 20);
        add(l2);

        JLabel l3 = new JLabel("STATUS");
        l3.setBounds(200, 10, 100, 20);
        add(l3);

        JLabel l4 = new JLabel("PRICE");
        l4.setBounds(300, 10, 100, 20);
        add(l4);

        JLabel l5 = new JLabel("BED TYPE");
        l5.setBounds(400, 10, 100, 20);
        add(l5);

        back = new JButton("BACK");
        back.setBounds(180, 500, 120, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        setBounds(190, 150, 1050, 580);
        setVisible(true);
        setTitle("Room Info");

    }

    public static void main(String[] args) {
        new Room();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new Reception();
    }
}

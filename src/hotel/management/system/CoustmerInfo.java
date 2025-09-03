package hotel.management.system;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import java.sql.*;
import javax.swing.JButton;
import net.proteanit.sql.DbUtils;

public class CoustmerInfo extends JFrame implements ActionListener {

    JTable table;
    JButton back;

    CoustmerInfo() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        table = new JTable();
        table.setBounds(0, 40, 1000, 400);
        add(table);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from coustmer");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel l1 = new JLabel("DOCUMENT");
        l1.setBounds(40, 10, 100, 20);
        add(l1);

        JLabel l2 = new JLabel("NUMBER");
        l2.setBounds(180, 10, 100, 20);
        add(l2);

        JLabel l3 = new JLabel("NAME");
        l3.setBounds(280, 10, 100, 20);
        add(l3);

        JLabel l4 = new JLabel("GENDER");
        l4.setBounds(410, 10, 100, 20);
        add(l4);

        JLabel l5 = new JLabel("COUNTRY");
        l5.setBounds(530, 10, 100, 20);
        add(l5);

        JLabel l6 = new JLabel("ROOM NO.");
        l6.setBounds(650, 10, 100, 20);
        add(l6);
        
          JLabel l7 = new JLabel("CHECKIN");
        l7.setBounds(780, 10, 100, 20);
        add(l7);
        
         JLabel l8 = new JLabel("DEPOSIT");
        l8.setBounds(890, 10, 100, 20);
        add(l8);
        

        back = new JButton("BACK");
        back.setBounds(420, 470, 120, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        setBounds(200, 150, 1000, 560);
        setVisible(true);
        setTitle("Coustmer Info");
        
    }

    public static void main(String[] args) {
        new CoustmerInfo();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new Reception();
    }
}

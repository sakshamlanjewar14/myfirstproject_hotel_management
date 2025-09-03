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

public class Department extends JFrame implements ActionListener {

    JTable table;
    JButton back;

    Department() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel l1 = new JLabel("DEPARTMENT");
        l1.setBounds(120, 10, 100, 20);
        add(l1);

        JLabel l2 = new JLabel("BUDGET");
        l2.setBounds(480, 10, 100, 20);
        add(l2);

        table = new JTable();
        table.setBounds(0, 50, 700, 350);
        add(table);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from department");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }

        back = new JButton("BACK");
        back.setBounds(280, 420, 120, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        
        setBounds(350, 160, 700, 550);
        setVisible(true);
        setTitle("Department");
     
    }

    public static void main(String[] args) {
        new Department();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new Reception();
    }
}

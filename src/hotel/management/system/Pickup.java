package hotel.management.system;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import java.sql.*;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import net.proteanit.sql.DbUtils;

public class Pickup extends JFrame implements ActionListener {

    JTable table;
    JButton back, submit;
    Choice car;
    JCheckBox available;

    Pickup() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel text = new JLabel("PICKUP SERVICE");
        text.setFont(new Font("Raleway", Font.BOLD, 16));
        text.setBounds(400, 20, 200, 30);
        add(text);

        JLabel type = new JLabel("TYPE OF CAR");
        type.setBounds(50, 70, 100, 30);
        add(type);

        car = new Choice();     //for choicebox
        car.setBounds(200, 70, 100, 30);
        add(car);
        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from driver");
            while (rs.next()) {
                car.add(rs.getString("model"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        add(car);

        table = new JTable();
        table.setBounds(0, 150, 1000, 190);
        add(table);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from driver");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel l1 = new JLabel("NAME");
        l1.setBounds(50, 120, 100, 20);
        add(l1);

        JLabel l2 = new JLabel("AGE");
        l2.setBounds(200, 120, 100, 20);
        add(l2);

        JLabel l3 = new JLabel("GENDER");
        l3.setBounds(330, 120, 100, 20);
        add(l3);

        JLabel l4 = new JLabel("COMPANY");
        l4.setBounds(470, 120, 100, 20);
        add(l4);

        JLabel l5 = new JLabel("MODEL ");
        l5.setBounds(630, 120, 100, 20);
        add(l5);

        JLabel l6 = new JLabel("AVAILABILITY");
        l6.setBounds(750, 120, 100, 20);
        add(l6);

        JLabel l7 = new JLabel("LOCATION ");
        l7.setBounds(870, 120, 100, 20);
        add(l7);

        submit = new JButton("SUBMIT");
        submit.setBounds(300, 480, 120, 30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);

        back = new JButton("BACK");
        back.setBounds(500, 480, 120, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        setBounds(200, 150, 1000, 560);
        setVisible(true);
        setTitle("Pickup Service");

    }

    public static void main(String[] args) {
        new Pickup();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {
            try {
                String query = "select * from driver where model='" + car.getSelectedItem() + "'";

                Conn conn = new Conn();
                ResultSet rs;
                rs = conn.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception ae) {
                ae.printStackTrace();
            }
        } else {
            setVisible(false);
            new Reception();
        }
    }
}

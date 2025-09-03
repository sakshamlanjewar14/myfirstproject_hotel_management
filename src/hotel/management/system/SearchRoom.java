package hotel.management.system;

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

public class SearchRoom extends JFrame implements ActionListener {

    JTable table;
    JButton back, submit;
    JComboBox bedtype;
    JCheckBox available;

    SearchRoom() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel text = new JLabel("SEARCH FOR ROOM");
        text.setFont(new Font("Raleway", Font.BOLD, 16));
        text.setBounds(400, 30, 200, 30);
        add(text);

        JLabel type = new JLabel("BED TYPE");
        type.setBounds(50, 100, 100, 30);
        add(type);

        bedtype = new JComboBox(new String[]{"SINGLE BED","DOUBLE BED"});
        bedtype.setBounds(160, 100, 200, 30);
        bedtype.setBackground(Color.WHITE);
        add(bedtype);

        available = new JCheckBox("ONLY DISPLAY AVAILABLE");
        available.setBounds(650, 100, 200, 35);
        available.setBackground(Color.WHITE);
        add(available);

        table = new JTable();
        table.setBounds(0, 200, 1000, 300);
        add(table);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from room");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel l1 = new JLabel("ROOM NUMBER");
        l1.setBounds(50, 180, 100, 20);
        add(l1);

        JLabel l2 = new JLabel("AVAILABILITY");
        l2.setBounds(260, 180, 100, 20);
        add(l2);

        JLabel l3 = new JLabel("STATUS");
        l3.setBounds(480, 180, 100, 20);
        add(l3);

        JLabel l4 = new JLabel("PRICE");
        l4.setBounds(680, 180, 100, 20);
        add(l4);

        JLabel l5 = new JLabel("BED TYPE");
        l5.setBounds(870, 180, 100, 20);
        add(l5);

        submit = new JButton("SUBMIT");
        submit.setBounds(300, 500, 120, 30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);

        back = new JButton("BACK");
        back.setBounds(500, 500, 120, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        setBounds(200, 150, 1000, 580);
        setVisible(true);
         setTitle("Search Room");
        
    }

    public static void main(String[] args) {
        new SearchRoom();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {
            try {
                String query1 = "select * from room where bed_type='" + bedtype.getSelectedItem() + "'";
                String query2 = "select * from room where availability= 'AVAILABLE' AND  bed_type='" + bedtype.getSelectedItem() + "'";
                
                Conn conn = new Conn();
                ResultSet rs;
                if(available.isSelected()){
                    rs = conn.s.executeQuery(query2);
                }
                else{
                     rs = conn.s.executeQuery(query1);
                }
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

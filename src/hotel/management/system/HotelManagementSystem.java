package hotel.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class HotelManagementSystem extends JFrame implements ActionListener{

    HotelManagementSystem(){
        ImageIcon imageIcon= new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
        JLabel imageLabel = new JLabel(imageIcon);
        imageLabel.setBounds(0,0,1366, 565);//Location x.Location y,Length,Breadth
        add(imageLabel);
        
        JLabel text = new JLabel("HOTEL MANAGEMENT SYSTEM");
        text.setBounds(20,430,1000,80);
        text.setForeground(Color.white);
        text.setFont(new Font("italic",Font.PLAIN,50));
        imageLabel.add(text); //to add text on image
        
        JButton next = new JButton("NEXT");
        next.setBounds(1150,450,80,50);
        next.setBackground(Color.WHITE);
        next.setForeground(Color.magenta);
        next.setFont(new Font("italic",Font.PLAIN,15));
        next.addActionListener(this);
        imageLabel.add(next);
        
        
        
        
        setSize(1366, 565);
        //setLocation(10,10);
        setLocationRelativeTo(null); // Center the frame
        setVisible(true);
        
        while(true)   
        {
            text.setVisible(false);
            try{
                Thread.sleep(500);
            }
            catch(Exception e){
                e.printStackTrace();
            }
             text.setVisible(true);
              try{
                Thread.sleep(500);
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
      // setBounds(100, 100, 1366, 565);
       // setLayout(null);
    }
   
    public static void main(String[] args){
       new HotelManagementSystem ();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new Login();
    }
    
}

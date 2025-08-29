package hotel.management.system;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;

public class Conn {
    
    Connection c;
    Statement s;
    
    Conn(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");//Register driver
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagementsystem","root","root");//Creating Connection
            s = c.createStatement(); //Creating Statement
        }
        catch(Exception e){
            e.printStackTrace();
        } 
    }
    
}

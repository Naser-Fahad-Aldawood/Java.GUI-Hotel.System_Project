

package Hotel_project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Hotel_Project extends JFrame {
    
    static Connection connection_1;
    static Statement st;
    static Statement stTemp;
    static ResultSet rs;

    public  Hotel_Project(){
        
    }

    

    public static void main(String[] args) {
        try {
            connection_1 = DriverManager.getConnection("jdbc:derby://localhost:1527/Hotel", "hotelAdmin", "1234");
            st = connection_1.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            JOptionPane.showMessageDialog(null, "Connection Complete");
        } catch (SQLException ex) {
            Logger.getLogger(Hotel_Project.class.getName()).log(Level.SEVERE, null, ex);
        }
        loginClass loginFrame = new loginClass();
        
    }
    
}

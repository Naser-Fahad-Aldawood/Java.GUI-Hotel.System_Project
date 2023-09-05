package Hotel_project;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class loginClass extends JFrame {

    
    JPanel panel_22 = new JPanel();
    JLabel label_ID = new JLabel("Enter Employeee ID: ");
    JLabel label_Password = new JLabel("Enter Password: ");

    JTextField field_ID = new JTextField(20);
    JPasswordField field_Password = new JPasswordField(20);

    JButton button_Login = new JButton("Login");
    JButton button_Reset = new JButton("Reset");

    public loginClass() {
        setLayout(null);
        setSize(350, 210);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBackground(Color.yellow);
        Login_drwa draw_1 = new Login_drwa(); 
        add(draw_1);
        draw_1.setBounds(0,0,100,200);
        
        
        //add(panel_22, BorderLayout.CENTER);
        add(panel_1);
        add(label_ID);
        label_ID.setBounds(100,0,200,50);
        add(field_ID);
        field_ID.setBounds(100,40,200,20);

        add(label_Password);
        label_Password.setBounds(100,65,200,20);
        add(field_Password);
        field_Password.setBounds(100,90,200,20);
        
        add(button_Login);
        button_Login.setBounds(100,120,90,30);
        
        add(button_Reset);
        button_Reset.setBounds(210,120,90,30);
        
        
        
        button_Login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    Hotel_Project.st = Hotel_Project.connection_1.createStatement();
                    Hotel_Project.rs = Hotel_Project.st.executeQuery("SELECT * FROM UNTITLED WHERE EMP_ID = " + field_ID.getText() + " AND EMP_PASSWORD = '" + field_Password.getText() + "'");
                    if (Hotel_Project.rs.next()) {
                        
                        
                        JOptionPane.showMessageDialog(null, "Login Complete");
                        workFrame mainframe = new workFrame();
                        loginClass.this.dispose();
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Login info incorrect");
                    }
                    

                    
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }

            }

        });

        //add(button_Reset);

        button_Reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                field_ID.setText("");
                field_Password.setText("");
            }
        });

    }

}


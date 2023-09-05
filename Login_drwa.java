package Hotel_project;

import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.event.*;
import java.util.Random;

public class Login_drwa extends JPanel {

    JTextField t1 = new JTextField(20);
    JPasswordField p1 = new JPasswordField(20);

    JButton b1 = new JButton("Login");
    JButton b2 = new JButton("Reset");

    public Login_drwa() {
        setLayout(null);

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        
        g2.setColor(Color.WHITE);

        g2.setColor(Color.BLACK);

        g2.setStroke(new BasicStroke(10));
        g2.drawArc(30, 40, 40, 60, 180, -180);
        g2.fillRoundRect(20, 70, 60, 50, 10, 10);
        g2.setColor(Color.white);
        g2.fillOval(43, 80, 15, 15);
        g2.fillRect(48, 90, 5, 20);
        g2.setColor(Color.black);

        g2.translate(0, 0);

    }
}


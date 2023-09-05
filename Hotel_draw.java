

package Hotel_project;

import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.event.*;
import java.util.Random;

public class Hotel_draw extends JPanel {
   JButton b1 = new JButton("Sign up");

   
    
     public void paintComponent(Graphics g){
     super.paintComponent(g);
     Graphics2D g2d = (Graphics2D) g;
     
     setBackground(Color.DARK_GRAY);
     g.setColor(Color.BLACK);//الشخص
     g.fillOval(210, 130, 180, 100);
     g.fillOval(255, 30, 90, 90);
     
     g.setColor(Color.ORANGE);//الجرس
     g.fillOval(140, 165, 50, 55);
     g.fillOval(159, 159, 10, 10);
     
     g.setColor(new Color (133,94,66));// الطاوله
     g.fillRect(100, 200, 400, 200);
     
     g.setColor(new Color(101,81,66));//اعلى الطاوله 
     g.fillOval(80, 180, 33, 27);
     g.fillOval(485, 180, 33, 27);
     g.fillRect(100, 180, 400, 27);
     
     
     g.setColor(new Color(85,60,42));//وسط الطاوله
     g.fillRect(115, 215, 370, 170);
     
     g.setColor(Color.ORANGE);// مكان لكتابة العبارة وسط الطاوله
     g.fillRect(190, 225, 220, 150);
     
     g.setColor(new Color(85,60,42));// الدوائر وسط الطاوله
     g.fillOval(160, 215, 60, 50);
     g.fillOval(170, 334, 60, 50);
     g.fillOval(375, 215, 60, 50);
     g.fillOval(375, 334, 60, 50);
     g.setFont(new Font("plain",Font.BOLD,30));
     g.drawString("RECEPTION", 215, 310);
     
     
     }

 
    
    
}

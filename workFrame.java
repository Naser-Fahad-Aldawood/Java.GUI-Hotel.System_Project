
package Hotel_project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class workFrame extends JFrame {

    //main frame 
    JLabel l1 = new JLabel("Enter User Name:");
    JLabel l2 = new JLabel("Enter Password:");

    JTextField t1 = new JTextField(20);
    JPasswordField p1 = new JPasswordField(20);

    JButton b1 = new JButton("Login");
    JButton b2 = new JButton("Clear");

    JMenuBar mb = new JMenuBar();
    JMenu m1 = new JMenu("Customer");
    JMenuItem menuItem_11 = new JMenuItem("Check in");
    JMenuItem menuItem_12 = new JMenuItem("Check out");

    JMenu m2 = new JMenu("Display");
    JMenuItem menuItem_21 = new JMenuItem("Customers Info");
    JMenuItem menuItem_22 = new JMenuItem("Employees Info");
    JMenuItem menuItem_23 = new JMenuItem("Rooms Info");

    JMenu m3 = new JMenu("Actions");
    JMenuItem menuItem_31 = new JMenuItem("Add a Room");
    JMenuItem menuItem_32 = new JMenuItem("Add an Employee");

    //Icon pic1 = new ImageIcon(getClass().getResource("hotel.jpeg"));
    JLabel l3 = new JLabel();

    // Check in Frame 
    JLabel label_21 = new JLabel("Customer ID");
    JTextField textField_21 = new JTextField(20);

    JLabel label_22 = new JLabel("Customer Name");
    JTextField textField_22 = new JTextField(20);

    JLabel label_23 = new JLabel("Room");
    JComboBox cBoxRooms;
    ArrayList<String> roomNumbers = new ArrayList<>();
    JButton button_21 = new JButton("Complete");

    // Check out Frame
    JLabel label_31 = new JLabel("Customer ID");
    JTextField textField_31 = new JTextField(20);
    JTextField textField_32 = new JTextField(20);
    JTextField textField_33 = new JTextField(20);
    JButton button_31 = new JButton("Confirm");

    // Admin Login frame
    JLabel label_41 = new JLabel("Admin ID:");
    JTextField textField_41 = new JTextField(20);
    JLabel label_42 = new JLabel("Password:");
    JPasswordField passwordField_41 = new JPasswordField(20);
    JButton button_41 = new JButton("Login");

    JLabel label_52 = new JLabel("Actions", SwingConstants.CENTER);
    JButton Button_54 = new JButton("Add a room");
    JLabel label_521 = new JLabel("Enter room number: ");
    JTextField textField_521 = new JTextField(20);
    JButton button_541 = new JButton("Confirm");
    JButton Button_55 = new JButton("Add an employee");
    JTextArea textArea_51 = new JTextArea(20, 20);

    //
    JLabel label_61 = new JLabel("Employee ID");
    JTextField textField_61 = new JTextField(20);
    JLabel label_62 = new JLabel("Employee name");
    JTextField textField_62 = new JTextField(20);
    JLabel label_63 = new JLabel("Employee Password");
    JPasswordField passwordField_61 = new JPasswordField(20);
    JButton button_61 = new JButton("Confirm");

    public workFrame() {
        setSize(600, 500);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Hotel System");
        setLocationRelativeTo(null);

        Hotel_draw d = new Hotel_draw();
        add(d, BorderLayout.CENTER);

        add(mb, BorderLayout.NORTH);
        mb.add(m1);
        mb.add(m2);
        mb.add(m3);
        m1.add(menuItem_11);
        m1.add(menuItem_12);

        m2.add(menuItem_21);
        m2.add(menuItem_22);
        m2.add(menuItem_23);

        m3.add(menuItem_31);
        m3.add(menuItem_32);

        menuItem_11.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                JFrame customerCheckIn = new JFrame();
                customerCheckIn.setLayout(new FlowLayout());
                customerCheckIn.setVisible(true);
                customerCheckIn.setSize(250, 300);
                customerCheckIn.setLocationRelativeTo(null);
                customerCheckIn.setBackground(Color.GRAY);
                customerCheckIn.add(label_21);
                customerCheckIn.add(textField_21);
                customerCheckIn.add(label_22);
                customerCheckIn.add(textField_22);
                customerCheckIn.add(label_23);

                roomNumbers.removeAll(roomNumbers);
                try {
                    Hotel_Project.st = Hotel_Project.connection_1.createStatement();
                    Hotel_Project.rs = Hotel_Project.st.executeQuery("SELECT * FROM rooms1 Where room_istaken = 'n'");

                    while (Hotel_Project.rs.next()) {
                        roomNumbers.add(Hotel_Project.rs.getString(1));
                    }

                    String[] array = roomNumbers.toArray(new String[roomNumbers.size()]);

                    if (roomNumbers.size() > 0) {

                        cBoxRooms = new JComboBox(array);
                        customerCheckIn.add(cBoxRooms);
                        customerCheckIn.add(button_21);
                        cBoxRooms.setPreferredSize(new Dimension(120, 20));
                        cBoxRooms.addItemListener(new ItemListener() {
                            @Override
                            public void itemStateChanged(ItemEvent e) {
                                System.out.println(cBoxRooms.getSelectedItem());
                            }
                        });

                        button_21.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent ae) {
                                try {

                                    Hotel_Project.stTemp = Hotel_Project.connection_1.createStatement();
                                    Hotel_Project.stTemp.executeUpdate("Insert into Customers (Customer_id, customer_name, customer_room, Customer_isstaying) values (" + textField_21.getText() + ",'" + textField_22.getText() + "'," + cBoxRooms.getSelectedItem() + ", true)");
                                    Hotel_Project.stTemp.executeUpdate("Update rooms1 set room_istaken = 'y' where room_number = " + cBoxRooms.getSelectedItem());
                                    JOptionPane.showMessageDialog(null, "Room Booked");
                                    customerCheckIn.dispose();
                                } catch (SQLException ex) {
                                    JOptionPane.showMessageDialog(null, ex);
                                    Logger.getLogger(workFrame.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                        });
                    } else {

                        JOptionPane.showMessageDialog(null, "No rooms available");
                        customerCheckIn.dispose();
                    }

                } catch (SQLException ex) {
                    Logger.getLogger(workFrame.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });

        menuItem_12.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                JFrame customerCheckOut = new JFrame();
                customerCheckOut.setLayout(new FlowLayout());
                customerCheckOut.setVisible(true);
                customerCheckOut.setSize(250, 200);
                customerCheckOut.setLocationRelativeTo(null);

                customerCheckOut.add(label_31);
                customerCheckOut.add(textField_31);
                customerCheckOut.add(button_31);

                button_31.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        try {

                            Hotel_Project.st = Hotel_Project.connection_1.createStatement();
                            Hotel_Project.rs = Hotel_Project.st.executeQuery("SELECT * FROM Customers Where Customer_id = " + textField_31.getText());
                            if (Hotel_Project.rs.next()) {
                                textField_32.setText(Hotel_Project.rs.getString(2));
                                Hotel_Project.stTemp = Hotel_Project.connection_1.createStatement();
                                Hotel_Project.stTemp.executeUpdate("UPDATE rooms1 set room_istaken = 'n' WHERE room_Number =" + Hotel_Project.rs.getInt(3));
                                Hotel_Project.stTemp.executeUpdate("DELETE FROM Customers WHERE Customer_id = " + textField_31.getText());
                                JOptionPane.showMessageDialog(null, "Check out Complete");
                                customerCheckOut.dispose();
                            } else {
                                JOptionPane.showMessageDialog(null, "Customer ID does not exist");
                            }
                        } catch (SQLException ex) {
                            JOptionPane.showMessageDialog(null, ex);
                            Logger.getLogger(workFrame.class.getName()).log(Level.SEVERE, null, ex);
                            customerCheckOut.dispose();
                        }
                    }
                });
            }
        });

        menuItem_21.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                JFrame textAreaFrame = new JFrame();
                textAreaFrame.setVisible(false);
                textAreaFrame.setSize(500, 500);
                textAreaFrame.setLocationRelativeTo(null);
                textAreaFrame.add(textArea_51);
                textArea_51.setEditable(false);
                textAreaFrame.setVisible(true);
                textArea_51.setText("Customer ID \t\tCustomer Name\tCustomer Room \n");
                try {
                    Hotel_Project.st = Hotel_Project.connection_1.createStatement();
                    Hotel_Project.rs = Hotel_Project.st.executeQuery("SELECT * FROM Customers");
                    while (Hotel_Project.rs.next()) {
                        textArea_51.append(Hotel_Project.rs.getString(1) + "\t|\t" + Hotel_Project.rs.getString(2) + "\t|\t" + Hotel_Project.rs.getString(3) + "\n");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(workFrame.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
        menuItem_22.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                JFrame textAreaFrame = new JFrame();
                textAreaFrame.setVisible(false);
                textAreaFrame.setSize(500, 500);
                textAreaFrame.setLocationRelativeTo(null);
                textAreaFrame.add(textArea_51);
                textArea_51.setEditable(false);
                textAreaFrame.setVisible(true);
                textAreaFrame.setVisible(true);
                textArea_51.setText("Employee ID\t\tEmployee Name\n");
                try {
                    textArea_51.setVisible(true);
                    Hotel_Project.st = Hotel_Project.connection_1.createStatement();
                    Hotel_Project.rs = Hotel_Project.st.executeQuery("SELECT * FROM untitled");
                    while (Hotel_Project.rs.next()) {
                        textArea_51.append(Hotel_Project.rs.getString(1) + "\t|\t" + Hotel_Project.rs.getString(2) + "\n");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(workFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        menuItem_23.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                JFrame textAreaFrame = new JFrame();
                textAreaFrame.setVisible(false);
                textAreaFrame.setSize(500, 500);
                textAreaFrame.setLocationRelativeTo(null);
                textAreaFrame.add(textArea_51);
                textArea_51.setEditable(false);
                textAreaFrame.setVisible(true);
                textAreaFrame.setVisible(true);
                textArea_51.setText("Room number\t\tIs taken\n");
                try {
                    textArea_51.setVisible(true);
                    Hotel_Project.st = Hotel_Project.connection_1.createStatement();
                    Hotel_Project.rs = Hotel_Project.st.executeQuery("SELECT * FROM rooms1");
                    while (Hotel_Project.rs.next()) {
                        textArea_51.append(Hotel_Project.rs.getString(1) + "\t|\t" + Hotel_Project.rs.getString(2) + "\n");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(workFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        menuItem_31.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                JFrame addRoom = new JFrame();
                addRoom.setVisible(true);
                addRoom.setSize(250, 200);
                addRoom.setLocationRelativeTo(null);
                addRoom.setLayout(new FlowLayout());
                addRoom.add(label_521);
                addRoom.add(textField_521);
                addRoom.add(button_541);
                button_541.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        try {
                            Hotel_Project.stTemp = Hotel_Project.connection_1.createStatement();
                            Hotel_Project.stTemp.executeUpdate("insert into rooms1 (room_number, room_istaken) values (" + textField_521.getText() + ", 'n')");
                            JOptionPane.showMessageDialog(null, "Room added");
                            addRoom.dispose();
                        } catch (SQLException ex) {
                            JOptionPane.showMessageDialog(null, ex);
                            Logger.getLogger(workFrame.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                });
            }
        });
        menuItem_32.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                JFrame addEmp = new JFrame();
                addEmp.setVisible(true);
                addEmp.setSize(250, 300);
                addEmp.setLocationRelativeTo(null);
                addEmp.setLayout(new FlowLayout());
                addEmp.add(label_61);
                addEmp.add(textField_61);
                addEmp.add(label_62);
                addEmp.add(textField_62);
                addEmp.add(label_63);
                addEmp.add(passwordField_61);
                addEmp.add(button_61);
                button_61.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        try {
                            Hotel_Project.stTemp = Hotel_Project.connection_1.createStatement();
                            Hotel_Project.stTemp.executeUpdate("Insert into untitled (emp_id, emp_name, emp_password) values (" + textField_61.getText() + ",'" + textField_62.getText() + "','" + passwordField_61.getText() + "')");
                            JOptionPane.showMessageDialog(null, "Employee added");
                        } catch (SQLException ex) {
                            Logger.getLogger(workFrame.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                });
            }
        });

        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == b2) {
                    t1.setText("");
                    p1.setText("");
                }
            }
        });
    }

}

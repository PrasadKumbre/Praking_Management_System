import com.sun.net.httpserver.Authenticator;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.*;
import java.util.Arrays;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Allocate_slots extends Main
{
    public static int check(JTextField t,String Sql) {
        int r = 0;
        try {
            //String Sql ="SELECT id FROM pms.parking_slots where type='"+type+"' and Status='Available' Limit 1" ;
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pms", "root", "root");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(Sql);
            r = 0;
            while (rs.next()) {
                int s = rs.getInt(1);
                String i = Integer.toString(s);
                t.setText(i);
                r++;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return r;
    }
    public static int insert(String p_id,String p_type,String v_id,String v_no,String c_id,String c_no,String date,String time)
    {
        int i =0;
        try{
            int id=Integer.parseInt(p_id);
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pms", "root", "root");
            String SQL ="insert into current_allocation values(?,?,?,?,?,?,?,?,?)";
            String SQL1 ="update parking_slots SET Status = 'UnAvailable' where id="+id;
            PreparedStatement pst = con.prepareStatement(SQL);
            pst.setInt(1, 0);
            pst.setString(2, p_id);
            pst.setString(3, p_type);
            pst.setString(4, v_id);
            pst.setString(5, v_no);
            pst.setString(6, c_id);
            pst.setString(7, c_no);
            pst.setString(8, date);
            pst.setString(9, time);
            pst.execute();
            Statement st = con.createStatement();
            st.executeUpdate(SQL1);
            i++;
        }
        catch (Exception e)
        {
            System.out.println(e);
            setWarningMsg(e.toString());
        }
        return i;
    }
    public static void main(String [] args)
    {
        try {
            var a = new Allocate_slots();
            String [] choices ={"Select","Bike","Car"};
            JFrame f = new JFrame("Parking Management System");
            JLabel Main_heading = new JLabel("   Allocate Parking Slots");
            Main_heading.setBounds(800, 105, 350, 50);
            Main_heading.setFont(new Font("Verdana", Font.BOLD, 24));
            Main_heading.setOpaque(true);
            Border blackline = BorderFactory.createLineBorder(Color.black);
            Main_heading.setBorder(blackline);
            JLabel bg = new JLabel();
            JLabel slot = new JLabel("Select the type");
            JComboBox<String> type = new JComboBox<String>(choices);
            JTextField park_id = new JTextField();
            JButton park_check = new JButton("Check");
            JButton current_allocation = new JButton("See the Current_Allocation");
            JLabel vehicle = new JLabel("Enter Vehicle No");
            JTextField vehicle_number = new JTextField("MH-12-");
            JTextField vehicle_id = new JTextField();
            JButton vehicle_check = new JButton("Check");
            JLabel customer = new JLabel("Enter Customer No");
            JTextField customer_number = new JTextField();
            JTextField customer_id = new JTextField();
            JButton customer_check = new JButton("Check");
            JLabel time = new JLabel("Current Time");
            JTextField time_input = new JTextField();
            JLabel date = new JLabel("Current Date");
            JTextField date_input = new JTextField();
            JButton Allocate = new JButton("Allocate Slot");
            JButton Clear = new JButton("Clear");
            current_allocation.setBounds(1475,825,400,50);
            Allocate.setBounds(750,550,300,50);
            Clear.setBounds(1100,550,300,50);
            slot.setBounds(400,200,200,50);
            type.setBounds(400,275,200,50);
            park_id.setBounds(400,350,200,50);
            park_check.setBounds(400,425,200,50);
            bg.setBounds(385,190,1500,325);
            vehicle.setBounds(700,200,250,50);
            vehicle_number.setBounds(700,275,220,50);
            vehicle_id.setBounds(700,350,220,50);
            vehicle_check.setBounds(700,425,220,50);
            customer.setBounds(1000,200,250,50);
            customer_number.setBounds(1000,275,220,50);
            customer_id.setBounds(1000,350,220,50);
            customer_check.setBounds(1000,425,220,50);
            time.setBounds(1300,200,250,50);
            time_input.setBounds(1300,275,220,50);
            date.setBounds(1600,200,220,50);
            date_input.setBounds(1600,275,220,50);
            customer.setFont(new Font("Verdana", Font.PLAIN, 25));
            customer_number.setFont(new Font("Verdana", Font.PLAIN, 25));
            customer_id.setFont(new Font("Verdana", Font.PLAIN, 25));
            customer_check.setFont(new Font("Verdana", Font.PLAIN, 25));
            current_allocation.setFont(new Font("Verdana", Font.PLAIN, 25));
            slot.setFont(new Font("Verdana", Font.PLAIN, 25));
            type.setFont(new Font("Verdana", Font.PLAIN, 25));
            park_id.setFont(new Font("Verdana", Font.PLAIN, 25));
            park_check.setFont(new Font("Verdana", Font.PLAIN, 25));
            vehicle.setFont(new Font("Verdana", Font.PLAIN, 25));
            vehicle_number.setFont(new Font("Verdana", Font.PLAIN, 25));
            vehicle_id.setFont(new Font("Verdana", Font.PLAIN, 25));
            vehicle_check.setFont(new Font("Verdana", Font.PLAIN, 25));
            time.setFont(new Font("Verdana", Font.PLAIN, 25));
            time_input.setFont(new Font("Verdana", Font.PLAIN, 25));
            date.setFont(new Font("Verdana", Font.PLAIN, 25));
            date_input.setFont(new Font("Verdana", Font.PLAIN, 25));
            Allocate.setFont(new Font("Verdana", Font.BOLD, 25));
            Clear.setFont(new Font("Verdana", Font.BOLD, 25));
            bg.setBorder(blackline);
            park_id.setBackground(Color.white);
            vehicle_id.setBackground(Color.white);
            customer_id.setBackground(Color.white);
            date_input.setBackground(Color.white);
            time_input.setBackground(Color.white);
            Allocate.setBackground(Color.white);
            Clear.setBackground(Color.white);
            current_allocation.setBackground(Color.white);
            current_allocation.setForeground(Color.RED);
            //Allocate.setForeground(Color.white);
            park_id.setEditable(false);
            f.add(slot);
            f.add(type);
            f.add(park_id);
            f.add(park_check);
            f.add(Allocate);
            f.add(current_allocation);
            vehicle_id.setEditable(false);
            f.add(vehicle);
            f.add(vehicle_id);
            f.add(vehicle_number);
            f.add(vehicle_check);
            customer_id.setEditable(false);
            f.add(customer);
            f.add(customer_id);
            f.add(customer_number);
            f.add(customer_check);
            date_input.setEditable(false);
            time_input.setEditable(false);
            f.add(time);
            f.add(time_input);
            f.add(date);
            f.add(date_input);
            f.add(Clear);
            f.add(bg);
            park_check.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String s = type.getSelectedItem().toString();
                    if(s.equals("Select"))
                    {
                        setWarningMsg("Pls Select the Type");
                    }
                    else {
                        park_id.setText("");
                        String Sql ="SELECT id FROM pms.parking_slots where type='"+s+"' and Status='Available' Limit 1";
                        int i=check(park_id,Sql);
                        if(i==0)
                        {
                            setWarningMsg("No Any Empty Slots Available for " + s);
                        }
                    }
                }

            });

            vehicle_check.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String s = vehicle_number.getText();
                    String t =type.getSelectedItem().toString();
                    vehicle_id.setText("");
                    String Sql = "Select id from vehicle where Number ='"+s+"'and Type='"+t+"'";
                    if(park_id.getText().isEmpty())
                    {
                        setWarningMsg("Pls Select the Parking Slot");
                    }
                    else if(s.isEmpty())
                    {
                        setWarningMsg("Pls Enter the Vehicle No");
                    }
                    else {
                        int i = check(vehicle_id, Sql);
                        if(i==0)
                        {
                            setWarningMsg("Vehicle not find in DB. Pls add details");
                        }
                    }
                }
            });

            customer_check.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String s = customer_number.getText();
                    customer_id.setText("");
                    String Sql = "Select id from customer where mobile ='"+s+"'";
                    if(park_id.getText().isEmpty()||vehicle_id.getText().isEmpty())
                    {
                        setWarningMsg("Pls Select the Parking Slot And Vehicle first");
                    }
                    else if(s.isEmpty())
                    {
                        setWarningMsg("Pls Enter the Customer Mobile No");
                    }
                    else {
                        int i = check(customer_id, Sql);
                        if(i==0)
                        {
                            setWarningMsg("Customer not find in DB. Pls add details");
                        }
                    }
                }
            });
            Allocate.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String parking_id = park_id.getText();
                    String parking_type = type.getSelectedItem().toString();
                    String veh_id = vehicle_id.getText();
                    String veh_num = vehicle_number.getText();
                    String c_id = customer_id.getText();
                    String c_no = customer_number.getText();
                    String time = time_input.getText();
                    String date = date_input.getText();

                    if(parking_id.isEmpty()||parking_type.isEmpty()||veh_id.isEmpty()||veh_num.isEmpty()||c_id.isEmpty()||c_no.isEmpty()||time.isEmpty()||date.isEmpty())
                    {
                        setWarningMsg("Some Fields are Missing");
                    }
                    else {
                        int i=insert(parking_id,parking_type,veh_id,veh_num,c_id,c_no,date,time);
                        if(i==1)
                        {
                            JOptionPane.showMessageDialog(null, "Allocation is Successful");
                            type.setSelectedItem(choices[0]);
                            park_id.setText("");
                            vehicle_number.setText("");
                            vehicle_id.setText("");
                            customer_id.setText("");
                            customer_number.setText("");
                        }
                        else
                        {
                            setWarningMsg("Allocation of Vehicle Failed");
                        }

                    }
                }

            });
            Clear.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                 type.setSelectedItem(choices[0]);
                 park_id.setText("");
                 vehicle_number.setText("MH-12-");
                 vehicle_id.setText("");
                 customer_id.setText("");
                 customer_number.setText("");
                }

            });
            current_allocation.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        Runtime.getRuntime().exec("\"C:\\Program Files\\Java\\jdk-18.0.2.1\\bin\\java.exe\" \"-javaagent:C:\\Program Files\\JetBrains\\IntelliJ IDEA Community Edition 2022.3\\lib\\idea_rt.jar=50556:C:\\Program Files\\JetBrains\\IntelliJ IDEA Community Edition 2022.3\\bin\" -Dfile.encoding=UTF-8 -Dsun.stdout.encoding=UTF-8 -Dsun.stderr.encoding=UTF-8 -classpath \"C:\\Users\\prasa\\Desktop\\Parking Managment System\\out\\production\\Parking Managment System;C:\\Program Files (x86)\\MySQL\\Connector J 8.0\\mysql-connector-j-8.0.33.jar\" Current_allocation");
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            });
            a.main_side(f,2);
            f.add(Main_heading);
            a.NavbarFooter(f,"t");
            Thread clock = new Thread() {
                public void run() {
                    while(true) {

                        Date date = new Date();
                        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
                        String formattedDate = formatter.format(date);
                        time_input.setText(formattedDate);

                        SimpleDateFormat formatter1 = new SimpleDateFormat("dd-MM-yyyy");
                        String formattedDate1 = formatter1.format(date);
                        date_input.setText(formattedDate1);
                        try {
                            sleep(1000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            };
            clock.start();
        }
        catch (Exception e)
        {
            System.out.println(e);
        }

    }
}
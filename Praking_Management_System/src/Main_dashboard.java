import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main_dashboard extends Main
{

    public void dash(JFrame f)
    {
        JLabel Main_area = new JLabel();
        JLabel Main_heading = new JLabel("   Dashboard");
        JLabel Main_side = new JLabel();
        ImageIcon icon_side = new ImageIcon("C:\\Users\\prasa\\Desktop\\Parking Managment System\\Assets\\si.jpg");

        JLabel Main_widget1 = new JLabel("    Total Empty Parking Slots");
        JLabel Main_widget2 = new JLabel("  Total Allocated Parking Slots");
        JLabel Main_widget3 = new JLabel("               Total Vehicles");
        JLabel Main_widget4 = new JLabel("             Total Customers");
        JLabel Main_widget5 = new JLabel("               Total Sales");
        //JLabel Main_widget6 = new JLabel("   Total Parked Vehicle Details");

        int w1=get_detail(2,"Parking_slots", "Status='Available'");
        Main_widget1.setText(" Total Empty Park_Slots : "+w1);

        int w2=get_detail(1,"current_allocation", null);
        Main_widget2.setText(" Total Allocated Park_Slots : "+w2);

        int w3=get_detail(1,"vehicle", null);
        Main_widget3.setText("            Total Vehicles : "+w3);

        int w4=get_detail(1,"customer", null);
        Main_widget4.setText("          Total Customers : "+w4);

        int w5=get_detail(1,"sales", null);
        Main_widget5.setText("            Total Sales : "+w5);

        // Alignments of Objects.
        Main_area.setBounds(20, 130, 1875, 770);
        Main_heading.setBounds(820, 105, 250, 50);
        Main_side.setBounds(25, 135, 350, 760);

        Main_widget1.setBounds(410, 200, 450, 250);
        Main_widget2.setBounds(910, 200, 450, 250);
        Main_widget3.setBounds(1410, 200, 450, 250);

        Main_widget4.setBounds(410, 500, 450, 250);
        Main_widget5.setBounds(910, 500, 450, 250);
        //Main_widget6.setBounds(1410, 500, 450, 250);

        // Font and other properties of Objects handel here.

        Main_widget1.setFont(new Font("Verdana", Font.BOLD, 25));
        Main_widget2.setFont(new Font("Verdana", Font.BOLD, 25));
        Main_widget3.setFont(new Font("Verdana", Font.BOLD, 25));
        Main_widget4.setFont(new Font("Verdana", Font.BOLD, 25));
        Main_widget5.setFont(new Font("Verdana", Font.BOLD, 25));
        //Main_widget6.setFont(new Font("Verdana", Font.BOLD, 25));


        Main_widget1.setBackground(Color.cyan);
        Main_widget1.setOpaque(true);
        Main_widget1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        Main_widget2.setBackground(Color.orange);
        Main_widget2.setOpaque(true);
        Main_widget2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        Main_widget3.setBackground(Color.green);
        Main_widget3.setOpaque(true);
        Main_widget3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        Main_widget4.setBackground(Color.darkGray);
        Main_widget4.setOpaque(true);
        Main_widget4.setForeground(Color.white);
        Main_widget4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        Main_widget5.setBackground(Color.yellow);
        Main_widget5.setOpaque(true);
        Main_widget5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        //Main_widget6.setBackground(Color.red);
        //Main_widget6.setOpaque(true);
        //Main_widget6.setForeground(Color.white);
        //Main_widget6.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        Main_heading.setFont(new Font("Verdana", Font.BOLD, 30));
        Main_heading.setBackground(Color.WHITE);
        Main_heading.setOpaque(true);
        Border blackline = BorderFactory.createLineBorder(Color.black);
        Main_area.setBorder(blackline);
        Main_heading.setBorder(blackline);
        Main_side.setBorder(blackline);

        Main_widget1.setBorder(blackline);
        Main_widget2.setBorder(blackline);
        Main_widget3.setBorder(blackline);
        Main_widget4.setBorder(blackline);
        Main_widget5.setBorder(blackline);
        //Main_widget6.setBorder(blackline);
        //Display of Objects are handel here
        f.add(Main_heading);
        f.add(Main_widget1);
        f.add(Main_widget2);
        f.add(Main_widget3);
        f.add(Main_widget4);
        f.add(Main_widget5);
        //f.add(Main_widget6);
        main_side(f,0);
        f.add(Main_side);
        f.add(Main_area);

    }
    public static void main (String [] args)
    {
        var a = new Main_dashboard();
        JFrame f = new JFrame("Parking Management System");
        a.dash(f);
        a.NavbarFooter(f,"t");
    }
}
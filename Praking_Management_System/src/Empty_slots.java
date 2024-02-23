import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class Empty_slots extends Main {

    public static void main (String [] args)
    {
        var a = new Empty_slots();
        JFrame f = new JFrame("Parking Management System");
        JLabel Main_widget4 = new JLabel("  Total Empty Parking Slots : ");
        JLabel Main_widget5 = new JLabel("  Empty Parking Slots for Bikes");
        JLabel Main_widget6 = new JLabel("  Empty Parking Slots for Cars");
        JLabel widget1 = new JLabel("XXX");
        Main_widget4.setBounds(410, 400, 450, 250);
        widget1.setBounds(510,500,100,50);
        Main_widget5.setBounds(910, 400, 450, 250);
        Main_widget6.setBounds(1410, 400, 450, 250);
        Main_widget4.setFont(new Font("Verdana", Font.BOLD, 25));
        Main_widget5.setFont(new Font("Verdana", Font.BOLD, 25));
        Main_widget6.setFont(new Font("Verdana", Font.BOLD, 25));
        Main_widget4.setBackground(Color.darkGray);
        Main_widget4.setOpaque(true);
        Main_widget4.setForeground(Color.white);
        Main_widget4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        Main_widget5.setBackground(Color.yellow);
        Main_widget5.setOpaque(true);
        Main_widget5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        Main_widget6.setBackground(Color.red);
        Main_widget6.setOpaque(true);
        Main_widget6.setForeground(Color.white);
        Main_widget6.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        Border blackline = BorderFactory.createLineBorder(Color.black);
        Main_widget4.setBorder(blackline);
        Main_widget5.setBorder(blackline);
        Main_widget6.setBorder(blackline);
        f.add(Main_widget4);
        f.add(Main_widget5);
        f.add(Main_widget6);
        int w1=get_detail(2,"Parking_slots", "Status='Available'");
        Main_widget4.setText(" Total Empty Parking Slots : "+w1);
        int w2=get_detail(2,"Parking_slots", "Status='Available' and Type='Bike'");
        Main_widget5.setText("     Empty Slots for Bikes : "+w2);
        int w3=get_detail(2,"Parking_slots", "Status='Available' and Type='Car'");
        Main_widget6.setText("     Empty Slots for Cars : "+w3);
        a.main_side(f,1);
        a.NavbarFooter(f,"t");
    }
}

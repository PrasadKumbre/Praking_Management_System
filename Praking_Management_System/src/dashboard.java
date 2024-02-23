import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class dashboard extends Main
{
    public void dash(JFrame f)
    {
        JLabel Main_area = new JLabel();
        JLabel Main_heading = new JLabel("   Dashboard");
        JLabel Main_side = new JLabel();
        ImageIcon icon_side = new ImageIcon("C:\\Users\\prasa\\Desktop\\Parking Managment System\\Assets\\si.jpg");
        JLabel Main_side_icon = new JLabel(icon_side);
        JLabel Main_side_heading = new JLabel("           Menu");
        JLabel Main_side_1 = new JLabel("   Employee");
        JLabel Main_side_2 = new JLabel("   Parking Slots");
        JLabel Main_side_3 = new JLabel("   Customer");
        JLabel Main_side_4 = new JLabel("   Vehicle");
        JLabel Main_side_5 = new JLabel("   Sales");
        JLabel Main_widget1 = new JLabel("           Total Employee's");
        JLabel Main_widget2 = new JLabel("             Total Customer's");
        JLabel Main_widget3 = new JLabel("               Total Vehicles");
        JLabel Main_widget4 = new JLabel("           Total Parking Slots");
        JLabel Main_widget5 = new JLabel("               Total Sales");
        //JLabel Main_widget6 = new JLabel("               Total Admin");
        int w1=get_detail(1,"Parking_slots", null);
        Main_widget4.setText("     Total Parking Slots : "+w1);
        int w2=get_detail(1,"Employee", null);
        Main_widget1.setText("          Total Employees : "+w2);
        int w3=get_detail(1,"vehicle", null);
        Main_widget3.setText("            Total Vehicles : "+w3);
        int w4=get_detail(1,"customer", null);
        Main_widget2.setText("          Total Customers : "+w4);
        int w5=get_detail(1,"sales", null);
        Main_widget5.setText("            Total Sales : "+w5);

        // Alignments of Objects.
        Main_area.setBounds(20, 130, 1875, 770);
        Main_heading.setBounds(820, 105, 250, 50);
        Main_side.setBounds(25, 135, 350, 760);
        Main_side_icon.setBounds(24, 105, 350, 350);
        Main_side_heading.setBounds(32, 425, 335, 75);
        Main_side_1.setBounds(32, 508, 335, 70);
        Main_side_2.setBounds(32, 586, 335, 70);
        Main_side_3.setBounds(32, 664, 335, 70);
        Main_side_4.setBounds(32, 742, 335, 70);
        Main_side_5.setBounds(32, 820, 335, 70);
        Main_widget1.setBounds(410, 200, 450, 250);
        Main_widget2.setBounds(910, 200, 450, 250);
        Main_widget3.setBounds(1410, 200, 450, 250);
        Main_widget4.setBounds(410, 500, 450, 250);
        Main_widget5.setBounds(910, 500, 450, 250);
        //Main_widget6.setBounds(1410, 500, 450, 250);
        // Font and other properties of Objects handel here.
        Main_side_heading.setBackground(Color.ORANGE);
        Main_side_heading.setOpaque(true);
        Main_side_1.setFont(new Font("Verdana", Font.BOLD, 25));
        Main_side_2.setFont(new Font("Verdana", Font.BOLD, 25));
        Main_side_3.setFont(new Font("Verdana", Font.BOLD, 25));
        Main_side_4.setFont(new Font("Verdana", Font.BOLD, 25));
        Main_side_5.setFont(new Font("Verdana", Font.BOLD, 25));
        Main_widget1.setFont(new Font("Verdana", Font.BOLD, 25));
        Main_widget2.setFont(new Font("Verdana", Font.BOLD, 25));
        Main_widget3.setFont(new Font("Verdana", Font.BOLD, 25));
        Main_widget4.setFont(new Font("Verdana", Font.BOLD, 25));
        Main_widget5.setFont(new Font("Verdana", Font.BOLD, 25));
        //Main_widget6.setFont(new Font("Verdana", Font.BOLD, 25));
        Main_side_1.setBackground(Color.LIGHT_GRAY);
        Main_side_1.setOpaque(true);
        Main_side_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        Main_side_2.setBackground(Color.LIGHT_GRAY);
        Main_side_2.setOpaque(true);
        Main_side_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        Main_side_3.setBackground(Color.LIGHT_GRAY);
        Main_side_3.setOpaque(true);
        Main_side_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        Main_side_4.setBackground(Color.LIGHT_GRAY);
        Main_side_4.setOpaque(true);
        Main_side_4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        Main_side_5.setBackground(Color.LIGHT_GRAY);
        Main_side_5.setOpaque(true);
        Main_side_5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
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
        Main_heading.setFont(new Font("Verdana", Font.BOLD, 30));
        Main_heading.setBackground(Color.WHITE);
        Main_heading.setOpaque(true);
        Main_side_heading.setFont(new Font("Verdana", Font.BOLD, 30));
        Border blackline = BorderFactory.createLineBorder(Color.black);
        Main_area.setBorder(blackline);
        Main_heading.setBorder(blackline);
        Main_side.setBorder(blackline);
        Main_side_heading.setBorder(blackline);
        Main_side_1.setBorder(blackline);
        Main_side_2.setBorder(blackline);
        Main_side_3.setBorder(blackline);
        Main_side_4.setBorder(blackline);
        Main_side_5.setBorder(blackline);
        Main_widget1.setBorder(blackline);
        Main_widget2.setBorder(blackline);
        Main_widget3.setBorder(blackline);
        Main_widget4.setBorder(blackline);
        Main_widget5.setBorder(blackline);
        f.add(Main_heading);
        f.add(Main_side_1);
        f.add(Main_side_2);
        f.add(Main_side_3);
        f.add(Main_side_4);
        f.add(Main_side_5);
        f.add(Main_widget1);
        f.add(Main_widget2);
        f.add(Main_widget3);
        f.add(Main_widget4);
        f.add(Main_widget5);
        f.add(Main_side);
        f.add(Main_side_icon);
        f.add(Main_side_heading);
        f.add(Main_area);

        Main_side_1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Runtime.getRuntime().exec("\"C:\\Program Files\\Java\\jdk-18.0.2.1\\bin\\java.exe\" \"-javaagent:C:\\Program Files\\JetBrains\\IntelliJ IDEA Community Edition 2022.3\\lib\\idea_rt.jar=58456:C:\\Program Files\\JetBrains\\IntelliJ IDEA Community Edition 2022.3\\bin\" -Dfile.encoding=UTF-8 -Dsun.stdout.encoding=UTF-8 -Dsun.stderr.encoding=UTF-8 -classpath \"C:\\Users\\prasa\\Desktop\\Parking Managment System\\out\\production\\Parking Managment System;C:\\Program Files (x86)\\MySQL\\Connector J 8.0\\mysql-connector-j-8.0.33.jar\" Employee");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

        });

        Main_side_2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Runtime.getRuntime().exec("\"C:\\Program Files\\Java\\jdk-18.0.2.1\\bin\\java.exe\" \"-javaagent:C:\\Program Files\\JetBrains\\IntelliJ IDEA Community Edition 2022.3\\lib\\idea_rt.jar=58507:C:\\Program Files\\JetBrains\\IntelliJ IDEA Community Edition 2022.3\\bin\" -Dfile.encoding=UTF-8 -Dsun.stdout.encoding=UTF-8 -Dsun.stderr.encoding=UTF-8 -classpath \"C:\\Users\\prasa\\Desktop\\Parking Managment System\\out\\production\\Parking Managment System;C:\\Program Files (x86)\\MySQL\\Connector J 8.0\\mysql-connector-j-8.0.33.jar\" Parking_Slots_Details");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

        });

        Main_side_3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Runtime.getRuntime().exec("\"C:\\Program Files\\Java\\jdk-18.0.2.1\\bin\\java.exe\" \"-javaagent:C:\\Program Files\\JetBrains\\IntelliJ IDEA Community Edition 2022.3\\lib\\idea_rt.jar=58215:C:\\Program Files\\JetBrains\\IntelliJ IDEA Community Edition 2022.3\\bin\" -Dfile.encoding=UTF-8 -Dsun.stdout.encoding=UTF-8 -Dsun.stderr.encoding=UTF-8 -classpath \"C:\\Users\\prasa\\Desktop\\Parking Managment System\\out\\production\\Parking Managment System;C:\\Program Files (x86)\\MySQL\\Connector J 8.0\\mysql-connector-j-8.0.33.jar\" Customer");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

        });

        Main_side_4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Runtime.getRuntime().exec("\"C:\\Program Files\\Java\\jdk-18.0.2.1\\bin\\java.exe\" \"-javaagent:C:\\Program Files\\JetBrains\\IntelliJ IDEA Community Edition 2022.3\\lib\\idea_rt.jar=58500:C:\\Program Files\\JetBrains\\IntelliJ IDEA Community Edition 2022.3\\bin\" -Dfile.encoding=UTF-8 -Dsun.stdout.encoding=UTF-8 -Dsun.stderr.encoding=UTF-8 -classpath \"C:\\Users\\prasa\\Desktop\\Parking Managment System\\out\\production\\Parking Managment System;C:\\Program Files (x86)\\MySQL\\Connector J 8.0\\mysql-connector-j-8.0.33.jar\" Vehicle");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

        });

        Main_side_5.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Runtime.getRuntime().exec("\"C:\\Program Files\\Java\\jdk-18.0.2.1\\bin\\java.exe\" \"-javaagent:C:\\Program Files\\JetBrains\\IntelliJ IDEA Community Edition 2022.3\\lib\\idea_rt.jar=64565:C:\\Program Files\\JetBrains\\IntelliJ IDEA Community Edition 2022.3\\bin\" -Dfile.encoding=UTF-8 -Dsun.stdout.encoding=UTF-8 -Dsun.stderr.encoding=UTF-8 -classpath \"C:\\Users\\prasa\\Desktop\\Parking Managment System\\out\\production\\Parking Managment System;C:\\Program Files (x86)\\MySQL\\Connector J 8.0\\mysql-connector-j-8.0.33.jar\" Sales");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

        });

    }
    public static void main(String[] args) {
        var a = new dashboard();
        JFrame f = new JFrame("Parking Management System");
        a.dash(f);
        a.NavbarFooter(f,"t");
    }
}
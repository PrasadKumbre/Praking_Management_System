import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class Main  {
    public void NavbarFooter(JFrame f,String Button) //navbar and footers business logic are manage here.
    {

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel navbar_Title = new JLabel("Parking Management System"); //this is main title on navbar.
        JLabel Text = new JLabel("");
        ImageIcon icon = new ImageIcon("C:\\Users\\prasa\\Desktop\\Parking Managment System\\Assets\\pms.jpg"); //this is logo
        JLabel logo_image = new JLabel(icon); //this is logo in label
        JLabel navbar_background = new JLabel();
        JLabel navbar_time = new JLabel("Time ");
        JLabel navbar_time1 = new JLabel();
        JLabel navbar_date = new JLabel("Date ");
        JLabel navbar_date1 = new JLabel();
        JButton logout_button = new JButton("LogOut");
        JLabel footer_background = new JLabel();
        JLabel footer_text = new JLabel("Parking Management System | Develop By SS Software Solutions");
        JLabel footer_text1 = new JLabel("For Enquiry any Contact : +91 901190 XXX0.");
        JLabel Main_area = new JLabel();


        logo_image.setBounds(20, 12, 75, 75); //this is logo in label
        navbar_Title.setBounds(110, 25, 750, 50); //this is main title on navbar.
        navbar_background.setBounds(0, 0, 1920, 100);
        navbar_time.setBounds(1100, 15, 150, 50);
        navbar_time1.setBounds(1075, 40, 150, 50);
        navbar_date.setBounds(1300, 15, 150, 50);
        navbar_date1.setBounds(1265, 40, 200, 50);
        logout_button.setBounds(1600, 25, 200, 50);
        f.setSize(1920, 1080);
        footer_background.setBounds(0, 915, 1920, 150);
        footer_text.setBounds(600, 925, 800, 30);
        footer_text1.setBounds(750, 960, 800, 30);
        Main_area.setBounds(20, 130, 1875, 770);
        f.setSize(1920, 1080);


        navbar_Title.setFont(new Font("Verdana", Font.BOLD, 40));
        navbar_time.setFont(new Font("Verdana", Font.BOLD, 20));
        navbar_time1.setFont(new Font("Verdana", Font.BOLD, 20));
        navbar_date.setFont(new Font("Verdana", Font.BOLD, 20));
        navbar_date1.setFont(new Font("Verdana", Font.BOLD, 20));
        navbar_background.setBackground(Color.green);
        navbar_background.setOpaque(true);
        logout_button.setFont(new Font("Verdana", Font.BOLD, 20));
        logout_button.setBorderPainted(false);
        logout_button.setFocusPainted(false);
        logout_button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        footer_background.setBackground(Color.GRAY);
        footer_background.setOpaque(true);
        footer_text.setFont(new Font("Verdana", Font.BOLD, 20));
        footer_text.setForeground(Color.white);
        footer_text1.setFont(new Font("Verdana", Font.BOLD, 15));
        footer_text1.setForeground(Color.BLACK);
        Border blackline = BorderFactory.createLineBorder(Color.black);
        Main_area.setBorder(blackline);


        f.add(navbar_Title); //this is main title on navbar.
        f.add(logo_image); //this is logo in label
        f.add(navbar_time);
        f.add(navbar_time1);
        f.add(navbar_date);
        f.add(navbar_date1);
        f.add(logout_button);
        f.add(footer_text);
        f.add(footer_text1);
        f.add(Main_area);
        f.add(navbar_background);
        f.add(footer_background);
        f.add(Text);
        f.setVisible(true);
        f.setLayout(null);

        logout_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Runtime.getRuntime().exec("\"C:\\Program Files\\Java\\jdk-18.0.2.1\\bin\\java.exe\" \"-javaagent:C:\\Program Files\\JetBrains\\IntelliJ IDEA Community Edition 2022.3\\lib\\idea_rt.jar=50156:C:\\Program Files\\JetBrains\\IntelliJ IDEA Community Edition 2022.3\\bin\" -Dfile.encoding=UTF-8 -Dsun.stdout.encoding=UTF-8 -Dsun.stderr.encoding=UTF-8 -classpath \"C:\\Users\\prasa\\Desktop\\Parking Managment System\\out\\production\\Parking Managment System;C:\\Program Files (x86)\\MySQL\\Connector J 8.0\\mysql-connector-j-8.0.33.jar\" Login\n");
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                f.dispose();
            }
        });


        if(Button.equals("f"))
        {
            logout_button.setVisible(false);
        }

        Thread clock = new Thread() {
            public void run() {
                while(true) {
                    java.util.Date date = new Date();
                    SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
                    String formattedDate = formatter.format(date);
                    navbar_time1.setText(formattedDate);

                    SimpleDateFormat formatter1 = new SimpleDateFormat("dd-MM-yyyy");
                    String formattedDate1 = formatter1.format(date);
                    navbar_date1.setText(formattedDate1);

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

    public void SearchArea (JFrame f,String name, String [] choices,String db_name) // Search bar Manage here
    {

        JLabel Main_heading = new JLabel(name+" Details");
        JLabel Search = new JLabel();
        JLabel Search_heading = new JLabel("  Search "+name);
        final JComboBox<String> cb = new JComboBox<String>(choices);
        JTextField Search_text = new JTextField();
        JButton Search_button= new JButton("Search");

        Main_heading.setBounds(820, 105, 250, 50);
        Search.setBounds(500,175,920,100);
        Search_heading.setBounds(510,155,160,40);
        cb.setBounds(520,200,200,50);
        Search_text.setBounds(760,200,400,50);
        Search_button.setBounds(1200,200,200,50);


        Main_heading.setFont(new Font("Verdana", Font.BOLD, 24));
        Search_heading.setFont(new Font("Verdana", Font.BOLD, 15));
        cb.setFont(new Font("Verdana", Font.PLAIN, 24));
        Search_text.setFont(new Font("Verdana", Font.PLAIN, 25));
        Search_button.setFont(new Font("Verdana", Font.PLAIN, 25));
        Main_heading.setBackground(Color.WHITE);
        cb.setBackground(Color.WHITE);
        //Search_heading.setBackground(Color.);

        cb.setOpaque(true);
        Main_heading.setOpaque(true);
        Search_heading.setOpaque(true);
        Border blackline = BorderFactory.createLineBorder(Color.black);
        Main_heading.setBorder(blackline);
        Search.setBorder(blackline);
        Search_text.setBorder(blackline);


        f.add(Search_button);
        f.add(Search_text);
        f.add(cb);
        f.add(Search_heading);
        f.add(Main_heading);
        f.add(Search);


        Search_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               String C = cb.getSelectedItem().toString();
               String C1 = Search_text.getText();

               if(C.equals("Select"))
               {
                   setWarningMsg("Select the Flied");
               }
               else if(C.equals("ID"))
               {
                   Table(f, db_name, 3, C1, C);
               }
               else if(C1.isEmpty())
               {
                   setWarningMsg("Enter the value");
               }
               else {
                   Table(f, db_name, 2, C1, C);
               }
            }
        });

    }

    public static void detail(JFrame f,String [] n,String name_db,String [] choices) // Form for Add , Edit, Delete, Clear are manage here.
    {
        JLabel detail = new JLabel();
        JLabel id = new JLabel(n[0]);
        JLabel name = new JLabel(n[1]);
        JLabel mobile = new JLabel(n[2]);
        JLabel email = new JLabel(n[3]);
        JLabel gender = new JLabel(n[4]);
        JLabel dob = new JLabel(n[5]);
        JLabel address = new JLabel(n[6]);
        JLabel password = new JLabel(n[7]);

        JTextField id_input = new JTextField();
        JTextField name_input = new JTextField();
        JTextField mobile_input = new JTextField();
        JTextField email_input = new JTextField();
        JComboBox<String> gender_input = new JComboBox<String>(choices);
        JTextField dob_input = new JTextField();
        JTextField address_input = new JTextField();
        JTextField password_input = new JTextField();

        JButton add = new JButton("Add");
        JButton edit = new JButton("Edit");
        JButton delete = new JButton("Delete");
        JButton clear = new JButton("Clear");
        JLabel detail_end = new JLabel();

        detail.setBounds(20, 300, 1875, 20);
        id.setBounds(80, 360, 200, 50);
        id_input.setBounds(200, 365, 150, 45);
        name.setBounds(400, 360, 200, 50);
        name_input.setBounds(500, 365, 300, 45);
        mobile.setBounds(850, 360, 200, 50);
        mobile_input.setBounds(1000, 365, 300, 45);
        email.setBounds(1350, 360, 200, 50);
        email_input.setBounds(1480, 365, 300, 45);
        gender.setBounds(80, 450, 200, 50);
        gender_input.setBounds(200, 455, 150, 45);
        dob.setBounds(400, 450, 200, 50);
        dob_input.setBounds(500, 455, 300, 45);
        address.setBounds(850, 450, 200, 50);
        address_input.setBounds(1000, 455, 300, 45);
        password.setBounds(1350, 450, 200, 50);
        password_input.setBounds(1480, 455, 300, 45);
        add.setBounds(450, 540, 200, 50);
        edit.setBounds(700, 540, 200, 50);
        delete.setBounds(950, 540, 200, 50);
        clear.setBounds(1200, 540, 200, 50);
        detail_end.setBounds(20, 630, 1875, 20);

        detail.setBackground(Color.lightGray);
        detail.setOpaque(true);
        id.setFont(new Font("Verdana", Font.PLAIN, 25));
        id_input.setFont(new Font("Verdana", Font.PLAIN, 25));
        name.setFont(new Font("Verdana", Font.PLAIN, 25));
        name_input.setFont(new Font("Verdana", Font.PLAIN, 25));
        mobile.setFont(new Font("Verdana", Font.PLAIN, 25));
        mobile_input.setFont(new Font("Verdana", Font.PLAIN, 25));
        email.setFont(new Font("Verdana", Font.PLAIN, 25));
        email_input.setFont(new Font("Verdana", Font.PLAIN, 25));
        gender.setFont(new Font("Verdana", Font.PLAIN, 25));
        gender_input.setFont(new Font("Verdana", Font.PLAIN, 25));
        gender_input.setBackground(Color.WHITE);
        dob.setFont(new Font("Verdana", Font.PLAIN, 25));
        dob_input.setFont(new Font("Verdana", Font.PLAIN, 25));
        address.setFont(new Font("Verdana", Font.PLAIN, 25));
        address_input.setFont(new Font("Verdana", Font.PLAIN, 25));
        password.setFont(new Font("Verdana", Font.PLAIN, 25));
        password_input.setFont(new Font("Verdana", Font.PLAIN, 25));
        add.setFont(new Font("Verdana", Font.BOLD, 25));
        edit.setFont(new Font("Verdana", Font.BOLD, 25));
        delete.setFont(new Font("Verdana", Font.BOLD, 25));
        clear.setFont(new Font("Verdana", Font.BOLD, 25));
        detail_end.setBackground(Color.lightGray);
        detail_end.setOpaque(true);

        add.setBackground(Color.blue);
        edit.setBackground(Color.magenta);
        delete.setBackground(Color.red);
        clear.setBackground(Color.gray);

        add.setForeground(Color.white);
        edit.setForeground(Color.white);
        delete.setForeground(Color.white);
        clear.setForeground(Color.white);

        Border blackline = BorderFactory.createLineBorder(Color.black);
        detail.setBorder(blackline);
        id_input.setBorder(blackline);
        name_input.setBorder(blackline);
        mobile_input.setBorder(blackline);
        email_input.setBorder(blackline);
        gender_input.setBorder(blackline);
        dob_input.setBorder(blackline);
        address_input.setBorder(blackline);
        password_input.setBorder(blackline);
        detail_end.setBorder(blackline);

        f.add(detail);
        f.add(id);
        f.add(id_input);
        f.add(name);
        f.add(name_input);
        f.add(mobile);
        f.add(mobile_input);
        f.add(email);
        f.add(email_input);
        f.add(gender);
        f.add(gender_input);
        f.add(dob);
        f.add(dob_input);
        f.add(address);
        f.add(address_input);
        f.add(password);
        f.add(password_input);
        f.add(add);
        f.add(edit);
        f.add(delete);
        f.add(clear);
        f.add(detail_end);

        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Add(name_db, id_input, name_input, mobile_input, email_input, gender_input, dob_input, address_input, password_input);
                refresh_db(f,name_db);
            }

        });

        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (id_input.getText().isEmpty()) {
                    setWarningMsg("Pls enter ID Valid");
                } else {
                    String i = id_input.getText();
                    int id=Integer.parseInt(i);
                    int o=delete(name_db,id);
                    if(o==1)
                    {
                        JOptionPane.showMessageDialog(null, "Data Deleted Successfully...");
                        refresh_db(f,name_db);

                    }
                }
            }

        });

        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            id_input.setText("");
            name_input.setText("");
            mobile_input.setText("");
            email_input.setText("");
            gender_input.setSelectedItem(choices[0]);
            dob_input.setText("");
            address_input.setText("");
            password_input.setText("");
            refresh_db(f,name_db);
            }
        });
    }

    public static int delete(String db_name,int id)
    {
        int i=0;
        try
        {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pms", "root", "root");
            String sql = "delete from "+db_name+" where id="+id;
            Statement st = con.createStatement();
            int p=0;
            p=st.executeUpdate(sql);
            System.out.println(p);
            if(p==0)
            {
                setWarningMsg("Data not found");
            }
            else {
                i++;
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }

        return i;
    }

    public static void refresh_db(JFrame f,String db_name)
    {
        Table(f,db_name,1,null,null);
    }
    public static void Add(String name_db, JTextField id_input, JTextField name_input, JTextField mobile_input, JTextField email_input, JComboBox gender_input, JTextField dob_input, JTextField address_input, JTextField password_input) {
        String id = id_input.getText();
        String name = name_input.getText();
        String mobile = mobile_input.getText();
        String email = email_input.getText();
        String gender = gender_input.getSelectedItem().toString();
        String dob = dob_input.getText();
        String address = address_input.getText();
        String password = password_input.getText();
        if (id.isEmpty() || name.isEmpty() || mobile.isEmpty() || email.isEmpty() || gender.isEmpty() || dob.isEmpty() || address.isEmpty() || password.isEmpty())
        {
            setWarningMsg("Some Filed are Missing");
        }
        else if (gender.equals("Select"))
        {
            setWarningMsg("Gender is Not Selected.");
        }
        else {
            int idd = Integer.parseInt(id);
            try {
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pms", "root", "root");
                String sql = "insert into "+name_db+" values(?,?,?,?,?,?,?,?)";
                //String sql1 = "insert into employee values(117,'Prasad','2302302','ko@gmail.com','Male','15-05-2002','Pune','35265')";

                PreparedStatement pst = con.prepareStatement(sql);
                pst.setInt(1, idd);
                pst.setString(2, name);
                pst.setString(3, mobile);
                pst.setString(4, email);
                pst.setString(5, gender);
                pst.setString(6, dob);
                pst.setString(7, address);
                pst.setString(8, password);
                pst.execute();
                JOptionPane.showMessageDialog(null, "Successfully Inserted..");

                con.close();

            } catch (SQLException e) {
                JOptionPane optionPane = new JOptionPane("Error !  " + e, JOptionPane.ERROR_MESSAGE);
                JDialog dialog = optionPane.createDialog("Error!");
                dialog.setAlwaysOnTop(true); // to show top of all other application
                dialog.setVisible(true); // to visible the dialog
                throw new RuntimeException(e);
            }
        }
    }
    public static void setWarningMsg(String text){
        Toolkit.getDefaultToolkit().beep();
        JOptionPane optionPane = new JOptionPane(text,JOptionPane.WARNING_MESSAGE);
        JDialog dialog = optionPane.createDialog("Warning!");
        dialog.setAlwaysOnTop(true);
        dialog.setVisible(true);
    }
    public static Object Table (JFrame frame, String db_name , int type, String cond , String cond1) {
        Object[] rowData = new Object[0];
        try {
            String sql = makeq(type, db_name, cond1, cond);
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pms", "root", "root");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            DefaultTableModel model = new DefaultTableModel();
            ResultSetMetaData metaData = rs.getMetaData();
            JTable table = new JTable(model);
            JScrollPane scrollPane = new JScrollPane(table);
            scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
            int columnCount = metaData.getColumnCount();
            rowData = new Object[columnCount];
            for (int i = 1; i <= columnCount; i++) {
                model.addColumn(metaData.getColumnName(i));
            }
            while (rs.next()) {
                Object[] row = new Object[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    row[i - 1] = rs.getObject(i);
                }
                model.addRow(row);
            }
            // Create a JTable

            // Add a selection listener to the table
            Object[] finalRowData = rowData;
            table.getSelectionModel().addListSelectionListener(e -> {
                int row = table.getSelectedRow();
                for (int i = 0; i < columnCount; i++) {
                    finalRowData[i] = table.getValueAt(row, i);
                }
                System.out.println(Arrays.toString(finalRowData));


                //getdb(rowData);
                //printdata(rowData);

                //setValue(rowData);

            });


            Border blackline = BorderFactory.createLineBorder(Color.black);
            table.setBorder(blackline);
            table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
            table.setRowHeight(25);
            table.setFillsViewportHeight(true);

            //table.setFont(new Font("Verdana", Font.PLAIN, 15));
            table.setBounds(32, 662, 1851, 225);
            scrollPane.setBounds(1870, 662, 20, 200);

            if(db_name.equals("Parking_Slots"))
            {
                table.setBounds(32, 560, 1851, 330);

            }

            frame.add(table);
            scrollPane.setVisible(true);
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rowData;
    }

    public Object printdata(Object[] rowData)
    {
        System.out.println(Arrays.toString(rowData));
        return rowData;
    }

    public static String makeq (int type,String db_name,String conditon1,String conditon) {

        String sql = null;
        if (type == 1) {
            sql = "select * from " + db_name;
        }
        else if (type == 2)
        {
            sql = "select * from " + db_name + " where "+conditon1+" LIKE '" + conditon + "%'";
            System.out.println(sql);
        }
        else if (type == 3)
        {
            sql = "select * from " + db_name + " where "+conditon1+" =" + conditon;
            System.out.println(sql);
        }
        return sql;
    }

    public void main_side(Frame f,int i)
    {
        Border blackline = BorderFactory.createLineBorder(Color.black);

        JLabel Main_side = new JLabel();
        ImageIcon icon_side = new ImageIcon("C:/Users/prasa/Documents/Downloads/si.jpg");
        JLabel Main_side_icon = new JLabel(icon_side);
        JLabel Main_side_heading = new JLabel("           Menu");
        JLabel Main_side_1 = new JLabel("  Empty Parking Slots");
        JLabel Main_side_2 = new JLabel("  Allocate Parking Slot");
        JLabel Main_side_3 = new JLabel("        Add Customer");
        JLabel Main_side_4 = new JLabel("        Add Vehicle");
        JLabel Main_side_5 = new JLabel("       Generate Bill");

        Main_side.setBounds(25, 135, 350, 760);
        Main_side_icon.setBounds(24, 105, 350, 350);
        Main_side_heading.setBounds(32, 425, 335, 75);
        Main_side_1.setBounds(32, 508, 335, 70);
        Main_side_2.setBounds(32, 586, 335, 70);
        Main_side_3.setBounds(32, 664, 335, 70);
        Main_side_4.setBounds(32, 742, 335, 70);
        Main_side_5.setBounds(32, 820, 335, 70);

        Main_side_heading.setBackground(Color.ORANGE);
        Main_side_heading.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        Main_side_heading.setOpaque(true);

        Main_side_1.setFont(new Font("Verdana", Font.BOLD, 25));
        Main_side_2.setFont(new Font("Verdana", Font.BOLD, 25));
        Main_side_3.setFont(new Font("Verdana", Font.BOLD, 25));
        Main_side_4.setFont(new Font("Verdana", Font.BOLD, 25));
        Main_side_5.setFont(new Font("Verdana", Font.BOLD, 25));



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

        Main_side_heading.setFont(new Font("Verdana", Font.BOLD, 30));
        Main_side.setBorder(blackline);
        Main_side_heading.setBorder(blackline);
        Main_side_1.setBorder(blackline);
        Main_side_2.setBorder(blackline);
        Main_side_3.setBorder(blackline);
        Main_side_4.setBorder(blackline);
        Main_side_5.setBorder(blackline);

        f.add(Main_side_1);
        f.add(Main_side_2);
        f.add(Main_side_3);
        f.add(Main_side_4);
        f.add(Main_side_5);
        f.add(Main_side);
        f.add(Main_side_icon);
        f.add(Main_side_heading);

        Main_side_1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    if(i==1)
                    {
                        setWarningMsg("The file is already open");
                    }
                    else
                    {
                        Runtime.getRuntime().exec("\"C:\\Program Files\\Java\\jdk-18.0.2.1\\bin\\java.exe\" \"-javaagent:C:\\Program Files\\JetBrains\\IntelliJ IDEA Community Edition 2022.3\\lib\\idea_rt.jar=59927:C:\\Program Files\\JetBrains\\IntelliJ IDEA Community Edition 2022.3\\bin\" -Dfile.encoding=UTF-8 -Dsun.stdout.encoding=UTF-8 -Dsun.stderr.encoding=UTF-8 -classpath \"C:\\Users\\prasa\\Desktop\\Parking Managment System\\out\\production\\Parking Managment System;C:\\Program Files (x86)\\MySQL\\Connector J 8.0\\mysql-connector-j-8.0.33.jar\" Empty_slots\n");
                        f.dispose();
                    }

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

        });

        Main_side_2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    if(i==2)
                    {
                        setWarningMsg("The file is already open.");
                    }
                    else {
                        Runtime.getRuntime().exec("\"C:\\Program Files\\Java\\jdk-18.0.2.1\\bin\\java.exe\" \"-javaagent:C:\\Program Files\\JetBrains\\IntelliJ IDEA Community Edition 2022.3\\lib\\idea_rt.jar=58179:C:\\Program Files\\JetBrains\\IntelliJ IDEA Community Edition 2022.3\\bin\" -Dfile.encoding=UTF-8 -Dsun.stdout.encoding=UTF-8 -Dsun.stderr.encoding=UTF-8 -classpath \"C:\\Users\\prasa\\Desktop\\Parking Managment System\\out\\production\\Parking Managment System;C:\\Program Files (x86)\\MySQL\\Connector J 8.0\\mysql-connector-j-8.0.33.jar\" Allocate_slots\n");
                        f.dispose();
                    }
                } catch (IOException ex) {
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
                    Runtime.getRuntime().exec("\"C:\\Program Files\\Java\\jdk-18.0.2.1\\bin\\java.exe\" \"-javaagent:C:\\Program Files\\JetBrains\\IntelliJ IDEA Community Edition 2022.3\\lib\\idea_rt.jar=58230:C:\\Program Files\\JetBrains\\IntelliJ IDEA Community Edition 2022.3\\bin\" -Dfile.encoding=UTF-8 -Dsun.stdout.encoding=UTF-8 -Dsun.stderr.encoding=UTF-8 -classpath \"C:\\Users\\prasa\\Desktop\\Parking Managment System\\out\\production\\Parking Managment System;C:\\Program Files (x86)\\MySQL\\Connector J 8.0\\mysql-connector-j-8.0.33.jar\" Vehicle");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

        });

        Main_side_5.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    if(i==5)
                    {
                        setWarningMsg("The file is already open.");
                    }
                    else {
                        Runtime.getRuntime().exec("\"C:\\Program Files\\Java\\jdk-18.0.2.1\\bin\\java.exe\" \"-javaagent:C:\\Program Files\\JetBrains\\IntelliJ IDEA Community Edition 2022.3\\lib\\idea_rt.jar=59284:C:\\Program Files\\JetBrains\\IntelliJ IDEA Community Edition 2022.3\\bin\" -Dfile.encoding=UTF-8 -Dsun.stdout.encoding=UTF-8 -Dsun.stderr.encoding=UTF-8 -classpath \"C:\\Users\\prasa\\Desktop\\Parking Managment System\\out\\production\\Parking Managment System;C:\\Program Files (x86)\\MySQL\\Connector J 8.0\\mysql-connector-j-8.0.33.jar\" Bill");
                        f.dispose();
                    }

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

        });

        Main_side_heading.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    if(i==0)
                    {
                        setWarningMsg("The file is already open.");
                    }
                    else {
                        Runtime.getRuntime().exec("\"C:\\Program Files\\Java\\jdk-18.0.2.1\\bin\\java.exe\" \"-javaagent:C:\\Program Files\\JetBrains\\IntelliJ IDEA Community Edition 2022.3\\lib\\idea_rt.jar=58274:C:\\Program Files\\JetBrains\\IntelliJ IDEA Community Edition 2022.3\\bin\" -Dfile.encoding=UTF-8 -Dsun.stdout.encoding=UTF-8 -Dsun.stderr.encoding=UTF-8 -classpath \"C:\\Users\\prasa\\Desktop\\Parking Managment System\\out\\production\\Parking Managment System;C:\\Program Files (x86)\\MySQL\\Connector J 8.0\\mysql-connector-j-8.0.33.jar\" Main_dashboard");
                        f.dispose();
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

        });
    }


    public static int get_detail(int Condition, String db_name, String additional)
    {
        int r = 0;
        try {
            String Sql =null;
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pms", "root", "root");
            Statement st = con.createStatement();
            if(Condition==1)
            {
                Sql ="Select * from "+db_name;
            }
            else if(Condition==2)
            {
                Sql ="Select * from "+db_name+" where "+additional;
                System.out.println(Sql);
            }
            ResultSet rs = st.executeQuery(Sql);
            r = 0;
            while (rs.next()) {
                int s = rs.getInt(1);
                r++;
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return r;
    }
    public static void details(JFrame f,String [] n,String name_db,String [] choices,JTextField id_input,JTextField name_input,JTextField mobile_input,JTextField email_input,JComboBox<String> gender_input,JTextField dob_input,JTextField address_input,JTextField password_input) // Form for Add , Edit, Delete, Clear are manage here.
    {
        JLabel detail = new JLabel();
        JLabel id = new JLabel(n[0]);
        JLabel name = new JLabel(n[1]);
        JLabel mobile = new JLabel(n[2]);
        JLabel email = new JLabel(n[3]);
        JLabel gender = new JLabel(n[4]);
        JLabel dob = new JLabel(n[5]);
        JLabel address = new JLabel(n[6]);
        JLabel password = new JLabel(n[7]);


        JButton add = new JButton("Add");
        JButton edit = new JButton("Edit");
        JButton delete = new JButton("Delete");
        JButton clear = new JButton("Clear");
        JLabel detail_end = new JLabel();

        detail.setBounds(20, 300, 1875, 20);
        id.setBounds(80, 360, 200, 50);
        id_input.setBounds(200, 365, 150, 45);
        name.setBounds(400, 360, 200, 50);
        name_input.setBounds(500, 365, 300, 45);
        mobile.setBounds(850, 360, 200, 50);
        mobile_input.setBounds(1000, 365, 300, 45);
        email.setBounds(1350, 360, 200, 50);
        email_input.setBounds(1480, 365, 300, 45);
        gender.setBounds(80, 450, 200, 50);
        gender_input.setBounds(200, 455, 150, 45);
        dob.setBounds(400, 450, 200, 50);
        dob_input.setBounds(500, 455, 300, 45);
        address.setBounds(850, 450, 200, 50);
        address_input.setBounds(1000, 455, 300, 45);
        password.setBounds(1350, 450, 200, 50);
        password_input.setBounds(1480, 455, 300, 45);
        add.setBounds(450, 540, 200, 50);
        edit.setBounds(700, 540, 200, 50);
        delete.setBounds(950, 540, 200, 50);
        clear.setBounds(1200, 540, 200, 50);
        detail_end.setBounds(20, 630, 1875, 20);

        detail.setBackground(Color.lightGray);
        detail.setOpaque(true);
        id.setFont(new Font("Verdana", Font.PLAIN, 25));
        id_input.setFont(new Font("Verdana", Font.PLAIN, 25));
        name.setFont(new Font("Verdana", Font.PLAIN, 25));
        name_input.setFont(new Font("Verdana", Font.PLAIN, 25));
        mobile.setFont(new Font("Verdana", Font.PLAIN, 25));
        mobile_input.setFont(new Font("Verdana", Font.PLAIN, 25));
        email.setFont(new Font("Verdana", Font.PLAIN, 25));
        email_input.setFont(new Font("Verdana", Font.PLAIN, 25));
        gender.setFont(new Font("Verdana", Font.PLAIN, 25));
        gender_input.setFont(new Font("Verdana", Font.PLAIN, 25));
        gender_input.setBackground(Color.WHITE);
        dob.setFont(new Font("Verdana", Font.PLAIN, 25));
        dob_input.setFont(new Font("Verdana", Font.PLAIN, 25));
        address.setFont(new Font("Verdana", Font.PLAIN, 25));
        address_input.setFont(new Font("Verdana", Font.PLAIN, 25));
        password.setFont(new Font("Verdana", Font.PLAIN, 25));
        password_input.setFont(new Font("Verdana", Font.PLAIN, 25));
        add.setFont(new Font("Verdana", Font.BOLD, 25));
        edit.setFont(new Font("Verdana", Font.BOLD, 25));
        delete.setFont(new Font("Verdana", Font.BOLD, 25));
        clear.setFont(new Font("Verdana", Font.BOLD, 25));
        detail_end.setBackground(Color.lightGray);
        detail_end.setOpaque(true);

        add.setBackground(Color.blue);
        edit.setBackground(Color.magenta);
        delete.setBackground(Color.red);
        clear.setBackground(Color.gray);

        add.setForeground(Color.white);
        edit.setForeground(Color.white);
        delete.setForeground(Color.white);
        clear.setForeground(Color.white);

        Border blackline = BorderFactory.createLineBorder(Color.black);
        detail.setBorder(blackline);
        id_input.setBorder(blackline);
        name_input.setBorder(blackline);
        mobile_input.setBorder(blackline);
        email_input.setBorder(blackline);
        gender_input.setBorder(blackline);
        dob_input.setBorder(blackline);
        address_input.setBorder(blackline);
        password_input.setBorder(blackline);
        detail_end.setBorder(blackline);

        f.add(detail);
        f.add(id);
        f.add(id_input);
        f.add(name);
        f.add(name_input);
        f.add(mobile);
        f.add(mobile_input);
        f.add(email);
        f.add(email_input);
        f.add(gender);
        f.add(gender_input);
        f.add(dob);
        f.add(dob_input);
        f.add(address);
        f.add(address_input);
        f.add(password);
        f.add(password_input);
        f.add(add);
        f.add(edit);
        f.add(delete);
        f.add(clear);
        f.add(detail_end);

        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Add(name_db, id_input, name_input, mobile_input, email_input, gender_input, dob_input, address_input, password_input);
                refresh_db(f,name_db);
            }

        });

        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (id_input.getText().isEmpty()) {
                    setWarningMsg("Pls enter ID Valid");
                } else {
                    String i = id_input.getText();
                    int id=Integer.parseInt(i);
                    int o=delete(name_db,id);
                    if(o==1)
                    {
                        JOptionPane.showMessageDialog(null, "Data Deleted Successfully...");
                        refresh_db(f,name_db);

                    }
                }
            }

        });

        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                id_input.setText("");
                name_input.setText("");
                mobile_input.setText("");
                email_input.setText("");
                gender_input.setSelectedItem(choices[0]);
                dob_input.setText("");
                address_input.setText("");
                password_input.setText("");
                refresh_db(f,name_db);
            }

        });


    }

    public static Object Tables (JFrame frame, String db_name , int type, String cond , String cond1,JTextField id_input,JTextField name_input,JTextField mobile_input,JTextField email_input,JComboBox<String> gender_input,JTextField dob_input,JTextField address_input,JTextField password_input) {
        Object[] rowData = new Object[0];
        try {
            String sql = makeq(type, db_name, cond1, cond);
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pms", "root", "root");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            DefaultTableModel model = new DefaultTableModel();
            ResultSetMetaData metaData = rs.getMetaData();
            JTable table = new JTable(model);
            JScrollPane scrollPane = new JScrollPane(table);
            scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
            int columnCount = metaData.getColumnCount();
            rowData = new Object[columnCount];
            for (int i = 1; i <= columnCount; i++) {
                model.addColumn(metaData.getColumnName(i));
            }
            while (rs.next()) {
                Object[] row = new Object[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    row[i - 1] = rs.getObject(i);
                }
                model.addRow(row);
            }

            // Create a JTable

            // Add a selection listener to the table
            Object[] finalRowData = rowData;
            table.getSelectionModel().addListSelectionListener(e -> {
                int row = table.getSelectedRow();
                for (int i = 0; i < columnCount; i++) {
                    finalRowData[i] = table.getValueAt(row, i);
                }
                        System.out.println(Arrays.toString(finalRowData));
                        id_input.setText(finalRowData[0].toString());
                        name_input.setText(finalRowData[1].toString());
                        mobile_input.setText(finalRowData[2].toString());
                        email_input.setText(finalRowData[3].toString());
                        gender_input.setSelectedItem(finalRowData[4]);
                        dob_input.setText(finalRowData[5].toString());
                        address_input.setText(finalRowData[6].toString());
                        password_input.setText(finalRowData[7].toString());
            }
            );


            Border blackline = BorderFactory.createLineBorder(Color.black);
            table.setBorder(blackline);
            table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
            table.setRowHeight(25);
            table.setFillsViewportHeight(true);

            //table.setFont(new Font("Verdana", Font.PLAIN, 15));
            table.setBounds(32, 662, 1851, 225);
            scrollPane.setBounds(1870, 662, 20, 200);

            if(db_name.equals("Parking_Slots"))
            {
                table.setBounds(32, 560, 1851, 330);

            }

            frame.add(table);
            scrollPane.setVisible(true);
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rowData;
    }

    public void Search (JFrame f,String name, String [] choices,String db_name,JTextField id_input,JTextField name_input,JTextField mobile_input,JTextField email_input,JComboBox<String> gender_input,JTextField dob_input,JTextField address_input,JTextField password_input) // Search bar Manage here
    {

        JLabel Main_heading = new JLabel(name+" Details");
        JLabel Search = new JLabel();
        JLabel Search_heading = new JLabel("  Search "+name);
        final JComboBox<String> cb = new JComboBox<String>(choices);
        JTextField Search_text = new JTextField();
        JButton Search_button= new JButton("Search");

        Main_heading.setBounds(820, 105, 250, 50);
        Search.setBounds(500,175,920,100);
        Search_heading.setBounds(510,155,160,40);
        cb.setBounds(520,200,200,50);
        Search_text.setBounds(760,200,400,50);
        Search_button.setBounds(1200,200,200,50);


        Main_heading.setFont(new Font("Verdana", Font.BOLD, 24));
        Search_heading.setFont(new Font("Verdana", Font.BOLD, 15));
        cb.setFont(new Font("Verdana", Font.PLAIN, 24));
        Search_text.setFont(new Font("Verdana", Font.PLAIN, 25));
        Search_button.setFont(new Font("Verdana", Font.PLAIN, 25));
        Main_heading.setBackground(Color.WHITE);
        cb.setBackground(Color.WHITE);
        //Search_heading.setBackground(Color.);

        cb.setOpaque(true);
        Main_heading.setOpaque(true);
        Search_heading.setOpaque(true);
        Border blackline = BorderFactory.createLineBorder(Color.black);
        Main_heading.setBorder(blackline);
        Search.setBorder(blackline);
        Search_text.setBorder(blackline);


        f.add(Search_button);
        f.add(Search_text);
        f.add(cb);
        f.add(Search_heading);
        f.add(Main_heading);
        f.add(Search);


        Search_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String C = cb.getSelectedItem().toString();
                String C1 = Search_text.getText();

                if(C.equals("Select"))
                {
                    setWarningMsg("Select the Flied");
                }
                else if(C.equals("ID"))
                {
                    Tables(f, db_name, 3, C1, C,id_input, name_input, mobile_input, email_input, gender_input, dob_input, address_input, password_input);
                }
                else if(C1.isEmpty())
                {
                    setWarningMsg("Enter the value");
                }
                else {
                    Tables(f, db_name, 2, C1, C,id_input, name_input, mobile_input, email_input, gender_input, dob_input, address_input, password_input);
                }
            }
        });

    }
}
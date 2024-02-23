import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Bill extends Main{
    public static int check(String get_input,JTextField p_id,JTextField p_type,JTextField v_id,JTextField v_no,JTextField c_id,JTextField c_no,JTextField date,JTextField time)
    {
        int o=0;
            try {
                int i=0;
                String Sql="select * from current_allocation where V_NO='"+get_input+"'";
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pms", "root", "root");
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(Sql);
                while (rs.next()) {
                    o = rs.getInt(1);
                    String a= rs.getString(2);
                    String b= rs.getString(3);
                    String c= rs.getString(4);
                    String d= rs.getString(5);
                    String e= rs.getString(6);
                    String f= rs.getString(7);
                    String g= rs.getString(8);
                    String h= rs.getString(9);
                    p_id.setText(a);
                    p_type.setText(b);
                    v_id.setText(c);
                    v_no.setText(d);
                    c_id.setText(e);
                    c_no.setText(f);
                    date.setText(g);
                    time.setText(h);
                    i++;
                }
                if(i==0)
                {
                    setWarningMsg("The Vehicle not Found in Parking Slot.");
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        return o;
    }
    public static long get_hours(String past_time,String current_time)
    {
        long t=0;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        //String per_date="27-11-2023 20:00:02";
        LocalDateTime date1 = LocalDateTime.parse(past_time, formatter);
        LocalDateTime date2 = LocalDateTime.parse(current_time,formatter);
        Duration duration = Duration.between(date1, date2);
        long hours = duration.toHours();
        t=hours;
        return t;
    }
    public static int add_sales(String p_id,String p_type,String v_id,String v_no,String c_id,String c_no,String date_in,String time_in,String date_out,String time_out,String amount,String hours)
    {
        int i=0;
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pms", "root", "root");
            String sql = "insert into sales values(?,?,?,?,?,?,?,?,?,?,?,?,?)";

            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, 0);
            pst.setString(2, p_id);
            pst.setString(3, p_type);
            pst.setString(4, v_id);
            pst.setString(5, v_no);
            pst.setString(6, c_id);
            pst.setString(7, c_no);
            pst.setString(8, date_in);
            pst.setString(9, time_in);
            pst.setString(10, date_out);
            pst.setString(11, time_out);
            pst.setString(12, amount);
            pst.setString(13, hours);
            pst.execute();
            i++;
            con.close();

        } catch (SQLException e)
        {
            System.out.println(e);
        }
        return i;
    }

    public static float get_amount(String condition)
    {
        float amt=0;
        try {
            String Sql="select Price from parking_slots "+condition+"Limit 1";
            System.out.println(Sql);
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pms", "root", "root");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(Sql);
            while (rs.next())
            {
                 amt= rs.getFloat(1);
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        return amt;
    }

    public static void delete_allocation(String id)
    {
        try {
            String Sql="delete from current_allocation where id="+id;
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pms", "root", "root");
            Statement st = con.createStatement();
            st.executeUpdate(Sql);
            con.close();
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
    public static void update_parking_status(String p_id)
    {
        try {
            String Sql="UPDATE parking_slots SET Status='Available' where id="+p_id;
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pms", "root", "root");
            Statement st = con.createStatement();
            st.executeUpdate(Sql);
            con.close();
        }
        catch (Exception e)
        {
            System.out.println(e);
        }

    }

    public static void main(String args[])
    {
        var a = new Bill();
        JFrame f= new JFrame("Parking Management System.");
        JLabel Main_heading = new JLabel("    Generate Bill");
        Main_heading.setBounds(800, 105, 250, 50);
        Main_heading.setFont(new Font("Verdana", Font.BOLD, 24));
        Main_heading.setOpaque(true);
        Border blackline = BorderFactory.createLineBorder(Color.black);
        Main_heading.setBorder(blackline);
        JTextArea bill = new JTextArea("            Parking Management System ");
        bill.setBounds(1330, 155, 550, 725);
        bill.setFont(new Font("Verdana", Font.PLAIN, 24));
        bill.setBorder(blackline);
        JLabel get = new JLabel("Enter the Vehicle Number");
        JTextField get_input = new JTextField("MH-12-");
        JButton Check = new JButton("Check");
        JButton Clear = new JButton("Clear");
        JLabel p_id = new JLabel("Park_ID");
        JLabel p_type = new JLabel("P_Type");
        JLabel v_id = new JLabel("Vech_ID");
        JLabel v_no = new JLabel("Vech_NO");
        JTextField p_id_input = new JTextField();
        JTextField p_type_input = new JTextField();
        JTextField v_id_input = new JTextField();
        JTextField v_no_input = new JTextField();
        JLabel c_id = new JLabel("Cust_ID");
        JLabel c_no = new JLabel("Cust_No");
        JLabel date = new JLabel("Date");
        JLabel time = new JLabel("Time");
        JTextField c_id_input = new JTextField();
        JTextField c_no_input = new JTextField();
        JTextField date_input = new JTextField();
        JTextField time_input = new JTextField();
        JLabel c_time = new JLabel("Curr_Time");
        JLabel c_date = new JLabel("Curr_Date");
        JLabel amount = new JLabel("Amount");
        JLabel hours = new JLabel("Total Hours");
        JTextField c_time_input = new JTextField();
        JTextField c_date_input = new JTextField();
        JTextField amount_input = new JTextField();
        JTextField hours_input = new JTextField();
        JButton calculate = new JButton("Calculate");
        JButton generate = new JButton("Generate");
        JButton clear = new JButton("Clear");
        JTextField current_allocate_id=new JTextField();
        p_id.setBounds(400, 300, 200, 50);
        p_type.setBounds(625, 300, 200, 50);
        v_id.setBounds(850, 300, 200, 50);
        v_no.setBounds(1075, 300, 200, 50);
        p_id_input.setBounds(400, 350, 200, 50);
        p_type_input.setBounds(625, 350, 200, 50);
        v_id_input.setBounds(850, 350, 200, 50);
        v_no_input.setBounds(1075, 350, 240, 50);
        c_id.setBounds(400, 425, 200, 50);
        c_no.setBounds(625, 425, 200, 50);
        date.setBounds(850, 425, 200, 50);
        time.setBounds(1075, 425, 200, 50);
        c_id_input.setBounds(400, 475, 200, 50);
        c_no_input.setBounds(625, 475, 200, 50);
        date_input.setBounds(850, 475, 200, 50);
        time_input.setBounds(1075,475, 240, 50);
        c_time.setBounds(400, 550, 200, 50);
        c_date.setBounds(625, 550, 200, 50);
        amount.setBounds(850, 550, 200, 50);
        hours.setBounds(1075, 550, 200, 50);
        c_time_input.setBounds(400, 600, 200, 50);
        c_date_input.setBounds(625, 600, 200, 50);
        amount_input.setBounds(850, 600, 200, 50);
        hours_input.setBounds(1075,600, 240, 50);
        get.setBounds(400, 190, 400, 50);
        get_input.setBounds(725,190,250,50);
        Check.setBounds(990,190,150,50);
        Clear.setBounds(1155,190,150,50);
        calculate.setBounds(450,700,250,50);
        generate.setBounds(725,700,250,50);
        clear.setBounds(1000,700,250,50);
        calculate.setFont(new Font("Verdana", Font.BOLD, 24));
        generate.setFont(new Font("Verdana", Font.BOLD, 24));
        clear.setFont(new Font("Verdana", Font.BOLD, 24));
        get.setFont(new Font("Verdana", Font.PLAIN, 24));
        get_input.setFont(new Font("Verdana", Font.PLAIN, 24));
        Check.setFont(new Font("Verdana", Font.BOLD, 24));
        Clear.setFont(new Font("Verdana", Font.BOLD, 24));
        p_id.setFont(new Font("Verdana", Font.PLAIN, 24));
        p_type.setFont(new Font("Verdana", Font.PLAIN, 24));
        v_id.setFont(new Font("Verdana", Font.PLAIN, 24));
        v_no.setFont(new Font("Verdana", Font.PLAIN, 24));
        p_id_input.setFont(new Font("Verdana", Font.PLAIN, 24));
        p_type_input.setFont(new Font("Verdana", Font.PLAIN, 24));
        v_id_input.setFont(new Font("Verdana", Font.PLAIN, 24));
        v_no_input.setFont(new Font("Verdana", Font.PLAIN, 24));
        c_id.setFont(new Font("Verdana", Font.PLAIN, 24));
        c_no.setFont(new Font("Verdana", Font.PLAIN, 24));
        date.setFont(new Font("Verdana", Font.PLAIN, 24));
        time.setFont(new Font("Verdana", Font.PLAIN, 24));
        c_id_input.setFont(new Font("Verdana", Font.PLAIN, 24));
        c_no_input.setFont(new Font("Verdana", Font.PLAIN, 24));
        date_input.setFont(new Font("Verdana", Font.PLAIN, 24));
        time_input.setFont(new Font("Verdana", Font.PLAIN, 24));
        c_time.setFont(new Font("Verdana", Font.PLAIN, 24));
        c_date.setFont(new Font("Verdana", Font.PLAIN, 24));
        amount.setFont(new Font("Verdana", Font.PLAIN, 24));
        hours.setFont(new Font("Verdana", Font.PLAIN, 24));
        c_time_input.setFont(new Font("Verdana", Font.PLAIN, 24));
        c_date_input.setFont(new Font("Verdana", Font.PLAIN, 24));
        amount_input.setFont(new Font("Verdana", Font.PLAIN, 24));
        hours_input.setFont(new Font("Verdana", Font.PLAIN, 24));
        p_id_input.setBackground(Color.white);
        p_type_input.setBackground(Color.white);
        v_id_input.setBackground(Color.white);
        v_no_input.setBackground(Color.white);
        c_id_input.setBackground(Color.white);
        c_no_input.setBackground(Color.white);
        date_input.setBackground(Color.white);
        time_input.setBackground(Color.white);
        c_time_input.setBackground(Color.white);
        c_date_input.setBackground(Color.white);
        amount_input.setBackground(Color.white);
        hours_input.setBackground(Color.white);
        p_id_input.setBorder(blackline);
        p_type_input.setBorder(blackline);
        v_id_input.setBorder(blackline);
        v_no_input.setBorder(blackline);
        c_id_input.setBorder(blackline);
        c_no_input.setBorder(blackline);
        date_input.setBorder(blackline);
        time_input.setBorder(blackline);
        c_time_input.setBorder(blackline);
        c_date_input.setBorder(blackline);
        amount_input.setBorder(blackline);
        hours_input.setBorder(blackline);
        bill.setEditable(false);
        p_id_input.setEditable(false);
        v_id_input.setEditable(false);
        p_type_input.setEditable(false);
        v_no_input.setEditable(false);
        c_id_input.setEditable(false);
        c_no_input.setEditable(false);
        date_input.setEditable(false);
        time_input.setEditable(false);
        c_time_input.setEditable(false);
        c_date_input.setEditable(false);
        amount_input.setEditable(false);
        hours_input.setEditable(false);
        f.add(c_time);
        f.add(c_date);
        f.add(amount);
        f.add(hours);
        f.add(calculate);
        f.add(generate);
        f.add(clear);
        f.add(c_date_input);
        f.add(c_time_input);
        f.add(amount_input);
        f.add(hours_input);
        f.add(p_id);
        f.add(p_type);
        f.add(v_id);
        f.add(v_no);
        f.add(p_id_input);
        f.add(p_type_input);
        f.add(v_id_input);
        f.add(v_no_input);
        f.add(c_id);
        f.add(c_no);
        f.add(date);
        f.add(time);
        f.add(c_id_input);
        f.add(c_no_input);
        f.add(date_input);
        f.add(time_input);
        f.add(get);
        f.add(Check);
        f.add(Clear);
        f.add(get_input);
        f.add(Main_heading);
        f.add(bill);
        a.main_side(f,5);
        a.NavbarFooter(f,"t");
        Thread clock = new Thread() {
            public void run() {
                while(true) {
                    java.util.Date date = new Date();
                    SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
                    String formattedDate = formatter.format(date);
                    c_time_input.setText(formattedDate);

                    SimpleDateFormat formatter1 = new SimpleDateFormat("dd-MM-yyyy");
                    String formattedDate1 = formatter1.format(date);
                    c_date_input.setText(formattedDate1);

                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        };
        clock.start();
        Check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             if(get_input.getText().isEmpty())
             {
                 setWarningMsg("Pls enter the Vehicle No.");
             }
             else {
                 String get=get_input.getText();
                int g=check(get,p_id_input,p_type_input,v_id_input,v_no_input,c_id_input,c_no_input,date_input,time_input);
                String o = Integer.toString(g);
                current_allocate_id.setText(o);
             }

            }
        });

        Clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               get_input.setText("");
            }
        });

        calculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              if(time_input.getText().isEmpty()||date_input.getText().isEmpty())
              {
                  setWarningMsg("Pls select the vehicle first.");
              }
              else
              {
                  String current_time = c_date_input.getText() + " " + c_time_input.getText();
                  String past_time = date_input.getText()+" "+time_input.getText();
                  long t=get_hours(past_time,current_time);
                  String f =Long.toString(t);
                  int g=Integer.parseInt(f);
                  if(g==0)
                  {
                      g++;
                  }
                  f=Integer.toString(g);
                  hours_input.setText(f);
                  String condition="where type='"+p_type_input.getText()+"' ";
                  System.out.println(condition);
                  float amt=get_amount(condition);
                  String hour=hours_input.getText();
                  float hours = Float.parseFloat(hour);
                  if(hours==0)
                  {
                      hours++;
                  }
                  float total= amt*hours;
                  String tt = Float.toString(total);
                  amount_input.setText(tt);
              }
            }
        });

        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                get_input.setText("MH-12-");
                p_id_input.setText("");
                p_type_input.setText("");
                v_id_input.setText("");
                v_no_input.setText("");
                c_id_input.setText("");
                c_no_input.setText("");
                date_input.setText("");
                time_input.setText("");
                amount_input.setText("");
                hours_input.setText("");
                bill.setText("            Parking Management System ");
                }
        });

        generate.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
           if(p_id_input.getText().isEmpty()||amount_input.getText().isEmpty()||hours_input.getText().isEmpty())
           {
               setWarningMsg("Flied are missing");
           }
           else
           {
               String p_id=p_id_input.getText();
               String p_type=p_type_input.getText();
               String v_id = v_id_input.getText();
               String v_no = v_no_input.getText();
               String c_id = c_id_input.getText();
               String c_no = c_no_input.getText();
               String date_in = date_input.getText();
               String time_in = time_input.getText();
               String date_out = c_date_input.getText();
               String time_out = c_time_input.getText();
               String amount = amount_input.getText();
               String hours = hours_input.getText();
               String curr_id = current_allocate_id.getText();
               float a = Float.parseFloat(amount);
               float b = Float.parseFloat(hours);
               float c = a/b;
               int i=add_sales(p_id,p_type,v_id,v_no, c_id,c_no,date_in,time_in,date_out, time_out, amount, hours);
               delete_allocation(curr_id);
               update_parking_status(p_id);
               String Bill= """
                                   Parking Management System,\s
                                              Pune-411041
                                              
                           Date - %s        Time - %s
                       --------------------------------------------------
                                              
                        Park_ID         %s
                        Park_type       %s
                        Vech_No         %s
                        Cust_No         %s
                        Date_In         %s
                        Time_In         %s
                        Date_Out        %s
                        Time_Out        %s
                        Total Hours     %s
                        \s
                               = Total Hours X Per Hour Charge
                               = %sX%s
                               = %s
                       --------------------------------------------------
                         Total Amount = %s/-
                                              
                       """.formatted(date_out,time_out,p_id,p_type,v_no,c_no,date_in,time_in,date_out,time_out,hours,hours,c,amount,amount);
               bill.setText(Bill);
               System.out.println(bill);
               JOptionPane.showMessageDialog(null, "Bill Generated Successfully..");
               get_input.setText("MH-12-");
               p_id_input.setText("");
               p_type_input.setText("");
               v_id_input.setText("");
               v_no_input.setText("");
               c_id_input.setText("");
               c_no_input.setText("");
               date_input.setText("");
               time_input.setText("");
               amount_input.setText("");
               hours_input.setText("");
               //bill.setText("            Parking Management System ");

           }
        }

    });
    }
}

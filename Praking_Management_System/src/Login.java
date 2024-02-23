import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Login extends Main
{

  public static int check(String user_id, String password)
  {
    int i=0;
    try {
      String Sql = "select * from employee where id="+user_id+" and password='"+password+"'";
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pms", "root", "root");
      Statement st = con.createStatement();
      ResultSet rs = st.executeQuery(Sql);
      while (rs.next())
      {
        int s = rs.getInt(1);
        i++;
      }
      con.close();
    }
    catch (Exception e)
    {
      System.out.println(e);
    }
    return i;
  }

    public static void main(String [] args)
    {
      var a = new Login();
      JFrame f = new JFrame("Parking Management System");
      JLabel block = new JLabel();
      JLabel title = new JLabel("Login Page");
      JLabel eid = new JLabel("Enter the Employee_ID");
      JTextField eid_input =new JTextField();
      JLabel pass = new JLabel("  Enter the Password");
      JTextField pass_input =new JTextField();
      JButton submit = new JButton("Submit");
      JButton clear  = new JButton("Clear");


      title.setFont(new Font("Verdana", Font.BOLD, 30));
      eid.setFont(new Font("Verdana", Font.PLAIN, 25));
      eid_input.setFont(new Font("Verdana", Font.PLAIN, 25));
      pass.setFont(new Font("Verdana", Font.PLAIN, 25));
      pass_input.setFont(new Font("Verdana", Font.PLAIN, 25));
      submit.setFont(new Font("Verdana", Font.BOLD, 25));
      clear.setFont(new Font("Verdana", Font.BOLD, 25));

      block.setBounds(650,150,600,730);
      title.setBounds(845,170,200,50);
      eid.setBounds(795,320,400,50);
      eid_input.setBounds(795,390,290,50);
      pass.setBounds(795,460,400,50);
      pass_input.setBounds(795,520,290,50);
      submit.setBounds(795,625,290,50);
      clear.setBounds(795,700,290,50);  

      Border blackline = BorderFactory.createLineBorder(Color.black);
      block.setBorder(blackline);

      f.add(block);
      f.add(title);
      f.add(eid);
      f.add(eid_input);
      f.add(pass);
      f.add(pass_input);
      f.add(submit);
      f.add(clear);
      a.NavbarFooter(f,"f");

      submit.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          String eid=eid_input.getText();
          String pass=pass_input.getText();
          int con = Integer.parseInt(eid);
          if(eid.isEmpty()||pass.isEmpty())
          {
            setWarningMsg("Pls enter all the fields");
          }
          else
          {
            int i = check(eid,pass);
            System.out.println(i);
            if(i==1)
            {
              System.out.println("Success");
              if(con<=10)
              {
                try {
                  Runtime.getRuntime().exec("\"C:\\Program Files\\Java\\jdk-18.0.2.1\\bin\\java.exe\" \"-javaagent:C:\\Program Files\\JetBrains\\IntelliJ IDEA Community Edition 2022.3\\lib\\idea_rt.jar=50123:C:\\Program Files\\JetBrains\\IntelliJ IDEA Community Edition 2022.3\\bin\" -Dfile.encoding=UTF-8 -Dsun.stdout.encoding=UTF-8 -Dsun.stderr.encoding=UTF-8 -classpath \"C:\\Users\\prasa\\Desktop\\Parking Managment System\\out\\production\\Parking Managment System;C:\\Program Files (x86)\\MySQL\\Connector J 8.0\\mysql-connector-j-8.0.33.jar\" dashboard");
                } catch (IOException ex) {
                  throw new RuntimeException(ex);
                }
                f.dispose();
              }
              else
              {
                try {
                  Runtime.getRuntime().exec("\"C:\\Program Files\\Java\\jdk-18.0.2.1\\bin\\java.exe\" \"-javaagent:C:\\Program Files\\JetBrains\\IntelliJ IDEA Community Edition 2022.3\\lib\\idea_rt.jar=58274:C:\\Program Files\\JetBrains\\IntelliJ IDEA Community Edition 2022.3\\bin\" -Dfile.encoding=UTF-8 -Dsun.stdout.encoding=UTF-8 -Dsun.stderr.encoding=UTF-8 -classpath \"C:\\Users\\prasa\\Desktop\\Parking Managment System\\out\\production\\Parking Managment System;C:\\Program Files (x86)\\MySQL\\Connector J 8.0\\mysql-connector-j-8.0.33.jar\" Main_dashboard");
                } catch (IOException ex) {
                  throw new RuntimeException(ex);
                }
                f.dispose();
              }
            }
            else
            {
              setWarningMsg("Pls Enter Valid Username and Password.");
            }
          }

        }

      });

      clear.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          eid_input.setText("");
          pass_input.setText("");
        }
      });
    }
}
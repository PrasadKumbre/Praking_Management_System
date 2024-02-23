import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;
import java.util.Arrays;

public class Employee extends Main  {
    public static void main(String[] args)
    {
        String [] c = {"Select","Male","Female"};
        JTextField id_input = new JTextField();
        JTextField name_input = new JTextField();
        JTextField mobile_input = new JTextField();
        JTextField email_input = new JTextField();
        JComboBox<String> gender_input = new JComboBox<String>(c);
        JTextField dob_input = new JTextField();
        JTextField address_input = new JTextField();
        JTextField password_input = new JTextField();
        var a = new Employee();
        String [] n = {"E_ID","Name","Mobile","Email","Gender","D.O.B","Address","Password"};
        String [] choices = {"Select","ID","Name","Mobile"};
        //String [] tc ={"id_input","name_input","mobile_input","email_input","gender_input","dob_input","address_input","password_input"};
        JFrame f = new JFrame("Parking Management System");
        a.Search(f," Employee",choices,"Employee",id_input, name_input, mobile_input, email_input, gender_input, dob_input, address_input, password_input);
        a.details(f,n,"Employee",c,id_input,name_input,mobile_input,email_input,gender_input,dob_input,address_input,password_input);
        a.NavbarFooter(f,"f");
        a.Tables(f,"Employee",1,null,null,id_input,name_input,mobile_input,email_input,gender_input,dob_input,address_input,password_input);
        //a.Table(f,"employee",2,"P","name");
    }
}
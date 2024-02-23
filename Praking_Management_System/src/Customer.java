import javax.swing.*;

public class Customer extends Main
{
    public static void main(String[] args)
    {
        var a = new Customer();
        String [] c = {"Select","Male","Female"};
        JTextField id_input = new JTextField();
        JTextField name_input = new JTextField();
        JTextField mobile_input = new JTextField();
        JTextField email_input = new JTextField();
        JComboBox<String> gender_input = new JComboBox<String>(c);
        JTextField dob_input = new JTextField();
        JTextField address_input = new JTextField();
        JTextField password_input = new JTextField();
        String [] n = {"C_ID","Name","Mobile","Email","Gender","D.O.B","Address","SecMobile"};
        String [] choices = {"Select","ID","Name","Mobile"};
        //String [] tc ={"id_input","name_input","mobile_input","email_input","gender_input","dob_input","address_input","password_input"};
        JFrame f = new JFrame("Parking Management System");
        //a.SearchArea(f," Customer",choices,"Customer");
        //a.detail(f,n,"Customer",c);
        a.Search(f," Customer",choices,"Customer",id_input, name_input, mobile_input, email_input, gender_input, dob_input, address_input, password_input);
        a.details(f,n,"Customer",c,id_input,name_input,mobile_input,email_input,gender_input,dob_input,address_input,password_input);
        a.NavbarFooter(f,"f");
        a.Tables(f,"Customer",1,null,null,id_input,name_input,mobile_input,email_input,gender_input,dob_input,address_input,password_input);
        //a.NavbarFooter(f,"f");
        //a.Table(f,"Customer",1,null,null);
    }
}
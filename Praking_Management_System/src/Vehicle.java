import javax.swing.*;

public class Vehicle extends Main {

    public static void main(String[] args)
    {
        var a = new Vehicle();
        String [] c = {"Select","Bike","Car"};
        String [] n = {"V_ID","Number","Name","Color","Type","Desc","Email","mobile"};
        String [] choices = {"Select","ID","Number","Mobile"};
        String [] tc ={"id_input","name_input","mobile_input","email_input","gender_input","dob_input","address_input","password_input"};
        JFrame f = new JFrame("Parking Management System");
        a.SearchArea(f," Vehicle",choices,"Vehicle");
        a.detail(f,n,"Vehicle",c);
        a.NavbarFooter(f,"f");
        a.Table(f,"Vehicle",1,null,null);
        //a.Table(f,"employee",2,"P","name");
    }
}
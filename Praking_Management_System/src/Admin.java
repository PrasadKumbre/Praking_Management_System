import javax.swing.*;

public class Admin extends Main {

    public static void main(String[] args)
    {
        var a = new Admin();
        String [] choices = {"Select","Admin_ID","Name","Contact_no"};
        JFrame f = new JFrame("Parking Management System");
        a.SearchArea(f,"   Admin",choices,"");
        //a.NavbarFooter(f);
    }
}
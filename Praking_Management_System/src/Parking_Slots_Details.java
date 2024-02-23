import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Parking_Slots_Details extends Main{

    public void detail_main(JFrame f,String [] n,String name_db,String [] choices, String [] choice1) // Form for Add , Edit, Delete, Clear are manage here.
    {
        JLabel detail = new JLabel();
        JLabel type = new JLabel(n[0]);
        JComboBox<String> type_input = new JComboBox<String>(choices);
        JLabel price = new JLabel(n[1]);
        JTextField price_input = new JTextField();
        JLabel qty = new JLabel(n[2]);
        JTextField qty_input = new JTextField();
        JLabel status = new JLabel(n[3]);
        JComboBox type_input1 = new JComboBox<String>(choice1);
        JButton add = new JButton("Add");
        JButton edit = new JButton("Edit");
        JButton delete = new JButton("Delete");
        JButton clear = new JButton("Clear");
        JLabel detail_end = new JLabel();
        detail.setBounds(20,300,1875,20);

        type.setBounds(180,360,200,50);
        type_input.setBounds(300,365,200,45);

        price.setBounds(550,360,200,50);
        price_input.setBounds(650,365,200,45);

        qty.setBounds(900,360,200,50);
        qty_input.setBounds(1000,365,200,45);

        status.setBounds(1250,360,200,50);
        type_input1.setBounds(1380,365,200,45);

        add.setBounds(450,440,200,50);
        edit.setBounds(700,440,200,50);
        delete.setBounds(950,440,200,50);
        clear.setBounds(1200,440,200,50);
        detail_end.setBounds(20,530,1875,20);

        detail.setBackground(Color.lightGray);
        detail.setOpaque(true);
        type.setFont(new Font("Verdana", Font.PLAIN, 25));
        price.setFont(new Font("Verdana", Font.PLAIN, 25));
        price_input.setFont(new Font("Verdana", Font.PLAIN, 25));
        qty.setFont(new Font("Verdana", Font.PLAIN, 25));
        qty_input.setFont(new Font("Verdana", Font.PLAIN, 25));
        status.setFont(new Font("Verdana", Font.PLAIN, 25));
        type_input1.setFont(new Font("Verdana", Font.PLAIN, 25));
        type_input.setFont(new Font("Verdana", Font.PLAIN, 25));
        type_input.setBackground(Color.WHITE);
        type_input1.setBackground(Color.WHITE);


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
        price_input.setBorder(blackline);
        qty_input.setBorder(blackline);
        type_input1.setBorder(blackline);
        type_input.setBorder(blackline);
        detail_end.setBorder(blackline);

        f.add(detail);
        f.add(type);
        f.add(price);
        f.add(price_input);
        f.add(qty);
        f.add(qty_input);
        f.add(status);
        f.add(type_input1);
        f.add(type_input);
        f.add(add);
        f.add(edit);
        f.add(delete);
        f.add(clear);
        f.add(detail_end);

        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String type = type_input.getSelectedItem().toString();
                String price = price_input.getText();
                String qty = qty_input.getText();

                if(type.equals("Select"))
                {
                    setWarningMsg("Select the Type");
                }

                else if(price.isEmpty()||qty.isEmpty())
                {
                    setWarningMsg("Fields are missing");
                }
                else {
                    Add_main(name_db, type, price, qty, type_input1);
                }
            }
        });

    }
    public void Add_main(String name_db,String type, String price, String qty,JComboBox type_input1) {
        String status = type_input1.getSelectedItem().toString();
        int n = Integer.parseInt(qty);
        try {
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pms", "root", "root");

                String sql = "insert into "+name_db+" values(?,?,?,?)";

                  for(int i=1;i<=n;i++) {
                      PreparedStatement pst = con.prepareStatement(sql);
                      pst.setString(1, null);
                      pst.setString(2, type);
                      pst.setString(3, price);
                      pst.setString(4, status);
                      pst.execute();
                  }

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
    public static void setWarningMsg(String text){
        Toolkit.getDefaultToolkit().beep();
        JOptionPane optionPane = new JOptionPane(text,JOptionPane.WARNING_MESSAGE);
        JDialog dialog = optionPane.createDialog("Warning!");
        dialog.setAlwaysOnTop(true);
        dialog.setVisible(true);
    }

    public static void main (String[] args)
    {
        String [] c = {"Select","Bike","Car"};
        String [] c1={"Available","UnAvailable"};
        String [] n = {"Type","Price","QTY","Status"};
        String [] choices ={"Select","Type","Status"};
        var a = new Parking_Slots_Details();
        JFrame f = new JFrame("Parking Management System");
        a.SearchArea(f," Parking Slots",choices,"Parking_Slots");
        a.detail_main(f,n,"Parking_Slots",c,c1);
        a.NavbarFooter(f,"f");
        a.Table(f,"Parking_Slots",1,null,null);
    }
}

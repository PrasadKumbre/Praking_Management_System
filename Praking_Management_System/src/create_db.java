import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class create_db {
    public static void main(String[] args){
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pms", "root", "root");
            //String sql1= "create table Employee (id int(10) primary key, name varchar(30), mobile varchar(30) unique, email varchar(30) unique, gender varchar(10), dob varchar(10),address varchar(30), password varchar(30));";
            //String sql2 = "create table parking_slots(id integer primary key AUTO_INCREMENT,Type varchar(30),Price float,Status Varchar(30))";
            //String sql3="create table customer(id integer primary key AUTO_INCREMENT, name varchar(30), mobile varchar(30),email varchar(30), gender varchar(30),dob varchar(30),address varchar(30), snumber varchar(30))";
            //String sql4="create table vehicle(id integer primary key AUTO_INCREMENT, Number varchar(30) UNIQUE, Name Varchar(30), color varchar(30), Type varchar(30) , des varchar(30),email varchar(30), mobile varchar(30))";
            //String sql5="create table Current_Allocation(ID integer primary key AUTO_INCREMENT, P_ID varchar(10), P_Type varchar(20), V_ID varchar(10) UNIQUE, V_NO varchar(30), C_ID varchar(30), C_NO varchar(30), Curr_Date varchar(30), Curr_time varchar(30))";
            String sql6="create table sales(S_id integer primary key AUTO_INCREMENT,P_id varchar(10),p_type varchar(10),v_id varchar(10),v_no varchar(30),c_id varchar(10),c_no varchar(30),date_in varchar(30),time_in varchar(30),date_out varchar(30),time_out varchar(30),amount varchar(30),hours varchar(30));";
            Statement st = con.createStatement();
            st.execute(sql6);
            System.out.println("Successful");
            //String sql1="create table Employee;";
            //Statement st = con.createStatement();
            //st.execute(sql1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
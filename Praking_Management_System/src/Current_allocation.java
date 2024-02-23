import java.awt.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.*;

public class Current_allocation  {
    public static void main(String[] args) {
        try {
            //Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pms", "root", "root");
            String query = "SELECT * FROM current_allocation";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            // Get the ResultSet metadata to determine the column names
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();
            // Create the column names array
            String[] columnNames = new String[columnCount];
            for (int i = 1; i <= columnCount; i++) {
                columnNames[i - 1] = metaData.getColumnName(i);
            }
            // Create the table model with dynamic column names
            DefaultTableModel model = new DefaultTableModel();
            for (String columnName : columnNames) {
                model.addColumn(columnName);
            }
            // Populate the table model with data from the ResultSet
            while (resultSet.next()) {
                Object[] row = new Object[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    row[i - 1] = resultSet.getObject(i);
                }
                model.addRow(row);
            }
            // Create the JTable and JScrollPane
            JTable table = new JTable(model);
            table.setRowHeight(25);
            table.setFont(new Font("Verdana", Font.PLAIN, 15));
            JScrollPane scrollPane = new JScrollPane(table);
            // Create the JFrame and display the JTable
            JFrame frame = new JFrame("Sales Details");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(scrollPane);
            frame.setSize(1750,800);
            frame.setVisible(true);
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
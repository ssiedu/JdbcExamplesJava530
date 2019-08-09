
import java.sql.*;

public class DataEntry {

    public static void main(String[] args) {
        try {
            //step-1 (Driver-Loading)
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver Loaded");
            //step-2 (Connection Establishment)
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/data5", "root", "root");
            System.out.println("Connected Successfully");
            //step-3 (Define SQL Statement)
            System.out.println("SENDING SQL TO DB......");
            String sql="INSERT INTO EMP VALUES(113,'CCC',30000,'SALESMAN')";
            //step-4 (Send the SQL statement to DB)
            Statement stmt=con.createStatement();
            int n=stmt.executeUpdate(sql);
            //step-5 (Close the Database Connection)
            con.close();
            System.out.println(n+" Row Added");
            
            
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }
}


import java.sql.*;



public class DataEntry {

    public static void main(String[] args) {
        try {
            //step-1 (Driver-Loading)
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver Loaded");
            //step-2 (Connection Establishment)
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/data5", "root","root");
            System.out.println("Connected Successfully");
            
        } catch (ClassNotFoundException ex) {
          ex.printStackTrace();
        } catch (SQLException ex) {
          ex.printStackTrace();
        }
        
        
                
        
        
    }
}


import java.sql.Connection;
import java.sql.Statement;


public class TableCreation {
    public static void main(String[] args) throws Exception {
        Connection con=Data.connect();
        Statement stmt=con.createStatement();
        String sql="CREATE TABLE Test(col1 char, col2 char)";
        //String sql="DROP TABLE test";
        int n=stmt.executeUpdate(sql);
        System.out.println(n);
        System.out.println("Table Created");
        con.close();
    }
}

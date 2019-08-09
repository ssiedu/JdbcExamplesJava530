
import java.sql.Connection;
import java.sql.Statement;


public class ModifyData {

    public static void main(String[] args) throws Exception {
        Connection con=Data.connct();
        String sql="UPDATE EMP SET SAL=SAL+1000";
        Statement stmt=con.createStatement();
        int n=stmt.executeUpdate(sql);
        con.close();
        System.out.println(n+" row(s) modified");
        
    }
}

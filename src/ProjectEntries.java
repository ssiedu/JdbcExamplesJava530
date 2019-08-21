
import java.sql.Connection;
import java.sql.Statement;


public class ProjectEntries {

    public static void main(String[] args) throws Exception {
        Connection con=Data.connect();
        Statement stmt=con.createStatement();
        stmt.executeUpdate("insert into projects values('p111','AcSw','HDFC')");
        stmt.executeUpdate("insert into projects values('p112','BnkSw','ICICI')");
        stmt.executeUpdate("insert into projects values('p113','ERP','IBM')");
        con.close();
        System.out.println("PROJECTS ADDED");
        
    }

}

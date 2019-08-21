
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ProjectSalariesTwo {
public static void main(String[] args) throws Exception {

        Connection con=Data.connect();
        Statement stmt=con.createStatement();
        String sql="select pcode,SUM(sal) from emp group by pcode";
        ResultSet rs=stmt.executeQuery(sql);
        while(rs.next()){
            System.out.println(rs.getString(1)+"\t"+rs.getString(2));
        }
        con.close();
    }    
}

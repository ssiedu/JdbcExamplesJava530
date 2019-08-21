
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


public class EmpProjectInfo {

    public static void main(String[] args) throws Exception {
        String sql="SELECT ENAME, PNAME FROM EMP,PROJECTS WHERE EMP.PCODE=PROJECTS.PCODE";
        Connection con=Data.connect();
        Statement stmt=con.createStatement();
        ResultSet rs=stmt.executeQuery(sql);
        while(rs.next()){
            System.out.println(rs.getString(1)+","+rs.getString(2));
        }
        con.close();
    }

}

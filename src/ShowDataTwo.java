
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


public class ShowDataTwo {
public static void main(String[] args) throws Exception {
        Connection con = Data.connect();
        String sql = "SELECT eno,ename,sal,desg,sal*12 FROM EMP";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next()){
            String s1=rs.getString(1);
            String s2=rs.getString(2);
            String s3=rs.getString(3);
            String s4=rs.getString(4);
            String s5=rs.getString(5);
            System.out.println(s1+","+s2+","+s3+","+s4+","+s5);
        }
        
        
        
        
        
        
        
      

        con.close();
    }    
}

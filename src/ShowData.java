
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ShowData {

    public static void main(String[] args) throws Exception {
        Connection con = Data.connect();
        String sql = "SELECT * FROM EMP";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        
        while(rs.next()){
            System.out.println(rs.getString(1));
        }
        rs.beforeFirst();//we are setting cursor to first row
        while(rs.next()){
            System.out.println(rs.getString(2));
        }
        rs.beforeFirst();
        while(rs.next()){
            System.out.println(rs.getString(3));
        }
        
        /*
        rs.last();
        String s1=rs.getString(1);
        String s2=rs.getString(2);
        String s3=rs.getString(3);
        System.out.println(s1+","+s2+","+s3);
        
        rs.previous();
        s1=rs.getString(1);
        s2=rs.getString(2);
        s3=rs.getString(3);
        System.out.println(s1+","+s2+","+s3);
        
        rs.first();
        s1=rs.getString(1);
        s2=rs.getString(2);
        s3=rs.getString(3);
        System.out.println(s1+","+s2+","+s3);
        
        rs.absolute(3);
        s1=rs.getString(1);
        s2=rs.getString(2);
        s3=rs.getString(3);
        System.out.println(s1+","+s2+","+s3);
        */
        /*
        while(rs.next()){
            String s1=rs.getString(1);
            String s2=rs.getString(2);
            String s3=rs.getString(3);
            System.out.println(s1+","+s2+","+s3);
        }
        */
        
        
        
        
        
        
        
        
        
        
      

        con.close();
    }
}

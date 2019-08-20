import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class ResultSetUpdation {
    public static void main(String[] args) throws Exception {
        Connection con = Data.connect();
        String sql = "SELECT * FROM EMP";
        //Statement stmt = con.createStatement();
        Statement stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next()){
            String s1=rs.getString(1);
            String s2=rs.getString(2);
            String s3=rs.getString(3);
            String s4=rs.getString(4);
            System.out.println(s1+","+s2+","+s3+","+s4);
        }
        Scanner sc=new Scanner(System.in);
        System.out.println("Row To Be Modified");
        int n=sc.nextInt();
        System.out.println("New Amount For Salary");
        int val=sc.nextInt();
        //we wish to change the salary of 3rd row to 35000
        //step-1 (moving the cursor to row-3
        rs.absolute(n);
        //step-2 (modify the column(s) using updatter methods
        rs.updateInt(3, val);
        //step-3 (save the changes to DB)
        rs.updateRow();
        System.out.println("RECORD MODIFIED");
        System.out.println("AFTER UPDATION NEW RESULTSET");
        rs.beforeFirst();
        while(rs.next()){
            String s1=rs.getString(1);
            String s2=rs.getString(2);
            String s3=rs.getString(3);
            String s4=rs.getString(4);
            System.out.println(s1+","+s2+","+s3+","+s4);
        }
        
        con.close();
    }    
}

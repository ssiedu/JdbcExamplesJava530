import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class ResultSetDeletion {
    public static void main(String[] args) throws Exception {
        Connection con = Data.connect();
        String sql = "SELECT * FROM EMP";
        Statement stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next()){
            String s1=rs.getString(1);
            String s2=rs.getString(2);
            String s3=rs.getString(3);
            String s4=rs.getString(4);
            System.out.println(s1+","+s2+","+s3+","+s4);
        }
        System.out.println("___________________________");
        System.out.println("Enter Rno To Be Removed");
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        //moving the cursor to row to be deleted
        rs.absolute(n);
        //delete the row
        rs.deleteRow();
        System.out.println("ROW DELETED SUCCESSFULLY");
        System.out.println("NEW RESULT SET AFTER DELETION");
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

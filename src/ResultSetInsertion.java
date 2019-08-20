import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class ResultSetInsertion {
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
        System.out.println("Add A New Record : ");
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Eno       : ");
        int eno=sc.nextInt();
        System.out.println("Enter Ename     : ");
        String name=sc.next();
        System.out.println("Enter Salary    : ");
        int sal=sc.nextInt();
        System.out.println("Enter Desg      : ");
        String desg=sc.next();
        
        //Inserting A Row
        //step-1 (creating a blank row)
        rs.moveToInsertRow();
        //step-2 (update the null values with desired data)
        rs.updateInt(1, eno);
        rs.updateString(2, name);
        rs.updateInt(3, sal);
        //rs.updateString(4,desg);
        //step-3 (add newly inserted row to DB)
        rs.insertRow();
        System.out.println("ROW INSERTED SUCCESSFULLY");
        System.out.println("NEW RESULT SET AFTER INSERTION");
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

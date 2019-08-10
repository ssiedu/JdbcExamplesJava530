
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;


public class EmpEntry {

    public static void main(String[] args) throws Exception {
        String sql="INSERT INTO EMP VALUES(?,?,?,?)";
        Connection con=Data.connect();
        PreparedStatement ps=con.prepareStatement(sql);
        Scanner sc=new Scanner(System.in);
        
        for(int i=1; i<=5; i++){
            System.out.println("Enter ECode  : ");
            int v1=sc.nextInt();
            System.out.println("Enter EName  : ");
            String v2=sc.next();
            System.out.println("Enter Salary : ");
            int v3=sc.nextInt();
            System.out.println("Enter Desg   : ");
            String v4=sc.next();
            ps.setInt(1,v1);
            ps.setString(2,v2);
            ps.setInt(3, v3);
            ps.setString(4, v4);
            int n=ps.executeUpdate();
            System.out.println(n+ " ROW ADDED");
        }
        con.close();
    }

}

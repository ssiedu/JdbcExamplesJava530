
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


public class ProjectSalaries {

    public static void main(String[] args) throws Exception {

        Connection con=Data.connect();
        Statement stmt=con.createStatement();
        String sql="select * from emp";
        ResultSet rs=stmt.executeQuery(sql);
        int tot1=0,tot2=0,tot3=0;
        while(rs.next()){
            String code=rs.getString("pcode");
            int sal=rs.getInt("sal");
            switch(code){
                case "p111":
                    tot1=tot1+sal;
                break;
                case "p112":
                    tot2=tot2+sal;
                break;
                case "p113":
                    tot3=tot3+sal;
                break;
            }
        }
        
        System.out.println("P111=>  "+tot1);
        System.out.println("P112=>  "+tot2);
        System.out.println("P113=>  "+tot3);
        con.close();
    }
}

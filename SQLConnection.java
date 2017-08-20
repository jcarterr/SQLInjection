import java.sql.*;

/**
 *
 * @author Jordan Carter-Reich
 */
public class SQLConnection {

   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB= "jdbc:mysql://localhost/test/crappy_table";
   static final String USER = "root";
   static final String PASS = "MyNewPass";
   
   public static void main(String[] args) {
   Connection conn = null;
   Statement stmt = null;
   
   try{
      Class.forName("com.mysql.jdbc.Driver");

      conn = DriverManager.getConnection(DB,USER,PASS);
    
   
    }catch (SQLException se){
    	se.printStackTrace();
    }catch (Exception e){
    	e.printStackTrace();
    }
   	finally{}
    }
}
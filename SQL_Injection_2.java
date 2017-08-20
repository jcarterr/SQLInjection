/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author trypson
 */

public class SQL_Injection_2 {
    //Declare variables
    static Connection con;
    static ResultSet rs = null;
    
    static Statement stmt;
    
    //SQL Connection method
    public static void getConnected(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "MyNewPass" );
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ce){
            ce.printStackTrace();
        }
    }
    
    public static void getResults(String query){
       try{ 
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            if (rs.next()){
                    String firstname = rs.getString("FirstName");
                    String lastname = rs.getString("LastName");
                    System.out.println(firstname +"\t" + lastname);
            }else{
                System.out.println("No results");
            }
       }catch(SQLException se){
           se.printStackTrace();
       }
    }
    
    //Main
    public static void main(String args[]){
        
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter Employeee Number of employee: ");
        String input = scanner.next();
        String sql = "SELECT * FROM crappy_table WHERE EmpNum = " + input;
        getConnected();
        getResults(sql);
        try{
        con.close();
        }catch (SQLException se){
            
        }
    }
}



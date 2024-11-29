package logic;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserVerification
 */
@WebServlet("/UserVerification")
public class UserVerification extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public static void addUser(int id,String username,String gmail,String pass) {
    	String url = "jdbc:mysql://localhost:3306/TRX_JFSD_03"; // Change "mydatabase" to your database name
        String user = "root"; // Replace with your database username
        String password = "Mohan@1458"; // Replace with your database password

        // JDBC variables for opening and managing connection
        Connection connection = null;
        Statement statement = null;
        int rows =0 ;
        try {
        	connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connection established!");

            // 2. Create a statement
            statement = connection.createStatement();

            // 3. Execute a query
            String sql = "INSERT INTO user  VALUES ("+id+','+"'" +username +"' ',' "+"'"+gmail+"'"+','+"'"+pass+" ')";
            System.out.println(sql);
            
            rows = statement.executeUpdate(sql);

            // 4. Process the ResultSet object
            if(rows!=0) {
            	System.out.println("Update successfull!");
            }else {
            	System.out.println("Update failed!");
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            // 5. Close the resources
            try {
            	
            	if (statement != null) statement.close();
                if (connection != null) connection.close();
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    
    //For updating user from db
    public static void updateUsers(int id ,String pass) {
    	
    	 
    	// JDBC URL, username, and password of MySQL server
        String url = "jdbc:mysql://localhost:3306/TRX_JFSD_03"; // Change "mydatabase" to your database name
        String user = "root"; // Replace with your database username
        String password = "Mohan@1458"; // Replace with your database password

        // JDBC variables for opening and managing connection
        Connection connection = null;
        Statement statement = null;
        int rows = 0 ;
        try {
            // 1. Open a connection
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connection established!");

            // 2. Create a statement
            statement = connection.createStatement();

            // 3. Execute a query
            String sql = "update user set password='"+pass+"' where id="+id;
            
            
            rows = statement.executeUpdate(sql);

            // 4. Process the ResultSet object
            if(rows!=0) {
            	System.out.println("Update successfull!");
            }else {
            	System.out.println("Update failed!");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 5. Close the resources
            try {
            	
            	if (statement != null) statement.close();
                if (connection != null) connection.close();
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
            
    }
    
    //For printing users from database(mySql)
    public static void printUsers() {
    	// JDBC URL, username, and password of MySQL server
        String url = "jdbc:mysql://localhost:3306/TRX_JFSD_03"; // Change "mydatabase" to your database name
        String user = "root"; // Replace with your database username
        String password = "Mohan@1458"; // Replace with your database password

        // JDBC variables for opening and managing connection
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null ;
        try {
            // 1. Open a connection
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connection established!");

            // 2. Create a statement
            statement = connection.createStatement();

            // 3. Execute a query
            String query = "SELECT * FROM user ";
            
            resultSet = statement.executeQuery(query);

            // 4. Process the ResultSet object
            while (resultSet.next()) {
                // Assume mytable has columns id (int) and name (String)
                int id = resultSet.getInt("id");
                String username= resultSet.getString("username");
                String Password= resultSet.getString("password");

               // String startTime = resultSet.getString("start_time");
               // String endTime = resultSet.getString("end_time");
               // String greet = resultSet.getString("greeting");
                
                //System.out.println(resultSet);
                //System.out.println(connection);
                //System.out.println(statement);
                System.out.println("ID: " + id + ", Username " + username + ", Password "+ Password );
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 5. Close the resources
            try {
            	if (resultSet != null) resultSet.close();
            	if (statement != null) statement.close();
                if (connection != null) connection.close();
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
   
    public static boolean checkUser(String email,String password1) {
    	  String url = "jdbc:mysql://localhost:3306/TRX_JFSD_03"; // Change "mydatabase" to your database name
          String user = "root"; // Replace with your database username
          String password = "Mohan@1458";
          Connection connection = null;
          Statement statement = null;
          ResultSet resultSet = null ;
          try {
              Class.forName("com.mysql.cj.jdbc.Driver");
        	  // 1. Open a connection
              connection = DriverManager.getConnection(url, user, password);
              System.out.println("Connection established!");

              // 2. Create a statement
              

              // 3. Execute a query
              String query = "SELECT * FROM user where gmail='"+email+"' and User_Password='"+password1+"'";
              statement = connection.createStatement();
              resultSet = statement.executeQuery(query);

              // 4. Process the ResultSet object
             
                  // Assume mytable has columns id (int) and name (String)
              if(resultSet.next()) {
            	 return true; 
              }
              else {
            	  return false;
              }
                  
                
          } catch (Exception e) {
              e.printStackTrace();
          } finally {
              // 5. Close the resources
              try {
              	if (resultSet != null) resultSet.close();
              	if (statement != null) statement.close();
                  if (connection != null) connection.close();
                  
              } catch (Exception e) {
                  e.printStackTrace();
              }
          }return false;
          
    }
//    public static List<User> getAllUsers(){
//    	String url = "jdbc:mysql://localhost:3306/TRX_JFSD_03"; // Change "mydatabase" to your database name
//        String user = "root"; // Replace with your database username
//        String password = "Mohan@1458"; // Replace with your database password
//        List<User> sl=new ArrayList();
//        // JDBC variables for opening and managing connection
//        
//        Connection connection = null;
//        Statement statement = null;
//        ResultSet resultSet = null ;
//        try {
//            // 1. Open a connection
//        	Class.forName("com.mysql.cj.jdbc.Driver");
//            connection = DriverManager.getConnection(url, user, password);
//            System.out.println("Connection established!");
//
//            // 2. Create a statement
//            statement = connection.createStatement();
//
//            // 3. Execute a query
//            String query = "SELECT * FROM user ";
//            
//            resultSet = statement.executeQuery(query);
//
//            // 4. Process the ResultSet object
//            while (resultSet.next()) {
//                // Assume mytable has columns id (int) and name (String)
//                int id = resultSet.getInt("PatientId");
//                String username= resultSet.getString("Patient Name");
//                String pCondition=resultSet.getString("Patient Condition");
//                String time= resultSet.getString("Appiontment Time");
//                String assignedDoctor=resultSet.getString("Assigned Doctor");
//                User s=new User(id,username,pCondition,time,assignedDoctor);
//                sl.add(s);
//            }
//            return sl;
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            // 5. Close the resources
//            try {
//            	if (resultSet != null) resultSet.close();
//            	if (statement != null) statement.close();
//                if (connection != null) connection.close();
//                
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }return null;
//
//    }
    public static void register(int id,String username,String email,String pass) {

    	String url = "jdbc:mysql://localhost:3306/TRX_JFSD_03"; // Change "mydatabase" to your database name
        String user = "root"; // Replace with your database username
        String password = "Mohan@1458";
    	Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null ;
    	 int rows = 0 ;
         try {
             // 1. Open a connection
        	 Class.forName("com.mysql.cj.jdbc.Driver");
             connection = DriverManager.getConnection(url, user, password);
             System.out.println("Connection established!");

             // 2. Create a statement
             statement = connection.createStatement();

             // 3. Execute a query
             String sql = "insert into user (Id,User_Name,Gmail,User_Password) values("+id+", '"+username+"',"+" '"+email+"', '"+pass+"')";
             
             
             rows = statement.executeUpdate(sql);

             // 4. Process the ResultSet object
             if(rows!=0) {
             	System.out.println("Update successfull!");
             }else {
             	System.out.println("Update failed!");
             }
             
         } catch (Exception e) {
             e.printStackTrace();
         } finally {
             // 5. Close the resources
             try {
             	
             	if (statement != null) statement.close();
                 if (connection != null) connection.close();
                 
             } catch (Exception e) {
                 e.printStackTrace();
             }
         }
             

    	
    }
    public static void deleteUserByUsingId(int id) {
    	String url = "jdbc:mysql://localhost:3306/TRX_JFSD_03"; // Change "mydatabase" to your database name
        String user = "root"; // Replace with your database username
        String password = "Mohan@1458";
    	Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null ;
    	 int rows = 0 ;
         try {
             // 1. Open a connection
        	 Class.forName("com.mysql.cj.jdbc.Driver");
             connection = DriverManager.getConnection(url, user, password);
             System.out.println("Connection established!");

             // 2. Create a statement
             statement = connection.createStatement();

             // 3. Execute a query
             String sql = "delete from user where Id="+id;
             
             
             rows = statement.executeUpdate(sql);

             // 4. Process the ResultSet object
             if(rows!=0) {
             	System.out.println("Update successfull!");
             }else {
             	System.out.println("Update failed!");
             }
             
         } catch (Exception e) {
             e.printStackTrace();
         } finally {
             // 5. Close the resources
             try {
             	
             	if (statement != null) statement.close();
                 if (connection != null) connection.close();
                 
             } catch (Exception e) {
                 e.printStackTrace();
             }
         }

    	
    }



}

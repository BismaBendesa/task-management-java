/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseConnection;
import com.mysql.jdbc.Connection;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Bisma
 */
public class DatabaseConnection {
    
    // getRegisterUserTable variable
    public static String username; 
    public static String password; 
    public static String email;
    public static String profilePic;
    
    // getTaskListTable variable
    public static String taskCategory; 
    public static String taskName; 
    public static String deadline; 
    public static String status;
    public static String taskPriority; 
    public static String description; 
   
    public static void getRegisterUserTable() {
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            String usernameDb = "root";
            String passwordDb = "";
            
            Connection databaseConnection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/task_management_java" , usernameDb, passwordDb);
            Statement databaseStatement = databaseConnection.createStatement();
            ResultSet result = databaseStatement.executeQuery("SELECT * FROM register_user");
            while (result.next()){
                
                username = result.getString("username");
                password = result.getString("password");
                email = result.getString("email");
                profilePic = result.getString("profile_pic");
                  
//                System.out.println("Username : " + username);
//                System.out.println("Password : " + password);
//                System.out.println("Email : " + email);
//                System.out.println("Profile Picture : " + profilePic);
//                System.out.println("==========================");
            }
        } catch (SQLException | InstantiationException 
                | IllegalAccessException | ClassNotFoundException e){
            System.out.println("Error your program didn't work! Please check it again ");
        }
    }
    
    public static void getTaskListTable() {
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            String usernameDb = "root";
            String passwordDb = "";
            
            Connection databaseConnection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/task_management_java" , usernameDb, passwordDb);
            Statement databaseStatement = databaseConnection.createStatement();
            ResultSet result = databaseStatement.executeQuery("SELECT * FROM task_list");
            while (result.next()){
                
                taskCategory = result.getString("task_category");
                taskName = result.getString("task_name");
                deadline = result.getString("deadline");
                status = result.getString("status");
                taskPriority = result.getString("task_priority");
                description = result.getString("description");
                  
//                System.out.println("Task Category : " + taskCategory);
//                System.out.println("Task Name : " + taskName);
//                System.out.println("Deadline : " + deadline);
//                System.out.println("Status : " + status);
//                System.out.println("Task Priority : " + taskPriority);
//                System.out.println("Description : " + description);
//                
//                System.out.println("==========================");
            }
        } catch (SQLException | InstantiationException 
                | IllegalAccessException | ClassNotFoundException e){
            System.out.println("Error your program didn't work! Please check it again ");
        }
    }
    
    
    
}

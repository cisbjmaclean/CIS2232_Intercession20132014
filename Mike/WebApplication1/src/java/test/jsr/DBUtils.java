
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test.jsr;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author sjampani
 */
public class DBUtils {
  
    
 public void addStudent(Student studentobj)
 {
  System.out.println("MySQL Connect Example using PreparedStatement.");
  Connection conn = null;
  PreparedStatement st = null;
  ResultSet rs = null;
  String name=null;
  String url = "jdbc:mysql://localhost:3306/";
  String dbName = "world";
  String driver = "com.mysql.jdbc.Driver";
  String userName = "root"; 
  String password = "";
  System.out.println("Inserting name:"+studentobj.getStudentname());
  
  try {
  Class.forName(driver).newInstance();
  conn = DriverManager.getConnection(url+dbName,userName,password);
  String sql = "INSERT INTO STUDENT (STUDENT_NAME,STUDENT_DEPT) VALUES (?,?)";
  st=       (PreparedStatement) conn.prepareStatement(sql) ;
  st.setString(1, studentobj.getStudentname());
  st.setString(2, studentobj.getStudentdept());
  st.execute();

  
  
  System.out.println("Record inserted...");
  conn.close();
  System.out.println("Disconnected from database");
  } catch (Exception e) {
  e.printStackTrace();
  }
    }

}

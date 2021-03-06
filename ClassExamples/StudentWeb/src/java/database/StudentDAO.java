package database;

import business.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.ConnectionUtils;

/**
 * This class will hold functionality related to student database access.
 *
 * @author bjmaclean
 */
public class StudentDAO {

    /**
     * This method will accept a student id and then load the attributes of an instance of Student
     * by obtaining it from the database.
     * 
     * 
     * @param studentId
     * @return Student instance loaded from the database
     * @throws Exception 
     */
    
    public static Student getStudentFromDatabase(String studentId) throws Exception {
        Student newStudent = new Student();

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs  = null;
        String sql = null;
        try {
            conn = ConnectionUtils.getConnection();
        } catch (Exception ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        }
        boolean foundStudent = false;
        try {
            
            //***************************************************************************************
            // This is the sql to obtain the student information from the database.  Note the student_id 
            // attribute is set in the prepared statement (would replace the ?).
            //***************************************************************************************
            sql = "SELECT student_id, first_name, last_name, dob FROM student where student_id = ?";

            ps = conn.prepareStatement(sql);
            System.out.println("sql="+sql+" and student id="+studentId);
            ps.setString(1, studentId);
            rs = ps.executeQuery();
            while (rs.next()) {
                // It is possible to get the columns via name
                // also possible to get the columns via the column number
                // which starts at 1
                // e.g. resultSet.getSTring(2);
                newStudent.setStudentId(studentId);
                newStudent.setFirstName(rs.getString("first_name"));
                newStudent.setLastName(rs.getString("last_name"));
                newStudent.setDob(rs.getString("dob"));
                foundStudent = true;            }
        } catch (Exception e) {
            foundStudent = false;
            String errorMessage = e.getMessage();
            e.printStackTrace();
        //In the finally close the resources used to make this connection to the database.
        } finally {
            ps.close();
            rs.close();
            conn.close();
        }
        if (foundStudent) {
            return newStudent;
        } else {
            throw new Exception("Could not load student");
        }
    }
}

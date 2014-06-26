/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.CREATE;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import util.ConnectionUtils;
import util.DbUtils;
import util.Util;

@XmlRootElement(name = "Student")
@XmlType(propOrder = { "studentId", "firstName", "lastName", "dob" })
public class Student {
 
    private String studentId;
    private String lastName, firstName, dob;
    
    @XmlTransient private static Scanner input = new Scanner(System.in);
    private static Path path = Paths.get("c:\\cis2232\\student.txt");
    private static HashMap<String, business.Student> students = new HashMap();
    
    
    
    public static HashMap<String, Student> getStudents() {
        return students;
    }

    public Student() {
        System.out.println("Calling default constructor");
    }

    public Student(int studentId){
        PreparedStatement psAuthenticate = null;
        String sql = null;
        Connection conn=null;
        try {
            conn = ConnectionUtils.getConnection();
        } catch (Exception ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        }
        ArrayList<Student> courtBookings = new ArrayList();

        try {
            sql = "SELECT `student_id`, `first_name`, `last_name`, `dob` FROM `student` where student_id = ?";

            psAuthenticate = conn.prepareStatement(sql);
            psAuthenticate.setInt(1, studentId);
            ResultSet rs = psAuthenticate.executeQuery();
            //Student newStudent = new Student();

            if (rs.next()) {
                // It is possible to get the columns via name
                // also possible to get the columns via the column number
                // which starts at 1

                // e.g. resultSet.getSTring(2);

               this.setStudentId(rs.getString("student_id"));
               this.setFirstName(rs.getString("first_name"));
               this.setLastName(rs.getString("last_name"));
               this.setDob(rs.getString("dob"));                
                
            }
        } catch (Exception e) {
            String errorMessage = e.getMessage();
            e.printStackTrace();
        }

    }
            
            
            
            
            
            
            
            
            
            
            
            
    
    public Student(String studentId, String lastName, String firstName, String dob) {
        this.studentId = studentId;
        this.lastName = lastName;
        this.firstName = firstName;
        this.dob = dob;
    }
    
    

    public Student(boolean promptUser) {
        if (promptUser) {
            System.out.println("Please enter the student ID");
            studentId = input.nextLine();
            System.out.println("Please enter the student last name");
            lastName = input.nextLine();
            System.out.println("Please enter the student first name");
            firstName = input.nextLine();
            System.out.println("Please enter the student date of birth name");
            dob = input.nextLine();
        }
    }

    public Student(String loadString) {
        String[] theParts = loadString.split(",");
        //load the attributes of the class based on the line read and passed
        //to this method.
        studentId = theParts[0];
        firstName = theParts[1];
        lastName = theParts[2];
        dob = theParts[3];
        if (Util.debugOn) {
            System.out.println("creating student from String:***" + toString() + "***");
        }
    }

    public String toString() {
        return "Student ID:   \t" + studentId
                + "\nFrist Name:   \t" + firstName
                + "\nLast Name:    \t" + lastName
                + "\nDate of Birth:\t" + dob;
    }

    public String toStringXML(){
        String xmlStudent = "";
        try {
            //http://www.vogella.com/tutorials/JAXB/article.html
            // create JAXB context and instantiate marshaller
            JAXBContext context = JAXBContext.newInstance(Student.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            
            // Write to System.out
            StringWriter sw = new StringWriter();
            m.marshal(this, sw);
            xmlStudent = sw.toString();
            System.out.println("xmlEncodedStudent=" + xmlStudent);
        } catch (JAXBException ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        }
        return xmlStudent;
    }
    
    /**
     * This method will load the details from the database for this student based on 
     * the studentId of this student.
     * 
     * @return void
     */
    
    public void loadDetails(){
        
    }
    public String fileOutputString() {
        return studentId + "," + firstName + "," + lastName + "," + dob;
    }
    
    @XmlTransient
    public Scanner getInput() {
        return input;
    }

    public void setInput(Scanner input) {
        this.input = input;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        System.out.println("Calling the setStudentId (" + studentId + ")");
        this.studentId = studentId;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    
    public static void loadFromDatabase() {
        PreparedStatement psAuthenticate = null;
        String sql = null;
        Connection conn=null;
        try {
            conn = ConnectionUtils.getConnection();
        } catch (Exception ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        }
        ArrayList<Student> courtBookings = new ArrayList();

        try {
            sql = "SELECT `student_id`, `first_name`, `last_name`, `dob` FROM `student` ORDER BY 'student_id'";

            psAuthenticate = conn.prepareStatement(sql);
//            psAuthenticate.setString(1, bookingDate);
            ResultSet rs = psAuthenticate.executeQuery();
            while (rs.next()) {
                // It is possible to get the columns via name
                // also possible to get the columns via the column number
                // which starts at 1

                // e.g. resultSet.getSTring(2);
                Student newStudent = new Student();

                newStudent.setStudentId(rs.getString("student_id"));
                newStudent.setFirstName(rs.getString("first_name"));
                newStudent.setLastName(rs.getString("last_name"));
                newStudent.setDob(rs.getString("dob"));
                
                
                students.put(newStudent.getStudentId(), newStudent);
            }
        } catch (Exception e) {
            String errorMessage = e.getMessage();
            e.printStackTrace();
        }

    }

        public static void loadFile(HttpServletRequest request) {
        //debug statement.
        if (Util.debugOn) {
            System.out.println("About to load the file.");
        }
        InputStream input;
        System.out.println("About to load the file.");
        BufferedReader reader = null;
        try {
            input = new BufferedInputStream(Files.newInputStream(path));
            reader = new BufferedReader(new InputStreamReader(input));

            String nextLine = reader.readLine();
            while (nextLine != null) {
                //Read the information and load the hashmap.
                Student newStudent = new Student(nextLine);

                //next will be to add the new student to the hashmap.
                students.put(newStudent.getStudentId(), newStudent);
                
               
                nextLine = reader.readLine();
            }
             request.getSession().setAttribute("AllStudents", students.values());
             System.out.println("Finished loading students ("+students.values().size()+" loaded)");
        } catch (IOException ioe) {
            System.out.println("There was an error reading the file.");
        }

    }


        
    public static void convertFile(HttpServletRequest request) {
        //debug statement.
        if (Util.debugOn) {
            System.out.println("About to convert the file.");
        }
        InputStream input;
        System.out.println("About to load the file.");
        BufferedReader reader = null;
        try {
            input = new BufferedInputStream(Files.newInputStream(path));
            reader = new BufferedReader(new InputStreamReader(input));

            String nextLine = reader.readLine();
            while (nextLine != null) {
                //Read the information and load the hashmap.
                Student newStudent = new Student(nextLine);
                 newStudent.saveStudent();
                //next will be to add the new student to the hashmap.
//                students.put(newStudent.getStudentId(), newStudent);
                
               
                nextLine = reader.readLine();
            }
  //           request.getSession().setAttribute("AllStudents", students.values());
  //           System.out.println("Finished loading students ("+students.values().size()+" loaded)");
        } catch (IOException ioe) {
            System.out.println("There was an error reading the file.");
        }

    }

        
    public static void fileWrite(BufferedWriter writer, String toWrite) throws IOException {
        boolean writerOpened = false;
        if (writer == null) {
            try {
                writerOpened = true;
                OutputStream output;
                output = new BufferedOutputStream(Files.newOutputStream(path, CREATE, APPEND));
                writer = new BufferedWriter(new OutputStreamWriter(output));
            } catch (Exception ioe) {
                System.out.println("There was an error creating the writer");
            }
        }

        writer.write(toWrite);
        writer.newLine();
        writer.flush();

        if (writerOpened){
            writer.close();
        }
    }

    
    /**
     * This method will save a student to the database.
     */
    public boolean saveStudent()  {

        System.out.println("Saving a student "+this.toString());
        PreparedStatement psAuthenticate = null;
        String sql = null;
        Connection conn = null;
        try {
            conn = ConnectionUtils.getConnection();
        } catch (Exception ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        }

        /*
         * Setup the sql to insert the row.
         */
        
        try {
            sql = "INSERT INTO `student`(`student_id`, `first_name`, `last_name`, `dob`) VALUES (?,?,?,?)";

            psAuthenticate = conn.prepareStatement(sql);
            psAuthenticate.setInt(1, Integer.parseInt(studentId));
            psAuthenticate.setString(2, firstName);
            psAuthenticate.setString(3, lastName);
            psAuthenticate.setString(4, dob);
            psAuthenticate.executeUpdate();
            //conn.commit();

        } catch (Exception e) {
            String errorMessage = e.getMessage();
            e.printStackTrace();
            return false;
        } finally {
            DbUtils.close(psAuthenticate, conn);        
        }

        return true;

        
        }

    
}

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
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.CREATE;
import java.util.HashMap;
import java.util.Scanner;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionForm;
import util.Util;

/**
 *
 * @author bjmaclean
 */
public class Student extends ActionForm {
//<<<<<<< HEAD

    //Student addition - Ian "The Uber" Mori
//=======
//>>>>>>> c6d0827f8fd1f27e2b6537ab3b04da1956dde685
    Scanner input = new Scanner(System.in);
    private String studentId;
    private String lastName, firstName, dob;

    private static Path path = Paths.get("c:\\cis2232\\student.txt");
    private static HashMap<String, business.Student> students = new HashMap();

    public static HashMap<String, Student> getStudents() {
        return students;
    }

    
    
    public Student() {
        System.out.println("Calling default constructor");
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

    public String fileOutputString() {
        return studentId + "," + firstName + "," + lastName + "," + dob;
    }

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
                
                request.getSession().setAttribute("AllStudents", students.values());
                nextLine = reader.readLine();
            }
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

}

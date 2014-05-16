/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package student;

import java.util.Scanner;
import util.Util;

/**
 *
 * @author bjmaclean
 */
public class Student {
//<<<<<<< HEAD
    
    //Student addition - Ian "The Uber" Mori
//=======
//>>>>>>> c6d0827f8fd1f27e2b6537ab3b04da1956dde685
    Scanner input = new Scanner(System.in);
    private String studentId;
    private String lastName, firstName, dob;
    
    
    public Student(){
        System.out.println("Please enter the student ID");
        studentId= input.nextLine();
        System.out.println("Please enter the student last name");
        lastName = input.nextLine();
        System.out.println("Please enter the student first name");
        firstName = input.nextLine();
        System.out.println("Please enter the student date of birth name");
        dob = input.nextLine();
    }
    
    public Student(String loadString){
        String[] theParts = loadString.split(",");
        //load the attributes of the class based on the line read and passed
        //to this method.
        studentId = theParts[0];
        firstName = theParts[1];
        lastName = theParts[2];
        dob = theParts[3];
        if (Util.debugOn) System.out.println("creating student from String:***"+toString()+"***");
    }
    
    public String toString(){
        return     "Student ID:   \t"+studentId
                +"\nFrist Name:   \t"+firstName
                +"\nLast Name:    \t"+lastName
                +"\nDate of Birth:\t"+dob;
    }
    
    
    
    public String fileOutputString(){
        return studentId+","+firstName+","+lastName+","+dob;
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
    
}

package business;

import java.io.StringWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Student {

    private String studentId;
    private String lastName, firstName, dob;
    private boolean loaded = true;

    public void loadFromXML(String xml) {

    try {
        int location = xml.indexOf("<studentId>");
        int endLocation = xml.indexOf("</studentId>");
        studentId = xml.substring(location + 11, endLocation);
        System.out.println("studentId=" + studentId);

        location = xml.indexOf("<lastName>");
        endLocation = xml.indexOf("</lastName>");
        lastName = xml.substring(location + 10, endLocation);
        System.out.println("lastName=" + lastName);

        location = xml.indexOf("<firstName>");
        endLocation = xml.indexOf("</firstName>");
        firstName = xml.substring(location + 11, endLocation);
        System.out.println("firstName=" + firstName);

        location = xml.indexOf("<dob>");
        endLocation = xml.indexOf("</dob>");
        dob = xml.substring(location + 5, endLocation);
        System.out.println("dob=" + dob);
    } catch (Exception e){
        System.out.println("error loading student");
        loaded = false;

    }
    }

    public String toString() {
        if (loaded) {
            return "Student ID:   \t" + studentId
                    + "\nFrist Name:   \t" + firstName
                    + "\nLast Name:    \t" + lastName
                    + "\nDate of Birth:\t" + dob;
        } else {
            return "Student not found";
        }
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


}

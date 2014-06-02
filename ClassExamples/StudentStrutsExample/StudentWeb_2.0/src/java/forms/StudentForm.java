/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import org.apache.struts.validator.ValidatorForm;

/**
 *
 * @author bjmaclean
 */
public class StudentForm extends ValidatorForm {
    private String studentId;
    private String lastName, firstName, dob;

    public StudentForm() {
        System.out.println("Calling default constructor");
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

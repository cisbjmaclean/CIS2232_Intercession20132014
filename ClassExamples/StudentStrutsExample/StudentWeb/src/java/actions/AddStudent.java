/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import business.Student;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author bjmaclean
 */
public class AddStudent extends Action {

    public ActionForward execute(
            ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response)
            throws Exception {

        
        
        ActionForward findForward = mapping.findForward("welcome");

        Student newStudent = (Student) request.getAttribute("studentForm");
        
        System.out.println("newStudent.firstName="+newStudent.getFirstName());
        System.out.println("newStudent.lastName="+newStudent.getLastName());
        System.out.println("newStudent.studentId="+newStudent.getStudentId());
        System.out.println("newStudent.dob="+newStudent.getDob());
        
        Student.fileWrite(null, newStudent.fileOutputString());
        Student.getStudents().put(newStudent.getStudentId(), newStudent);
        return findForward;

    }

}

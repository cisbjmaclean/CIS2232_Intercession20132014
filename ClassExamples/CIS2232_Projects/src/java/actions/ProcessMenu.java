/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import business.Student;
import database.StudentDAO;
import forms.MenuForm;
import java.util.ArrayList;
import java.util.Collection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

/**
 *
 * @author bjmaclean
 */
public class ProcessMenu extends Action {

    public ActionForward execute(
            ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response)
            throws Exception {

        //Get the option chosen from the user.
        MenuForm menuForm = (MenuForm) request.getAttribute("menuForm");
        System.out.println("Option chosen=" + menuForm.getOption());
        ActionForward findForward = mapping.findForward("welcome");
        ActionMessages messages = new ActionMessages();

        System.out.println("Session_id=" + request.getSession().getId());
        if (menuForm.getOption().equalsIgnoreCase("add")) {
            findForward = mapping.findForward("add");

            //will invoke code to add a student.
        } else if (menuForm.getOption().equalsIgnoreCase("viewall")) {

//            //Have to load the collection into the request.
//            ArrayList<Student> theStudents = new ArrayList<Student>(Student.getStudents().values());
//            request.setAttribute("Students", theStudents);
            findForward = mapping.findForward("viewAll");
        } else {
            String parameterOption = request.getParameter("option");
            //*************************************************************************************
            // User chose to edit a student from a hyperlink

            if (parameterOption != null && parameterOption.equalsIgnoreCase("edit")) {
                //Have chosen to edit.  The studentId should be passed as a parameter as well.  
                String studentId = request.getParameter("studentId");
                try {
                    //***********************************************************************************************
                    //In this processing, will load the student information based on the student id.  If loaded will 
                    //forward to the chooseEdit forward with a message indicating that the student was loaded correctly.
                    //***********************************************************************************************
                    
                    Student loadStudent = StudentDAO.getStudentFromDatabase(studentId);
                    messages.add("message1", (new ActionMessage("label.student.loaded.successfully")));
                    request.setAttribute("studentForm", loadStudent);
                    findForward = mapping.findForward("chooseEdit");
                } catch (Exception e) {
                    //***********************************************************************************************
                    // If there is an exception.  Will forward the user to the add tile with an error that
                    // the student could not be loaded.  This may change if enhanced in the future.  Something
                    // strange would have had to happen for this case to occur.
                    //***********************************************************************************************

                    messages = new ActionMessages();
                    messages.add("error", (new ActionMessage("label.error.loading.student")));
                    findForward = mapping.findForward("add");
                }
                saveMessages(request, messages);

            }

            
        }

        return findForward;

    }

}

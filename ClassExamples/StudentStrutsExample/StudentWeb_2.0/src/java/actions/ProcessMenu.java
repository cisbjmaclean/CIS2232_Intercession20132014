/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import business.Student;
import forms.MenuForm;
import java.util.ArrayList;
import java.util.Collection;
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
public class ProcessMenu extends Action {

    public ActionForward execute(
            ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response)
            throws Exception {

        
        
        //Get the option chosen from the user.
        MenuForm menuForm = (MenuForm) request.getAttribute("menuForm");
        System.out.println("Option chosen="+menuForm.getOption());
        ActionForward findForward = mapping.findForward("welcome");
        
        System.out.println("Session_id="+request.getSession().getId());
        if(menuForm.getOption().equalsIgnoreCase("add")){
            findForward =  mapping.findForward("add");
            
            //will invoke code to add a student.
        } else if (menuForm.getOption().equalsIgnoreCase("viewall")){
            
//            //Have to load the collection into the request.
//            ArrayList<Student> theStudents = new ArrayList<Student>(Student.getStudents().values());
//            request.setAttribute("Students", theStudents);
            
            findForward =  mapping.findForward("viewAll");
        } 
        return findForward;

    }

}

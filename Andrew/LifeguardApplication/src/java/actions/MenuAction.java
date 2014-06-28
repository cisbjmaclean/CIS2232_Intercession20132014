/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package actions;

import forms.MenuForm;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author Andrew
 */
public class MenuAction extends org.apache.struts.action.Action {

    /* forward name="success" path="" */
    private static final String SUCCESS = "success";

    /**
     * This is the action called from the Struts framework.
     *
     * @param mapping The ActionMapping used to select this instance.
     * @param form The optional ActionForm bean for this request.
     * @param request The HTTP Request we are processing.
     * @param response The HTTP Response we are processing.
     * @throws java.lang.Exception
     * @return
     */
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        
        MenuForm menuForm = (MenuForm)request.getAttribute("menuForm");
        ActionForward actionForward = new ActionForward();
        
        if(menuForm.getAction().equalsIgnoreCase("View Lifeguards")){
            System.out.println("going to the lifeguards page");
            actionForward = mapping.findForward("lifeguards");
        } else if(menuForm.getAction().equalsIgnoreCase("View Schedule")){
            System.out.println("going to the schedule page");
            actionForward = mapping.findForward("schedule");
        } else if(menuForm.getAction().equalsIgnoreCase("Add Lifeguard")){
            System.out.println("Going to the Add Lifeguard Page.");
            actionForward = mapping.findForward("addLifeguard");
        }else if(menuForm.getAction().equalsIgnoreCase("Logout")){
            actionForward = mapping.findForward("login");
        } else if(menuForm.getAction().equalsIgnoreCase("Modify Schedule")){
            actionForward = mapping.findForward("modifySchedule");
        }
        
        return actionForward;
    }
}

package actions;

import business.AddUser;
import forms.AddUserForm;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author Michael Fesser
 * @since 6/3/2014
 * 
 * The purpose of this class is to allow the function of the login page.
 */
public class AddUserAction extends Action {
    
    // Flag for user creation.
    private boolean userCreation = false;
    private AddUserForm userForm;

    /**
     * 
     * 
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception 
     */
     public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        // Used to define the page to be forwarded to.
         
        ActionForward findForward = mapping.findForward("login");
        
         userForm = (AddUserForm) form;
         AddUser addUser = new AddUser();         
         addUser.addToDatabase(userForm);
           
        return findForward;
    }
}

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
    private boolean usernameTaken = false;
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
         
        ActionForward findForward;
        
         userForm = (AddUserForm) form;
         AddUser addUser = new AddUser();
         usernameTaken = addUser.checkUsername(userForm);
         System.out.println(usernameTaken);
         if (!usernameTaken){
         userCreation = addUser.addToDatabase(userForm);
         }        
         if (userCreation){
              findForward = mapping.findForward("login");
        } else {
            findForward = mapping.findForward("addUser");
         }     
        return findForward;
    }
}

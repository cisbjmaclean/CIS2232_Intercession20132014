package actions;

import business.Login;
import forms.LoginForm;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author Michael Fesser
 * @since 5/25/2014
 * 
 * The purpose of this class is to allow the function of the login page.
 */
public class LoginAction extends Action {
    
    // Flag for login access.
    private boolean authenticate = false;
    private LoginForm validateLogin; 
    private Login login;
    private ActionForward findForward;

    /**
     * This method gets the fields from the login page and calls the user class
     * and its functions that validate them vs the password file.
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

        // Create the object that holds the fields from the login page.
        validateLogin = (LoginForm) form;
        // Used to define the page to be forwarded to.  
        login  = new Login();
        this.authenticate = login.checkLogin(validateLogin);
        // If login credentials are valid continue otherwise return to the login page.
        if (authenticate) {
            findForward = mapping.findForward("main");
        } else {
            findForward = mapping.findForward("login");
        }         
        return findForward;
    }
}


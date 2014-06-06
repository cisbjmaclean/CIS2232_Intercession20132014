package actions;

import business.Login;
import com.opensymphony.xwork2.ActionSupport;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.LoginModel;


/**
 *
 * @author Michael Fesser
 * @since 5/25/2014
 * 
 * The purpose of this class is to allow the function of the login page.
 */
public class LoginAction extends ActionSupport {
    
    // Flag for login access.
    private boolean authenticate = false;
    private LoginModel validateLogin; 
    private Login login;

    /**
     * This method gets the fields from the login page and calls the user class
     * and its functions that validate them vs the password file.
     * 
     * @param request
     * @param response
     * @return
     * @throws Exception 
     */
     public String execute(HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        // Create the object that holds the fields from the login page.
        validateLogin = (LoginModel) request.getAttribute("LoginModel");
        // Used to define the page to be forwarded to.
        login  = new Login();
        authenticate = login.checkLogin(validateLogin);
        // If login credentials are valid continue otherwise return to the login page.
//        if (authenticate) {
//            findForward = mapping.findForward("main");
//        } else {
//            findForward = mapping.findForward("login");
//        }         
        return SUCCESS;
    }
}


package actions;

import business.LoadUser;
import business.Login;
import forms.LoginForm;
import forms.UserForm;
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
 * @author Michael Fesser
 * @since 5/25/2014
 *
 * The purpose of this class is to allow the function of the login page.
 */
public class LoginAction extends Action {

    // Flag for login access.
    private boolean authenticate = false;
    private LoginForm validateLogin;
    private UserForm user;
    private Login login;
    private LoadUser loadUser;
    private ActionForward forwardTo;

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
        validateLogin = (LoginForm) request.getAttribute("loginForm");
        // Used to define the page to be forwarded to.  
        login = new Login();
        authenticate = login.checkLogin(validateLogin);
        ActionMessages messages = new ActionMessages();
        // If login credentials are valid continue otherwise return to the login page.
        if (authenticate) {
            loadUser = new LoadUser();
            request.getSession().setAttribute("user", validateLogin);
            loadUser.setUserInformation(validateLogin.getCustomerId());
            request.getSession().setAttribute("userDetails", user);
            messages.add("success", (new ActionMessage("label.login.success")));
            forwardTo = mapping.findForward("customerUnitView");
        } else {
            messages.add("error", (new ActionMessage("label.login.fail")));
            forwardTo = mapping.findForward("login");
        }
        saveMessages(request, messages);
        return forwardTo;
    }
}

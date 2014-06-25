package actions;

import business.LoadCustomer;
import business.Login;
import forms.LoginForm;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    private InitializeAction initialize;
    private String authenticate = "none";
    private LoginForm validateLogin;
    private Login login;
    private LoadCustomer loadCustomer;
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

        ActionMessages messages = new ActionMessages();

        // Create the object that holds the fields from the login page.
        validateLogin = (LoginForm) request.getAttribute("loginForm");
        // Used to define the page to be forwarded to.  
        login = new Login();

        try {
            if (validateLogin.getUsername().startsWith("admin.")) {
                authenticate = login.checkAdminLogin(validateLogin);
            } else {
                authenticate = login.checkLogin(validateLogin);
            }

            // If login credentials are valid continue otherwise return to the login page.
            switch (authenticate) {
                case "admin":
                    request.getSession().setAttribute("admin", validateLogin);
                    messages.add("success", (new ActionMessage("login.success")));
                    forwardTo = mapping.findForward("adminInitialize");
                    break;
                case "customer":
                    loadCustomer = new LoadCustomer();
                    request.getSession().setAttribute("customer", validateLogin);
                    request.getSession().setAttribute("customerDetails", loadCustomer.setCustomerInformation(validateLogin.getCustomerId()));
                    messages.add("success", (new ActionMessage("login.success")));
                    forwardTo = mapping.findForward("customerStorageUnitView");
                    break;
                default:
                    messages.add("error", (new ActionMessage("login.fail")));
                    forwardTo = mapping.findForward("login");
                    break;
            }
        } catch (Exception e) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, e);
            messages.add("error", (new ActionMessage("error.database")));
            forwardTo = mapping.findForward("login");
        }
        saveMessages(request, messages);
        // Used to deal with some odd behaviour with session timeouts, the back button and logging in again.    
        initialize = new InitializeAction();
        return forwardTo;
    }
}

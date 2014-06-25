package actions;

import business.AddCustomer;
import forms.AddUpdateCustomerForm;
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
 * @since 6/3/2014
 *
 * The purpose of this class is to allow the function of the login page.
 */
public class AddCustomerAction extends Action {

    // Flag for user creation.
    private boolean customerCreation = false;
    private boolean usernameTaken = false;
    private AddCustomer addCustomer;
    private ActionForward forwardTo;
    private LoginForm authenticated;
    private AddUpdateCustomerForm customerForm;

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
        ActionMessages messages = new ActionMessages();
        authenticated = (LoginForm) request.getSession().getAttribute("admin");
        customerForm = (AddUpdateCustomerForm) request.getAttribute("addUpdateCustomerForm");
        addCustomer = new AddCustomer();
        usernameTaken = addCustomer.checkUsername(customerForm);

        if (!usernameTaken) {
            try {
                customerCreation = addCustomer.addCustomer(customerForm);
            } catch (Exception e) {
                Logger.getLogger(AddCustomer.class.getName()).log(Level.SEVERE, null, e);
                messages.add("error", (new ActionMessage("error.database")));               
            }
        } else {
          messages.add("error", (new ActionMessage("database.username.taken")));            
        }

        if (customerCreation) {
            if (authenticated != null && authenticated.isValidated() == true && authenticated.getAdminCode() == 378) {
                forwardTo = mapping.findForward("adminMain");
            } else {
                forwardTo = mapping.findForward("login");
            }
            messages.add("success", (new ActionMessage("database.add.customer")));  
          //label.database.add.user = customer added
        } else if (authenticated != null && authenticated.isValidated() == true && authenticated.getAdminCode() == 378) {
            forwardTo = mapping.findForward("adminAddCustomer");
        } else {
            forwardTo = mapping.findForward("addCustomer");
        }
        
        saveMessages(request, messages);
        return forwardTo;
    }
}

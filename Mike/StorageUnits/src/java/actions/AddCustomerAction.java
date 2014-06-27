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
 * This class will allow customers to be added to the database
 */
public class AddCustomerAction extends Action {

    private boolean customerCreation = false;
    private boolean usernameTaken = false;
    private AddCustomer addCustomer;
    private ActionForward forwardTo;
    private LoginForm authenticated;
    private AddUpdateCustomerForm customerForm;

    /**
     * This action will pass the AddCustomer form to the addCustomer class
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
        // Validate the username

        try {
            usernameTaken = addCustomer.checkUsername(customerForm);
        } catch (Exception e) {
            // Used if there is a critical database error
            Logger.getLogger(AddCustomer.class.getName()).log(Level.SEVERE, null, e);
            messages.add("error", (new ActionMessage("error.database")));
        }

        // If username not taken add customer
        if (!usernameTaken) {
            try {
                customerCreation = addCustomer.addCustomer(customerForm);
            } catch (Exception e) {
                // Used if there is a critical database error
                Logger.getLogger(AddCustomer.class.getName()).log(Level.SEVERE, null, e);
                messages.add("error", (new ActionMessage("error.database")));
            }
        } else {
            messages.add("error", (new ActionMessage("database.username.taken")));
        }

        // If successful forward to correct jsp
        if (customerCreation) {
            // Used to validate the session user for the forward or return to the tile this action was called from
            if (authenticated != null && authenticated.isValidated() == true && authenticated.getAdminCode() == 378) {
                forwardTo = mapping.findForward("adminMain");
            } else {
                forwardTo = mapping.findForward("login");
            }
            messages.add("success", (new ActionMessage("database.add.customer")));
        } else if (authenticated != null && authenticated.isValidated() == true && authenticated.getAdminCode() == 378) {
            forwardTo = mapping.findForward("adminAddCustomer");
        } else {
            forwardTo = mapping.findForward("addCustomer");
        }

        saveMessages(request, messages);
        return forwardTo;
    }
}

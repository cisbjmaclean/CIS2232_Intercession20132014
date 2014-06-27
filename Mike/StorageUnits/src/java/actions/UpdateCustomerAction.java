package actions;

import business.LoadCustomers;
import business.UpdateCustomer;
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
 * This class is used to update customers.
 *
 * @author Michael
 * @since Jun 17, 2014
 */
public class UpdateCustomerAction extends Action {

    private LoginForm authenticated;
    private LoginForm adminAuthenticated;
    private boolean customerUpdate = false;
    private UpdateCustomer updateCustomer;
    private ActionForward forwardTo;
    private AddUpdateCustomerForm customerForm;

    /**
     * This action will pass the AddUpdateCustomerForm to the UpdateCustomer
     * class.
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
        authenticated = (LoginForm) request.getSession().getAttribute("customer");
        adminAuthenticated = (LoginForm) request.getSession().getAttribute("admin");

        // Validate session
        if (adminAuthenticated == null || adminAuthenticated.getAdminCode() != 378) {
            if (authenticated == null || authenticated.isValidated() == false) {
                messages.add("error", (new ActionMessage("label.session.expired")));
                saveMessages(request, messages);
                return mapping.findForward("login");
            }
        }

        // Pass the AddUpdateCustomerForm to the UpdateCustomer class and return true if successful
        try {
            customerForm = (AddUpdateCustomerForm) request.getAttribute("addUpdateCustomerForm");
            updateCustomer = new UpdateCustomer();
            customerUpdate = updateCustomer.updateCustomer(customerForm);
        } catch (Exception e) {
            // Used if there is a critical database error
            Logger.getLogger(UpdateCustomer.class.getName()).log(Level.SEVERE, null, e);
            messages.add("error", (new ActionMessage("error.database")));
        }

        // customer updated forwad to the correct tile based on who is logged in, or return to the tile this action was called from
        if (customerUpdate) {
            messages.add("success", (new ActionMessage("customer.update.success")));
            if (adminAuthenticated != null && adminAuthenticated.isValidated() == true && adminAuthenticated.getAdminCode() == 378) {
                forwardTo = mapping.findForward("adminMain");
            } else {
                forwardTo = mapping.findForward("customerStorageUnitView");
            }
        } else if (authenticated != null && authenticated.isValidated() == true) {
            forwardTo = mapping.findForward("customerStorageUnitView");
        } else {
            messages.add("error", (new ActionMessage("customer.update.failed")));
            forwardTo = mapping.findForward("customerUpdate");
        }

        saveMessages(request, messages);
        return forwardTo;
    }
}

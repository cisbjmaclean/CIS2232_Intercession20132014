package actions;

import business.UpdateCustomer;
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
 * @author Michael
 * @since Jun 17, 2014
 */
public class UpdateCustomerAction extends Action {

    private LoginForm authenticated;
    private LoginForm adminAuthenticated;
    private boolean customerUpdate = false;
    private UpdateCustomer updateCustomer;
    private ActionForward forwardTo;

    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        ActionMessages messages = new ActionMessages();
        authenticated = (LoginForm) request.getSession().getAttribute("customer");
        adminAuthenticated = (LoginForm) request.getSession().getAttribute("admin");

        if (adminAuthenticated == null || adminAuthenticated.getAdminCode() != 378) {
            if (authenticated == null || authenticated.isValidated() == false) {
                messages.add("error", (new ActionMessage("label.session.expired")));
                saveMessages(request, messages);
                return mapping.findForward("login");
            }
        }
        try {
            updateCustomer = new UpdateCustomer(request);
            customerUpdate = updateCustomer.updateCustomer();
        } catch (Exception e) {
            Logger.getLogger(UpdateCustomer.class.getName()).log(Level.SEVERE, null, e);
            messages.add("error", (new ActionMessage("error.database")));
            //label.error.database = There was an issue with the database, please contact customer support
        }

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
             messages.add("success", (new ActionMessage("customer.update.failed")));
            forwardTo = mapping.findForward("customerUpdate");
        }
        
        saveMessages(request, messages);
        return forwardTo;
    }
}

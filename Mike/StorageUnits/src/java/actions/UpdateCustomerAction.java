package actions;

import business.UpdateCustomer;
import forms.LoginForm;
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
        // finish this up
        updateCustomer = new UpdateCustomer(request);
        customerUpdate = updateCustomer.updateCustomer();

        if (customerUpdate) {
            if (adminAuthenticated != null && adminAuthenticated.isValidated() == true && adminAuthenticated.getAdminCode() == 378) {
                System.out.println("hi");
                forwardTo = mapping.findForward("adminMain");
            } else {
                System.err.println("by");                
                forwardTo = mapping.findForward("customerStorageUnitView");
            }
        } else if (authenticated != null && authenticated.isValidated() == true) {
            forwardTo = mapping.findForward("customerStorageUnitView");
        } else {
            forwardTo = mapping.findForward("customerUpdate");
        }
        return forwardTo;
    }
}

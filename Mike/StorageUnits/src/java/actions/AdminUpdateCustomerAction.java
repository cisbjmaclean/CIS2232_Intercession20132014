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
public class AdminUpdateCustomerAction extends Action {

    private LoginForm authenticated;
    private boolean customerCreation = false;
    private UpdateCustomer updateCustomer;
    private ActionForward findForward;

    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        ActionMessages messages = new ActionMessages();
        authenticated = (LoginForm) request.getSession().getAttribute("admin");
        if (authenticated == null || authenticated.isValidated() == false || authenticated.getAdminCode() != 378) {
            messages.add("error", (new ActionMessage("label.session.invalid")));
            saveMessages(request, messages);
            return mapping.findForward("login");
        }
        
        // finish this up
        
        updateCustomer = new UpdateCustomer(request);
        customerCreation = updateCustomer.updateCustomer();
      
        return findForward;
    }
}

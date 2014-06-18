package actions;

import business.AddCustomer;
import forms.LoginForm;
import forms.MultipleActionForm;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import util.Util;

/**
 *
 * @author Michael
 * @since Jun 18, 2014
 */
public class AdminAddCustomerAction extends Action {

    // Flag for user creation.
    private boolean customerCreation = false;
    private boolean usernameTaken = false;
    private AddCustomer addCustomer;
    private ActionForward findForward;
    private LoginForm authenticated;

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
        if (authenticated == null || authenticated.isValidated() == false || authenticated.getAdminCode() != 378) {
            messages.add("error", (new ActionMessage("label.session.invalid")));
            saveMessages(request, messages);
            return mapping.findForward("login");
        }

        addCustomer = new AddCustomer(request);
        usernameTaken = addCustomer.checkUsername();
        if (!usernameTaken) {
            customerCreation = addCustomer.addCustomer();
        }
        if (customerCreation) {
            findForward = mapping.findForward("adminMain");
        } else {
            findForward = mapping.findForward("adminAddCustomer");
        }
        return findForward;
    }
}

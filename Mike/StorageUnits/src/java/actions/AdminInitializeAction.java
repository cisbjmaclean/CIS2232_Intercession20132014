package actions;

import business.LoadCustomers;
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
 * @since Jun 16, 2014
 */
public class AdminInitializeAction extends Action {

    private LoginForm authenticated;
    private LoadCustomers loadCustomer;
    private LoadCustomers loadLogin;

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
        loadCustomer = new LoadCustomers();
        request.getSession().setAttribute("allCustomers", loadCustomer.loadCustomers(request));
        loadLogin = new LoadCustomers();
        request.getSession().setAttribute("allLogins", loadLogin.loadLogins(request));

        // Used to define the page to be forwarded to.      
        ActionForward findForward = mapping.findForward("adminMain");
        return findForward;
    }
}
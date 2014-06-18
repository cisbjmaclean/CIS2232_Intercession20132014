package actions;

import business.DeleteCustomer;
import business.SetCustomerUpdateInfo;
import forms.AdminModifyCustomerForm;
import forms.LoginForm;
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
 * @since Jun 17, 2014
 */
public class AdminModifyCustomerAction extends Action {

    private ActionForward forwardTo;
    private LoginForm authenticated;
    private AdminModifyCustomerForm menu;
    private AdminModifyCustomerForm customerId;
    private DeleteCustomer deleteCustomer;
    private SetCustomerUpdateInfo customerInfo;

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
        customerId = (AdminModifyCustomerForm) request.getAttribute("adminModifyCustomerForm");  
        Util.resources = ResourceBundle.getBundle("com.myapp.struts.ApplicationResource", Locale.getDefault());
        menu = (AdminModifyCustomerForm) request.getAttribute("adminModifyCustomerForm");

        if (menu.getAction().equals(Util.resources.getString("label.admin.customer.search.update"))) {
            customerInfo = new SetCustomerUpdateInfo();
            customerInfo.setCustomer(customerId, request);          
            forwardTo = mapping.findForward("adminUpdateCustomer");
        }else if (menu.getAction().equals(Util.resources.getString("label.admin.customer.search.delete"))) {
            deleteCustomer = new DeleteCustomer();
            deleteCustomer.deleteCustomer(customerId, request);
            forwardTo = mapping.findForward("adminMain");
        }
        return forwardTo;
    }
}

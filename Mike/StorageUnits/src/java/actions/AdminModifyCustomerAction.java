package actions;

import business.DeleteCustomer;
import business.SetCustomerUpdateInfo;
import forms.AdminModifyCustomerForm;
import forms.CustomerForm;
import forms.LoginForm;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;
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
    private ArrayList<CustomerForm> allCustomers;
    private ArrayList<LoginForm> allLogins;

    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        ActionMessages messages = new ActionMessages();
        authenticated = (LoginForm) request.getSession().getAttribute("admin");
        if (authenticated == null || authenticated.isValidated() == false || authenticated.getAdminCode() != 378) {
            messages.add("error", (new ActionMessage("session.invalid")));
            saveMessages(request, messages);
            return mapping.findForward("login");
        }
        allCustomers = (ArrayList<CustomerForm>) request.getSession().getAttribute("allCustomers");
        allLogins = (ArrayList<LoginForm>) request.getSession().getAttribute("allLogins");
        customerId = (AdminModifyCustomerForm) request.getAttribute("adminModifyCustomerForm");
        Util.resources = ResourceBundle.getBundle("com.myapp.struts.ApplicationResource", Locale.getDefault());
        menu = (AdminModifyCustomerForm) request.getAttribute("adminModifyCustomerForm");

        if (menu.getAction().equals(Util.resources.getString("label.admin.customer.search.update"))) {
            customerInfo = new SetCustomerUpdateInfo();
            customerInfo.setCustomer(customerId, request);
            forwardTo = mapping.findForward("adminUpdateCustomer");
        } else if (menu.getAction().equals(Util.resources.getString("label.admin.customer.search.delete"))) {
            try {
                deleteCustomer = new DeleteCustomer();
                deleteCustomer.deleteCustomer(customerId, allCustomers, allLogins);
                request.getSession().setAttribute("allCustomers", allCustomers);
                request.getSession().setAttribute("allLogins", allLogins);
            } catch (Exception e) {
                Logger.getLogger(DeleteCustomer.class.getName()).log(Level.SEVERE, null, e);
                messages.add("error", (new ActionMessage("error.database")));
            }
            messages.add("success", (new ActionMessage("customer.deleted")));
            forwardTo = mapping.findForward("adminMain");
        }
        return forwardTo;
    }
}

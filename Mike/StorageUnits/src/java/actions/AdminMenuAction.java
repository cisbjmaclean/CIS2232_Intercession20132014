package actions;

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
import util.Logout;
import util.Util;

/**
 *
 * @author Michael
 * @since Jun 10, 2014
 */
public class AdminMenuAction extends Action {

    private ActionForward forwardTo;
    private LoginForm authenticated;
    private MultipleActionForm menu;
    private Logout logout;

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
        Util.resources = ResourceBundle.getBundle("com.myapp.struts.ApplicationResource", Locale.getDefault());
        menu = (MultipleActionForm) request.getAttribute("multipleActionForm");

        if (menu.getAction().equals(Util.resources.getString("label.admin.menu.logout"))) {
            logout = new Logout();
            logout.logout(request, response);
            forwardTo = mapping.findForward("index");
        } else if (menu.getAction().equals(Util.resources.getString("label.admin.menu.search"))) {
            forwardTo = mapping.findForward("adminSearch");
        } else if (menu.getAction().equals(Util.resources.getString("label.admin.menu.view.all.customers"))) {
            request.getSession().setAttribute("customerList", request.getSession().getAttribute("allCustomers"));
            forwardTo = mapping.findForward("adminCustomerSearchResults");
        } else if (menu.getAction().equals(Util.resources.getString("label.admin.menu.add.customer"))) {
            forwardTo = mapping.findForward("adminAddCustomer");
        } else if (menu.getAction().equals(Util.resources.getString("label.admin.menu.view.all.storage.units"))) {
            forwardTo = mapping.findForward("adminViewAllStorageUnits");
        } else if (menu.getAction().equals(Util.resources.getString("label.admin.menu.add.storage.unit"))) {
            forwardTo = mapping.findForward("adminAddStorageUnit");
        } else if (menu.getAction().equals(Util.resources.getString("label.admin.menu.view.calendar"))) {
            forwardTo = mapping.findForward("main");
        }
        return forwardTo;
    }

}

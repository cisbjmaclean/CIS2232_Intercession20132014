package actions;

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
 * @since Jun 12, 2014
 */
public class MainMenuAction extends Action {

    private ActionForward forwardTo;
    private MultipleActionForm mainMenu;

    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        ActionMessages messages = new ActionMessages();
        Util.resources = ResourceBundle.getBundle("com.myapp.struts.ApplicationResource", Locale.getDefault());
        mainMenu = (MultipleActionForm) request.getAttribute("multipleActionForm");

        if (mainMenu.getAction().equals(Util.resources.getString("label.main.menu.login"))) {
            forwardTo = mapping.findForward("login");
        } else if (mainMenu.getAction().equals(Util.resources.getString("label.main.menu.create"))) {
            forwardTo = mapping.findForward("addCustomer");
        } else if (mainMenu.getAction().equals(Util.resources.getString("label.main.menu.view.all.storage.units"))) {
            forwardTo = mapping.findForward("viewAllStorageUnits");
        } else if (mainMenu.getAction().equals(Util.resources.getString("label.customer.menu.view.my.storage.units"))) {
            forwardTo = mapping.findForward("customerStorageUnitView");
        } else if (mainMenu.getAction().equals(Util.resources.getString("label.customer.menu.view.all.storage.units"))) {
            forwardTo = mapping.findForward("customerViewAllStorageUnits");
        } else if (mainMenu.getAction().equals(Util.resources.getString("label.customer.menu.view.search.units"))) {
            forwardTo = mapping.findForward("customerStorageUnitSearch");
        } else if (mainMenu.getAction().equals(Util.resources.getString("label.customer.menu.profile"))) {
            forwardTo = mapping.findForward("customerUpdate");
        } else if (mainMenu.getAction().equals(Util.resources.getString("label.admin.menu.search"))) {
            forwardTo = mapping.findForward("adminSearch");
        } else if (mainMenu.getAction().equals(Util.resources.getString("label.admin.menu.view.all.customers"))) {
            request.getSession().setAttribute("customerList", request.getSession().getAttribute("allCustomers"));
            forwardTo = mapping.findForward("adminCustomerSearchResults");
        } else if (mainMenu.getAction().equals(Util.resources.getString("label.admin.menu.add.customer"))) {
            forwardTo = mapping.findForward("adminAddCustomer");
        } else if (mainMenu.getAction().equals(Util.resources.getString("label.admin.menu.view.all.storage.units"))) {
            forwardTo = mapping.findForward("adminViewAllStorageUnits");
        } else if (mainMenu.getAction().equals(Util.resources.getString("label.admin.menu.add.storage.unit"))) {
            forwardTo = mapping.findForward("adminAddStorageUnit");
        } else if (mainMenu.getAction().equals(Util.resources.getString("label.menu.logout"))) {
            Logout.logout(request, response);
            messages.add("success", (new ActionMessage("logout.success")));
            forwardTo = mapping.findForward("index");
        }
        saveMessages(request, messages);
        return forwardTo;
    }
}

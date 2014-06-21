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
public class CustomerMenuAction extends Action {

    private ActionForward forwardTo;
    private LoginForm authenticated;
    private MultipleActionForm menu;
    private Logout logout;

    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        ActionMessages messages = new ActionMessages();
        authenticated = (LoginForm) request.getSession().getAttribute("customer");
        if (authenticated == null || authenticated.isValidated() == false) {
            messages.add("error", (new ActionMessage("label.session.expired")));
            saveMessages(request, messages);
            return mapping.findForward("login");
        }
        
        Util.resources = ResourceBundle.getBundle("com.myapp.struts.ApplicationResource", Locale.getDefault());
        menu = (MultipleActionForm) request.getAttribute("multipleActionForm");

        if (menu.getAction().equals(Util.resources.getString("label.customer.menu.logout"))) {
            logout = new Logout();
            logout.logout(request, response);
            forwardTo = mapping.findForward("index");
        } else if (menu.getAction().equals(Util.resources.getString("label.customer.menu.view.my.storage.units"))) {
            forwardTo = mapping.findForward("customerStorageUnitView");
        } else if (menu.getAction().equals(Util.resources.getString("label.customer.menu.view.all.storage.units"))) {
            forwardTo = mapping.findForward("customerViewAllStorageUnits");
        } else if (menu.getAction().equals(Util.resources.getString("label.customer.menu.view.search.units"))) {
            forwardTo = mapping.findForward("customerStorageUnitSearch");
        } else if (menu.getAction().equals(Util.resources.getString("label.customer.menu.profile"))) {
            forwardTo = mapping.findForward("customerUpdate");
        }
        return forwardTo;
    }

}

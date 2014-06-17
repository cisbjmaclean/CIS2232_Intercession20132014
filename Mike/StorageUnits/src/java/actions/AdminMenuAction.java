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

//        if (menu.getAction().equals(Util.resources.getString("label.admin.menu.logout"))) {
//            forwardTo = mapping.findForward("login");
//        } else if (menu.getAction().equals(Util.resources.getString("label.admin.main"))) {
//            forwardTo = mapping.findForward("adminMain");
//        } else if (menu.getAction().equals(Util.resources.getString("label.admin.menu.add.user"))) {
//            forwardTo = mapping.findForward("adminAddUser");
//    } else if (menu.getAction().equals(Util.resources.getString("label.admin.menu.add.unit"))) {
//            forwardTo = mapping.findForward("adminAddUnit");
//        } else if (menu.getAction().equals(Util.resources.getString("label.admin.menu.view.all.units"))) {
//            forwardTo = mapping.findForward("a");
//        } else if (menu.getAction().equals(Util.resources.getString("label.admin.menu.view.calendar"))) {
//            forwardTo = mapping.findForward("customerCalendar");
//        } 
        return forwardTo;
    }

}

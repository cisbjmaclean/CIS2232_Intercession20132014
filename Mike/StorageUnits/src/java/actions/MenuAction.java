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
public class MenuAction extends Action {

    private ActionForward forwardTo;
    private LoginForm authenticated;
    private MultipleActionForm menu;

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

        if (menu.getAction().equals(Util.resources.getString("label.menu.logout"))) {
            forwardTo = mapping.findForward("login");
        } else if (menu.getAction().equals(Util.resources.getString("label.menu.view.my.units"))) {
            forwardTo = mapping.findForward("customerUnitView");
        } else if (menu.getAction().equals(Util.resources.getString("label.menu.view.all.units"))) {
            forwardTo = mapping.findForward("customerViewAll");
        } else if (menu.getAction().equals(Util.resources.getString("label.menu.view.calendar"))) {
            forwardTo = mapping.findForward("customerCalendar");
        } else if (menu.getAction().equals(Util.resources.getString("label.menu.profile"))) {
            forwardTo = mapping.findForward("main");
        }
        return forwardTo;
    }

}

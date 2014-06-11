package actions;

import forms.LoginForm;
import forms.MenuForm;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import util.Util;

/**
 *
 * @author Michael
 * @since Jun 10, 2014
 */
public class MenuAction extends Action {

    private ActionForward forwardTo;
    private LoginForm authenticated;
    private MenuForm menuForm;

    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
//        authenticated = (LoginForm) request.getAttribute("user");
//        if (authenticated == null || authenticated.getValidated() == false) {
//            ActionMessages messages = new ActionMessages();
//            messages.add("error", (new ActionMessage("label.session.expired")));
//            saveMessages(request, messages);
//            return mapping.findForward("login");
//        }
        Util.resources = ResourceBundle.getBundle("com.myapp.struts.ApplicationResource", Locale.getDefault());
        menuForm = (MenuForm) request.getAttribute("menuForm");

        if (menuForm.getAction().equals(Util.resources.getString("label.user.logout"))) {
            forwardTo = mapping.findForward("login");
        } else if (menuForm.getAction().equals(Util.resources.getString("label.user.viewUnit"))) {
            forwardTo = mapping.findForward("main");
        } else if (menuForm.getAction().equals(Util.resources.getString("label.user.viewAllUnits"))) {
            forwardTo = mapping.findForward("main");
        } else if (menuForm.getAction().equals(Util.resources.getString("label.user.calander"))) {
            forwardTo = mapping.findForward("main");
        } else if (menuForm.getAction().equals(Util.resources.getString("label.user.profile"))) {
            forwardTo = mapping.findForward("main");
        }
        return forwardTo;
    }

}

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

        Util.resources = ResourceBundle.getBundle("com.myapp.struts.ApplicationResource", Locale.getDefault());
        mainMenu = (MultipleActionForm) request.getAttribute("multipleActionForm");

        if (mainMenu.getAction().equals(Util.resources.getString("label.main.login"))) {
            forwardTo = mapping.findForward("login");
        } else if (mainMenu.getAction().equals(Util.resources.getString("label.main.create"))) {
            forwardTo = mapping.findForward("addCustomer");
        }
        return forwardTo;
    }
}

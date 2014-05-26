package actions;

import forms.MenuForm;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author Michael Fesser
 * @since 5/25/2014
 * 
 * The purpose of this class is to allow the function of the menu on the welcome page.
 */
public class MenuFormAction extends Action {

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        // Create the object that holds the values from the welcome page.
        MenuForm menuForm = (MenuForm) form;
        // Used to define the page to be forwarded to.
        ActionForward findForward = mapping.findForward("welcome");
        // Currently login is the only option.
        if (menuForm.getOption().equalsIgnoreCase("login")) {
            findForward = mapping.findForward("login");
        }
        return findForward;
    }
}

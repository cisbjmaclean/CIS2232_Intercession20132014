package actions;

import forms.MenuForm;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * @author Ian Mori - removed unused code May 28,2014
 */
public class ProcessMenuAction extends Action {

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        //Get the option chosen from the user.
        MenuForm menuForm = (MenuForm) request.getAttribute("menuForm");
        ActionForward findForward = mapping.findForward("welcome");

        if (menuForm.getOption().equalsIgnoreCase("createNewOrder")) {
            findForward = mapping.findForward("createNewOrder");
        } else if (menuForm.getOption().equalsIgnoreCase("bookSupportSession")) {
            findForward = mapping.findForward("bookSupportSession");
        }
        return findForward;
    }
}

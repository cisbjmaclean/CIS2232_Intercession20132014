package actions;

import business.ReleaseStorageUnit;
import forms.LoginForm;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

/**
 *
 * @author Michael
 * @since Jun 12, 2014
 */
public class ReleaseStorageUnitAction extends Action {

    private ActionForward forwardTo;
    private LoginForm authenticated;
    private LoginForm adminAuthenticated;
    private ReleaseStorageUnit releaseUnit;

    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        ActionMessages messages = new ActionMessages();
        authenticated = (LoginForm) request.getSession().getAttribute("customer");
        adminAuthenticated = (LoginForm) request.getSession().getAttribute("admin");

        if (adminAuthenticated == null || adminAuthenticated.getAdminCode() != 378) {
            if (authenticated == null || authenticated.isValidated() == false) {
                messages.add("error", (new ActionMessage("label.session.expired")));
                saveMessages(request, messages);
                return mapping.findForward("login");
            }
        }

        releaseUnit = new ReleaseStorageUnit();
        releaseUnit.releaseUnit(request);
        messages.add("success", (new ActionMessage("label.customer.storage.unit.view.release.storage.unit.success")));
        saveMessages(request, messages);
        if (adminAuthenticated != null && adminAuthenticated.getAdminCode() == 378) {
            forwardTo = mapping.findForward("adminStorageUnitView");
        } else {
            forwardTo = mapping.findForward("customerStorageUnitView");
        }
        return forwardTo;
    }
}

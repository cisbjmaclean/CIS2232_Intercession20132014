package actions;

import business.ReserveStorageUnit;
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
 * @since Jun 20, 2014
 */
public class ExtendStorageUnitAction extends Action {

    private ActionForward forwardTo;
    private LoginForm authenticated;
    private ReserveStorageUnit reserveUnit;

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
        reserveUnit = new ReserveStorageUnit();
        reserveUnit.extendUnit(request);
        messages.add("success", (new ActionMessage("label.customer.storage.unit.view.extend.storage.unit.success")));
        saveMessages(request, messages);
        forwardTo = mapping.findForward("customerStorageUnitView");
        return forwardTo;
    }
}

package actions;

import business.ReserveStroageUnit;
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
 * @since 6/7/2014
 */
public class ReserveStorageUnitAction extends Action {

    private ActionForward forwardTo;
    private LoginForm authenticated;
    private ReserveStroageUnit reserveUnit;

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
        reserveUnit = new ReserveStroageUnit();
        reserveUnit.reserveUnit(request);
        messages.add("reserved", (new ActionMessage("label.customer.view.all.reserve.storage.unit.success")));
        saveMessages(request, messages);
        forwardTo = mapping.findForward("customerStorageUnitView");
        return forwardTo;
    }
}

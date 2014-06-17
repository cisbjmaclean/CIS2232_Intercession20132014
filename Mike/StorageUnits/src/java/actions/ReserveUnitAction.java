package actions;

import business.ReserveUnit;
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
public class ReserveUnitAction extends Action {

    private ActionForward forwardTo;
    private LoginForm authenticated;
    private ReserveUnit reserveUnit;

    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        ActionMessages messages = new ActionMessages();
        authenticated = (LoginForm) request.getSession().getAttribute("user");
        if (authenticated == null || authenticated.isValidated() == false) {
            messages.add("error", (new ActionMessage("label.session.expired")));
            saveMessages(request, messages);
            return mapping.findForward("login");
        }
        reserveUnit = new ReserveUnit();
        reserveUnit.reserveUnit(request);
        messages.add("reserved", (new ActionMessage("label.customer.view.all.reserve.unit.success")));
        saveMessages(request, messages);
        forwardTo = mapping.findForward("customerUnitView");
        return forwardTo;
    }
}

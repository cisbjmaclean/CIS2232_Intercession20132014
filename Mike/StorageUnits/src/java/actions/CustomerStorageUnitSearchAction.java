package actions;

import business.CustomerSearchStorageUnits;
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
public class CustomerStorageUnitSearchAction extends Action {

    private ActionForward forwardTo;
    private LoginForm authenticated;
    private CustomerSearchStorageUnits searchUnits;

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
        searchUnits = new CustomerSearchStorageUnits();   
        searchUnits.unitSeach(request);     
        forwardTo = mapping.findForward("customerStorageUnitSearchResults");
        return forwardTo;
    }
}

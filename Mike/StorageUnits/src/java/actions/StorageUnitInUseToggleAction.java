package actions;

import business.UpdateStorageUnit;
import forms.LoginForm;
import java.util.logging.Level;
import java.util.logging.Logger;
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
 * @since Jun 21, 2014
 *
 * This class is used to toggle the in use status of a storage unit.
 */
public class StorageUnitInUseToggleAction extends Action {

    private ActionForward forwardTo;
    private LoginForm authenticated;
    private UpdateStorageUnit extendUnit;

    /**
     * This action will pass a request to the UpdateStorageUnit class.
     *
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        ActionMessages messages = new ActionMessages();
        // Validate user
        authenticated = (LoginForm) request.getSession().getAttribute("customer");
        if (authenticated == null || authenticated.isValidated() == false) {
            messages.add("error", (new ActionMessage("session.expired")));
            saveMessages(request, messages);
            return mapping.findForward("login");
        }
        // Pass the request to the UpdateStorageUnit class
        try {
            extendUnit = new UpdateStorageUnit();
            extendUnit.setStorageUnitInUse(request);
            messages.add("success", (new ActionMessage("customer.storage.unit.view.storage.unit.toggle.in.use.success")));
        } catch (Exception e) {
            // Used if there is a critical database error
            Logger.getLogger(UpdateStorageUnit.class.getName()).log(Level.SEVERE, null, e);
            messages.add("error", (new ActionMessage("error.database")));
        }

        saveMessages(request, messages);
        forwardTo = mapping.findForward("customerStorageUnitView");
        return forwardTo;
    }
}

package actions;

import business.ReleaseStorageUnit;
import forms.LoginForm;
import forms.ReleaseStorageUnitForm;
import forms.StorageUnitForm;
import java.util.ArrayList;
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
import util.SortStorageUnits;

/**
 *
 * @author Michael
 * @since Jun 12, 2014
 *
 * This class is used to release a storage unit
 */
public class ReleaseStorageUnitAction extends Action {

    private ActionForward forwardTo;
    private LoginForm authenticated;
    private LoginForm adminAuthenticated;
    private ReleaseStorageUnit releaseUnit;
    private ReleaseStorageUnitForm releaseUnitForm;
    private ArrayList<StorageUnitForm> storageUnits;

    /**
     * This action will pass the ReleaseStorageUnitForm to the
     * ReleaseStorageUnit class.
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
        authenticated = (LoginForm) request.getSession().getAttribute("customer");
        adminAuthenticated = (LoginForm) request.getSession().getAttribute("admin");

        if (adminAuthenticated == null || adminAuthenticated.getAdminCode() != 378) {
            if (authenticated == null || authenticated.isValidated() == false) {
                messages.add("error", (new ActionMessage("session.expired")));
                saveMessages(request, messages);
                return mapping.findForward("login");
            }
        }

        // Pass the storage units and the release unit variable to the ReleaseStorageUnit class.
        try {
            releaseUnitForm = (ReleaseStorageUnitForm) request.getAttribute("releaseStorageUnitForm");
            storageUnits = (ArrayList<StorageUnitForm>) request.getSession().getAttribute("storageUnits");
            releaseUnit = new ReleaseStorageUnit();
            releaseUnit.releaseUnit(releaseUnitForm, storageUnits);
            request.getSession().setAttribute("storageUnits", SortStorageUnits.sortDefault(storageUnits));
        } catch (Exception e) {
            // Used if there is a critical database error
            Logger.getLogger(ReleaseStorageUnit.class.getName()).log(Level.SEVERE, null, e);
            messages.add("error", (new ActionMessage("error.database")));
        }

        messages.add("success", (new ActionMessage("customer.storage.unit.view.release.storage.unit.success")));

        // Forward based on who is logged in.
        if (adminAuthenticated != null && adminAuthenticated.getAdminCode() == 378) {
            forwardTo = mapping.findForward("adminStorageUnitView");
        } else {
            forwardTo = mapping.findForward("customerStorageUnitView");
        }
        saveMessages(request, messages);
        return forwardTo;
    }
}

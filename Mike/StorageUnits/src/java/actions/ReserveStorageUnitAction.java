package actions;

import business.ReserveStorageUnit;
import forms.LoginForm;
import forms.ReserveStorageUnitForm;
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
 * @since 6/7/2014
 * 
 * This class will allow for the reservation of storage units.
 * 
 */
public class ReserveStorageUnitAction extends Action {

    private ActionForward forwardTo;
    private LoginForm authenticated;
    private ReserveStorageUnit reserveUnit;
    private ReserveStorageUnitForm reserveUnitForm;
    private LoginForm user;
    private ArrayList<StorageUnitForm> storageUnits;

    /**
     * This actions will pass the ReserveStorageUnitForm to the
     * ReserveStorageUnit class.
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
        // Validate session
        authenticated = (LoginForm) request.getSession().getAttribute("customer");
        if (authenticated == null || authenticated.isValidated() == false) {
            messages.add("error", (new ActionMessage("session.expired")));
            saveMessages(request, messages);
            return mapping.findForward("login");
        }
        
        // Pass the storage units and the release unit variable to the ReserveStorageUnit class.
        try {
        user = (LoginForm) request.getSession().getAttribute("customer");
        reserveUnitForm = (ReserveStorageUnitForm) request.getAttribute("reserveStorageUnitForm");
        storageUnits = (ArrayList<StorageUnitForm>) request.getSession().getAttribute("storageUnits");
        reserveUnit = new ReserveStorageUnit();
        reserveUnit.reserveUnit(reserveUnitForm, user, storageUnits);
        request.getSession().setAttribute("storageUnits", SortStorageUnits.sortDefault(storageUnits));
               messages.add("success", (new ActionMessage("customer.view.all.reserve.storage.unit.success")));
        } catch (Exception e){
            // Used if there is a critical database error
             Logger.getLogger(ReserveStorageUnit.class.getName()).log(Level.SEVERE, null, e);
                messages.add("error", (new ActionMessage("error.database")));
        }  
        
        saveMessages(request, messages);
        forwardTo = mapping.findForward("customerStorageUnitView");
        return forwardTo;
    }
}

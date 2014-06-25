package actions;

import business.AddStorageUnit;
import forms.LoginForm;
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
 * @since Jun 19, 2014
 */
public class AdminAddStorageUnitAction extends Action {

    private ActionForward forwardTo;
    private LoginForm authenticated;
    private AddStorageUnit addStorageUnit;
    private StorageUnitForm unit;
    private ArrayList<StorageUnitForm> storageUnits;

    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        ActionMessages messages = new ActionMessages();
        authenticated = (LoginForm) request.getSession().getAttribute("admin");
        if (authenticated == null || authenticated.isValidated() == false || authenticated.getAdminCode() != 378) {
            messages.add("error", (new ActionMessage("session.invalid")));
            saveMessages(request, messages);
            return mapping.findForward("login");
        }
        try {
            unit = (StorageUnitForm) request.getAttribute("storageUnitForm");
            addStorageUnit = new AddStorageUnit();
            addStorageUnit.addStorageUnit(unit);
            storageUnits = (ArrayList<StorageUnitForm>) request.getSession().getAttribute("storageUnits");
            request.getSession().setAttribute("storageUnits", SortStorageUnits.sortAdmin(storageUnits));
            messages.add("success", (new ActionMessage("unit.added")));
        } catch (Exception e) {
            Logger.getLogger(AddStorageUnit.class.getName()).log(Level.SEVERE, null, e);          
            messages.add("error", (new ActionMessage("error.database")));
        }     
        forwardTo = mapping.findForward("adminMain");
        saveMessages(request, messages);
        return forwardTo;
    }

}

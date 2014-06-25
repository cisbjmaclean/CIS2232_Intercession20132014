package actions;

import business.LoadStorageUnits;
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
import util.Logout;
import util.SortStorageUnits;

/**
 *
 * @author Michael
 * @since Jun 15, 2014
 */
public class InitializeAction extends Action {

    private LoadStorageUnits loadUnits;
    private ActionForward forwardTo;
    private ArrayList<StorageUnitForm> storageUnits;

    /**
     *
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
        Logout.logout(request, response);
            
        try {
            loadUnits = new LoadStorageUnits();
            storageUnits = new ArrayList();
            storageUnits = loadUnits.loadStorageUnits();
            request.getSession().setAttribute("storageUnits", SortStorageUnits.sortDefault(storageUnits));
        } catch (Exception e) {
            Logger.getLogger(LoadStorageUnits.class.getName()).log(Level.SEVERE, null, e);
            messages.add("error", (new ActionMessage("error.database")));
        }
        saveMessages(request, messages);
        // Used to define the page to be forwarded to.      
        forwardTo = mapping.findForward("mainMenu");
        return forwardTo;
    }
}

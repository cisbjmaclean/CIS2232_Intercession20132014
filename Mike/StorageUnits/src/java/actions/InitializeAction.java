package actions;

import business.LoadStorageUnits;
import forms.StorageUnitForm;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import util.SortStorageUnits;

/**
 *
 * @author Michael
 * @since Jun 15, 2014
 */
public class InitializeAction extends Action{

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
        loadUnits = new LoadStorageUnits();
        storageUnits = new ArrayList();
        storageUnits = loadUnits.loadStorageUnits();
        request.getSession().setAttribute("storageUnits", SortStorageUnits.sortDefault(storageUnits));
        
        // Used to define the page to be forwarded to.      
        forwardTo = mapping.findForward("mainMenu");
        return forwardTo;
    }
}

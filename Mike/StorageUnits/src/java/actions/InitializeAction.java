package actions;

import business.LoadStorageUnits;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author Michael
 * @since Jun 15, 2014
 */
public class InitializeAction extends Action{

    private LoadStorageUnits loadUnits;
    private ActionForward forwardTo;
    
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
        request.getSession().setAttribute("storageUnits", loadUnits.loadStorageUnits(request));
        
        // Used to define the page to be forwarded to.      
        forwardTo = mapping.findForward("mainMenu");
        return forwardTo;
    }
}

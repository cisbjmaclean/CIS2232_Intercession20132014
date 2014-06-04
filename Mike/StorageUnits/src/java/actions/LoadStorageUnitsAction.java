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
 * @author Michael Fesser
 * @since 6/3/2014
 * 
 * The purpose of this class is to allow the function of the login page.
 */
public class LoadStorageUnitsAction extends Action {

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

        LoadStorageUnits loadUnits = new LoadStorageUnits();   
        request.getSession().setAttribute("storageUnits", loadUnits.loadStorageUnits(request));
        
        // Used to define the page to be forwarded to.      
        ActionForward findForward = mapping.findForward("viewAll");  
        return findForward;
    }
}

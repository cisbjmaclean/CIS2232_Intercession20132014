package actions;

import com.opensymphony.xwork2.ActionSupport;
import business.LoadStorageUnits;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Michael Fesser
 * @since 6/3/2014
 * 
 * The purpose of this class is to allow the function of the login page.
 */
public class LoadStorageUnitsAction extends ActionSupport {

    /**
     * 
     * 
     * @param request
     * @param response
     * @return
     * @throws Exception 
     */
     public String execute(HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        LoadStorageUnits loadUnits = new LoadStorageUnits();   
        request.getSession().setAttribute("storageUnits", loadUnits.loadStorageUnits(request));
        
        // Used to define the page to be forwarded to.       
        return SUCCESS;
    }
}

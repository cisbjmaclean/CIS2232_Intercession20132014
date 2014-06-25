package actions;

import business.LoadCustomer;
import business.LoadCustomers;
import business.LoadStorageUnits;
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
 * @since Jun 16, 2014
 */
public class AdminInitializeAction extends Action {

    private LoginForm authenticated;
    private LoadCustomers loadCustomer;
    private LoadCustomers loadLogin;
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
        authenticated = (LoginForm) request.getSession().getAttribute("admin");
        if (authenticated == null || authenticated.isValidated() == false || authenticated.getAdminCode() != 378) {
            messages.add("error", (new ActionMessage("session.invalid")));
            saveMessages(request, messages);
            return mapping.findForward("login");
        }
        
        try{
        loadCustomer = new LoadCustomers();
        request.getSession().setAttribute("allCustomers", loadCustomer.loadCustomers(request));
        loadLogin = new LoadCustomers();
        request.getSession().setAttribute("allLogins", loadLogin.loadLogins(request));
        storageUnits = (ArrayList<StorageUnitForm>) request.getSession().getAttribute("storageUnits");
        request.setAttribute("storageUnits", SortStorageUnits.sortAdmin(storageUnits));
        } catch (Exception e) {
             Logger.getLogger(LoadCustomer.class.getName()).log(Level.SEVERE, null, e);
             Logger.getLogger(LoadStorageUnits.class.getName()).log(Level.SEVERE, null, e);
             Logger.getLogger(LoadCustomer.class.getName()).log(Level.SEVERE, null, e);
            messages.add("error", (new ActionMessage("error.database")));
        }
        
        saveMessages(request, messages);
        // Used to define the page to be forwarded to.          
        ActionForward findForward = mapping.findForward("adminMain");      
        return findForward;
    }
}

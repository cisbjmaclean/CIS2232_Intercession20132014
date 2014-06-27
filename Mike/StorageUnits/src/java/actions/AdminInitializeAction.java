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
 *
 * This class will initialize the application for the administrator.
 */
public class AdminInitializeAction extends Action {

    private LoginForm authenticated;
    private LoadCustomers loadCustomer;
    private LoadCustomers loadLogin;
    private ArrayList<StorageUnitForm> storageUnits;

    /**
     * This action is used to initialize the application for the administrator.
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
        authenticated = (LoginForm) request.getSession().getAttribute("admin");
        if (authenticated == null || authenticated.isValidated() == false || authenticated.getAdminCode() != 378) {
            messages.add("error", (new ActionMessage("session.invalid")));
            saveMessages(request, messages);
            return mapping.findForward("login");
        }

        // Load all the customers and their logins
        try {
            loadCustomer = new LoadCustomers();
            // Set the customers in the session
            request.getSession().setAttribute("allCustomers", loadCustomer.loadCustomers(request));
            loadLogin = new LoadCustomers();
            // Set the customers in the session
            request.getSession().setAttribute("allLogins", loadLogin.loadLogins(request));
            // Used because of funky null pointer errors
            storageUnits = (ArrayList<StorageUnitForm>) request.getSession().getAttribute("storageUnits");
            // Set the storage units in the session
            request.setAttribute("storageUnits", SortStorageUnits.sortAdmin(storageUnits));
        } catch (Exception e) {
            // Used when their is a critical error with the database
            Logger.getLogger(LoadCustomer.class.getName()).log(Level.SEVERE, null, e);
            Logger.getLogger(LoadStorageUnits.class.getName()).log(Level.SEVERE, null, e);
            Logger.getLogger(LoadCustomers.class.getName()).log(Level.SEVERE, null, e);
            messages.add("error", (new ActionMessage("error.database")));
        }

        saveMessages(request, messages);
        // Used to define the page to be forwarded to.          
        ActionForward findForward = mapping.findForward("adminMain");
        return findForward;
    }
}

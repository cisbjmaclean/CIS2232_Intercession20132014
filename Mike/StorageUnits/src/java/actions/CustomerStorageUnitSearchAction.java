package actions;

import business.CustomerSearchStorageUnits;
import forms.CustomerStorageUnitSearchForm;
import forms.LoginForm;
import forms.StorageUnitForm;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

/**
 *
 * @author Michael
 * @since Jun 20, 2014
 *
 * This class will allow customers to search storage units.
 */
public class CustomerStorageUnitSearchAction extends Action {

    private ActionForward forwardTo;
    private LoginForm authenticated;
    private CustomerSearchStorageUnits searchUnits;
    private CustomerStorageUnitSearchForm searchCriteria;
    private ArrayList<StorageUnitForm> storageUnits;
    private ArrayList<StorageUnitForm> searchResults;

    /**
     * This action will pass the CustomerStorageUnitSearchForm to the
     * CustomerSearchStorageUnits class.
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

        searchCriteria = (CustomerStorageUnitSearchForm) request.getAttribute("customerStorageUnitSearchForm");
        storageUnits = (ArrayList<StorageUnitForm>) request.getSession().getAttribute("storageUnits");
        searchResults = new ArrayList<>();
        searchUnits = new CustomerSearchStorageUnits();
        // Call the method with serach critera form the jsp
        searchUnits.unitSeach(searchCriteria, storageUnits, searchResults);
        // Put the search results in the session
        request.setAttribute("customerSearchResults", searchResults);

        forwardTo = mapping.findForward("customerStorageUnitSearchResults");
        return forwardTo;
    }
}

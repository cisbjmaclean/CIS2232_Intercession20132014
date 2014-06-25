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
 */
public class CustomerStorageUnitSearchAction extends Action {

    private ActionForward forwardTo;
    private LoginForm authenticated;
    private CustomerSearchStorageUnits searchUnits;
    private CustomerStorageUnitSearchForm searchCriteria;
    private ArrayList<StorageUnitForm> storageUnits;
    private ArrayList<StorageUnitForm> searchResults;

    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        ActionMessages messages = new ActionMessages();
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
        searchUnits.unitSeach(searchCriteria, storageUnits, searchResults);
        request.setAttribute("customerSearchResults", searchResults);
        
        forwardTo = mapping.findForward("customerStorageUnitSearchResults");
        return forwardTo;
    }
}

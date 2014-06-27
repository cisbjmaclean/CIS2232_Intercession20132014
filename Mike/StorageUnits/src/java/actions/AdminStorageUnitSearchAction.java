package actions;

import business.AdminSearchStorageUnits;
import forms.AdminStorageUnitSearchForm;
import forms.CustomerForm;
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
 * @since Jun 19, 2014
 *
 * This class is used to search for storage units.
 */
public class AdminStorageUnitSearchAction extends Action {

    private LoginForm authenticated;
    private AdminStorageUnitSearchForm searchForm;
    private AdminSearchStorageUnits searchUnit;
    private ArrayList<CustomerForm> allCustomers;
    private ArrayList<StorageUnitForm> storageUnits;
    private ArrayList<StorageUnitForm> searchResults;

    /**
     * This action will pass the AdminStorageUnitSearchForm to the
     * AdminSearchStorageUnits class.
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
        // validate session
        authenticated = (LoginForm) request.getSession().getAttribute("admin");
        if (authenticated == null || authenticated.isValidated() == false || authenticated.getAdminCode() != 378) {
            messages.add("error", (new ActionMessage("session.invalid")));
            saveMessages(request, messages);
            return mapping.findForward("login");
        }

        searchUnit = new AdminSearchStorageUnits();
        searchForm = (AdminStorageUnitSearchForm) request.getAttribute("adminStorageUnitSearchForm");
        allCustomers = (ArrayList<CustomerForm>) request.getSession().getAttribute("allCustomers");
        storageUnits = (ArrayList<StorageUnitForm>) request.getSession().getAttribute("storageUnits");

        // Call the correct method based on the search results from the jsp
        if (searchForm.getUnitID() == 0 && searchForm.getUnitCustomerId() == 0 && searchForm.getUnitCustomerLastName().equals("")) {
            searchResults = (ArrayList<StorageUnitForm>) request.getSession().getAttribute("storageUnits");
        } else if (searchForm.getUnitID() > 0) {
            searchResults = searchUnit.seachByUnitId(searchForm, storageUnits);
        } else if (searchForm.getUnitCustomerId() > 0) {
            searchResults = searchUnit.seachByCustomerId(searchForm, allCustomers, storageUnits);
        } else if (searchForm.getUnitCustomerLastName().length() > 0) {
            searchResults = searchUnit.seachByLastName(searchForm, allCustomers, storageUnits);
        }
        request.getSession().setAttribute("unitList", searchResults);

        return mapping.findForward("adminStorageUnitSearchResults");
    }
}

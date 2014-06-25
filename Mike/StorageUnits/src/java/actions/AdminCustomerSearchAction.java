package actions;

import business.SearchCustomers;
import forms.AdminCustomerSearchForm;
import forms.CustomerForm;
import forms.LoginForm;
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
 * @since Jun 16, 2014
 */
public class AdminCustomerSearchAction extends Action {

    private AdminCustomerSearchForm searchForm;
    private LoginForm authenticated;
    private SearchCustomers searchCustomer;
    private ArrayList<CustomerForm> allCustomers;
    private ArrayList<LoginForm> allLogins;
    private ArrayList<CustomerForm> searchCustomers;

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
        searchCustomer = new SearchCustomers();
        searchForm = (AdminCustomerSearchForm) request.getAttribute("adminCustomerSearchForm");
        allCustomers = (ArrayList<CustomerForm>) request.getSession().getAttribute("allCustomers");
        allLogins = (ArrayList<LoginForm>) request.getSession().getAttribute("allLogins");
        searchCustomers = new ArrayList();

        if (searchForm.getCustomerLastName().equals("") && searchForm.getCustomerUsername().equals("") && searchForm.getCustomerLastName().equals("")) {
            searchCustomers = (ArrayList<CustomerForm>) request.getSession().getAttribute("allCustomers");
        } else if (searchForm.getCustomerEmail().length() > 0) {
            searchCustomers = searchCustomer.seachByEmail(searchForm, allCustomers);
        } else if (searchForm.getCustomerUsername().length() > 0) {
            searchCustomers = searchCustomer.seachByUsername(searchForm, allLogins, allCustomers);
        } else if (searchForm.getCustomerLastName().length() > 0) {
            searchCustomers = searchCustomer.seachByLastName(searchForm, allCustomers);
        }   
        request.setAttribute("customerList", searchCustomers);
        return mapping.findForward("adminCustomerSearchResults");
    }
}

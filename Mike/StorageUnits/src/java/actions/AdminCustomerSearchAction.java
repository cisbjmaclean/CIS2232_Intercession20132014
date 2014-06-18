package actions;

import business.SearchCustomers;
import forms.AdminCustomerSearchForm;
import forms.LoginForm;
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

    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        ActionMessages messages = new ActionMessages();
        authenticated = (LoginForm) request.getSession().getAttribute("admin");
        if (authenticated == null || authenticated.isValidated() == false || authenticated.getAdminCode() != 378) {
            messages.add("error", (new ActionMessage("label.session.invalid")));
            saveMessages(request, messages);
            return mapping.findForward("login");
        }
        searchCustomer = new SearchCustomers();
        searchForm = (AdminCustomerSearchForm) request.getAttribute("adminCustomerSearchForm");
        if (searchForm.getCustomerLastName().equals("") && searchForm.getCustomerUsername().equals("") && searchForm.getCustomerLastName().equals("")){
        request.getSession().setAttribute("customerList", request.getSession().getAttribute("allCustomers"));
        }else if (searchForm.getCustomerEmail().length() > 0) {
            searchCustomer.seachByEmail(searchForm, request);
        } else if (searchForm.getCustomerUsername().length() > 0) {
            searchCustomer.seachByUsername(searchForm, request);
        } else if (searchForm.getCustomerLastName().length() > 0) {
            searchCustomer.seachByLastName(searchForm, request);
        }
        return mapping.findForward("adminSearchResults");
    }
}

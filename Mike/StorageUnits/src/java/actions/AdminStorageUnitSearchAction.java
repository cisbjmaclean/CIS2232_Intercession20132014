package actions;


import business.SearchStroageUnits;
import forms.AdminStorageUnitSearchForm;
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
 * @since Jun 19, 2014
 */
public class AdminStorageUnitSearchAction extends Action {

    private ActionForward forwardTo;
    private LoginForm authenticated;
    private AdminStorageUnitSearchForm searchForm;
    private SearchStroageUnits searchUnit;

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
        searchUnit = new SearchStroageUnits();
        searchForm = (AdminStorageUnitSearchForm) request.getAttribute("adminStorageUnitSearchForm");
        if (searchForm.getUnitId() == 0 && searchForm.getUnitCustomerId()== 0 && searchForm.getUnitCustomerLastName().equals("")){
        request.setAttribute("customerList", request.getSession().getAttribute("allCustomers"));
        }else if (searchForm.getUnitId() > 0) {
            searchUnit.seachByUnitId(searchForm, request);
        } else if (searchForm.getUnitCustomerId()> 0) {
            searchUnit.seachByCustomerId(searchForm, request);
        } else if (searchForm.getUnitCustomerLastName().length() > 0) {
            searchUnit.seachByLastName(searchForm, request);
        }
        return mapping.findForward("adminStroageUnitSearchResults");
    }
}

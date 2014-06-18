package actions;

import business.AddCustomer;
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
public class AddCustomerAction extends Action {

    // Flag for user creation.
    private boolean customerCreation = false;
    private boolean usernameTaken = false;
    private AddCustomer addCustomer;
    private ActionForward findForward;

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

        addCustomer = new AddCustomer(request);
        usernameTaken = addCustomer.checkUsername();
        if (!usernameTaken) {
            customerCreation = addCustomer.addCustomer();
        }
        if (customerCreation) {
            findForward = mapping.findForward("login");
        } else {
            findForward = mapping.findForward("addCustomer");
        }
        return findForward;
    }
}

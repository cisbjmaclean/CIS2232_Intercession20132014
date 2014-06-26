package actions;

import business.AccountDetailsView;
import forms.LoginForm;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import util.Constants;

/**
 * @author Ian Mori
 * @since June 9,2014
 *
 * Creating ViewAccountDetailsAction class, this will try to gather the account
 * details or return an error.
 */
public class ViewAccountDetailsAction extends Action {

    /**
     * This is the action called from the Struts framework.
     *
     * @param mapping The ActionMapping used to select this instance.
     * @param form The optional ActionForm bean for this request.
     * @param request The HTTP Request we are processing.
     * @param response The HTTP Response we are processing.
     * @throws java.lang.Exception
     * @return
     */
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws Exception {

        AccountDetailsView newAccountView = (AccountDetailsView) request.getAttribute("viewAccountDetailsForm");
        ActionMessages messages = new ActionMessages();

        //Using same user Id that was gathered when logging in.
        HttpSession session = request.getSession();
        LoginForm user = (LoginForm) session.getAttribute(Constants.USER_KEY);
        int userId = user.getAuthenticatedUserId();

        //Return true or false depending on if the query was successful.
        boolean wereAccountDetailsRetrievedSuccessfully = newAccountView.retrieveAccountDetails(userId);
        String forwardMapping;

        if (wereAccountDetailsRetrievedSuccessfully) {
            request.getSession().setAttribute("AllAccountDetails", newAccountView.getAccountDetails());
            messages.add("message1", (new ActionMessage("label.customer.details.retrieved.successfully")));
            forwardMapping = Constants.SUCCESS;
        } else {
            messages.add("error", (new ActionMessage("label.customer.details.retrieved.error")));
            forwardMapping = Constants.FAILURE;
        }
        saveMessages(request, messages);
        return mapping.findForward(forwardMapping);
    }
}

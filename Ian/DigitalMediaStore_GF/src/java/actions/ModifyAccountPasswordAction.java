package actions;

import business.ModifyAccountPassword;
import forms.LoginForm;
import forms.ModifyAccountPasswordForm;
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
 * Creating ModifyAccountPasswordAction class, this will try to modify the user
 * password or return an error.
 */
public class ModifyAccountPasswordAction extends Action {

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws Exception {

        //Same process, gather form data and try and process the data.
        ModifyAccountPasswordForm newAccountForm = (ModifyAccountPasswordForm) request.getAttribute("modifyAccountForm");
        //Gather the confirmed password, use this value to be set in the database.
        String password = newAccountForm.getConfirmNewCustomerPassword();

        //Getting the user Id from the sessions attribute.
        HttpSession session = request.getSession();
        LoginForm user = (LoginForm) session.getAttribute(Constants.USER_KEY);
        int userId = user.getAuthenticatedUserId();

        ActionMessages messages = new ActionMessages();
        String forwardMapping;

        //Try and modify the account in the database with the data gathered.
        ModifyAccountPassword modifyAccount = new ModifyAccountPassword();
        boolean wasAccountModifiedSuccessfully = modifyAccount.modifyNewAccount(password, userId);

        if (wasAccountModifiedSuccessfully) {
            messages.add("message1", (new ActionMessage("label.account.modified.successfully")));
            forwardMapping = Constants.SUCCESS;
        } else {
            messages.add("error", (new ActionMessage("label.account.modified.error")));
            forwardMapping = Constants.FAILURE;
        }
        saveMessages(request, messages);
        return mapping.findForward(forwardMapping);
    }
}

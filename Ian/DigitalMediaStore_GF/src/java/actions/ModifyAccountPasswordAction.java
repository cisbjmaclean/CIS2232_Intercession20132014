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
 *
 * @author prog
 */
public class ModifyAccountPasswordAction extends Action {

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws Exception {

        ModifyAccountPasswordForm newAccountForm = (ModifyAccountPasswordForm) request.getAttribute("modifyAccountForm");
        ModifyAccountPassword modifyAccount = new ModifyAccountPassword();
        String password = newAccountForm.getConfirmNewCustomerPassword();

        HttpSession session = request.getSession();
        LoginForm user = (LoginForm) session.getAttribute(Constants.USER_KEY);
        int userId = user.getAuthenticatedUserId();

        ActionMessages messages = new ActionMessages();
        boolean wasAccountModifiedSuccessfully = modifyAccount.modifyNewAccount(password, userId);
        String forwardMapping;

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

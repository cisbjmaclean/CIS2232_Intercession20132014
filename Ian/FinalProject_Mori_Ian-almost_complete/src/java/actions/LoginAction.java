package actions;

import business.Login;
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
 * @since May 15,2014
 *
 * Creating LoginAction class, this will log a user in or return an error.
 */
public class LoginAction extends Action {

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

        LoginForm formBean = (LoginForm) form;
        boolean isLoginSuccessful = Login.loadAuthenticatedUserFromDatabase(formBean);
        String mappingForward;

        if (isLoginSuccessful) {
            HttpSession session = request.getSession();
            session.setAttribute(Constants.USER_KEY, form);
            mappingForward = Constants.SUCCESS;
        } else {
            ActionMessages messages = new ActionMessages();            
            messages.add("error", new ActionMessage("error.logon.invalid"));
            saveMessages(request, messages);
            mappingForward = Constants.FAILURE;
        }
        //Generate custom error type for mismatched username and password.
        return mapping.findForward(mappingForward);
    }
}

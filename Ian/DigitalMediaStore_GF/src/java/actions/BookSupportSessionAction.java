package actions;

import business.SupportSession;
import forms.LoginForm;
import forms.SupportSessionForm;
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
 * @since June 9, 2014
 *
 * This is the BookSupportSessionAction class, it will try to submit the
 * support.
 */
public class BookSupportSessionAction extends Action {

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws Exception {

        //Getting the values from the support session form.         
        SupportSessionForm newSupportSession = (SupportSessionForm) request.getAttribute("supportSessionForm");

        //Setting the session and userId.
        HttpSession session = request.getSession();
        LoginForm user = (LoginForm) session.getAttribute(Constants.USER_KEY);
        int userId = user.getAuthenticatedUserId();

        //Try submitting the values to the database.
        SupportSession supportSession = new SupportSession();
        boolean wasSupportSessionBookedSuccessfully = supportSession.saveNewSupportSession(newSupportSession, userId);

        ActionMessages messages = new ActionMessages();
        String forwardMapping;

        //If there is success, the support session is booked and should now be viewable.
        if (wasSupportSessionBookedSuccessfully) {
            messages.add("message1", (new ActionMessage("label.support.session.added.successfully")));
            forwardMapping = Constants.SUCCESS;
        } else {
            messages.add("error", (new ActionMessage("label.support.session.added.error")));
            forwardMapping = Constants.FAILURE;
        }
        saveMessages(request, messages);
        return mapping.findForward(forwardMapping);
    }
}

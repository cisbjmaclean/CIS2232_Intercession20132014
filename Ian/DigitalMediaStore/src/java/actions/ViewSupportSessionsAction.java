package actions;

import business.SupportSessionView;
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
 * Creating ViewSupportSessionsAction class, this will try to view all the
 * support session or return an error.
 */
public class ViewSupportSessionsAction extends Action {

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

        SupportSessionView newSupportSessionView = (SupportSessionView) request.getAttribute("viewSupportSessionsForm");
        ActionMessages messages = new ActionMessages();

        //Gathering the user Id.
        HttpSession session = request.getSession();
        LoginForm user = (LoginForm) session.getAttribute(Constants.USER_KEY);
        int userId = user.getAuthenticatedUserId();

        //Querying the database and returning true or false.
        boolean wereSupportSessionDetailsRetrievedSuccessfully = newSupportSessionView.retrieveSupportSessions(userId);
        String forwardMapping;

        if (wereSupportSessionDetailsRetrievedSuccessfully) {
            //If successful, use the support sessions to view on the corresponding JSP.
            request.getSession().setAttribute("AllSupportSessions", newSupportSessionView.getSupportSessions());
            messages.add("message1", (new ActionMessage("label.support.sessions.retrieved.successfully")));
            forwardMapping = Constants.SUCCESS;
        } else {
            messages.add("error", (new ActionMessage("label.support.sessions.retrieved.error")));
            forwardMapping = Constants.FAILURE;
        }
        saveMessages(request, messages);
        return mapping.findForward(forwardMapping);
    }
}

package actions;

import business.SupportSessionDetailsView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
public class ViewSupportSessionDetailsAction extends Action {

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

        SupportSessionDetailsView newSupportSessionView = (SupportSessionDetailsView) request.getAttribute("viewSupportSessionDetailsForm");
        ActionMessages messages = new ActionMessages();

        boolean wereSupportSessionDetailsRetrievedSuccessfully = newSupportSessionView.retrieveSupportSessionDetails();
        String forwardMapping;

        if (wereSupportSessionDetailsRetrievedSuccessfully) {
            request.getSession().setAttribute("AllSupportSessionDetails", newSupportSessionView.getSupportSessionDetails());
            messages.add("message1", (new ActionMessage("label.support.session.details.retrieved.successfully")));
            forwardMapping = Constants.SUCCESS;
        } else {
            messages.add("error", (new ActionMessage("label.support.session.details.retrieved.error")));
            forwardMapping = Constants.FAILURE;
        }
        saveMessages(request, messages);
        return mapping.findForward(forwardMapping);
    }
}

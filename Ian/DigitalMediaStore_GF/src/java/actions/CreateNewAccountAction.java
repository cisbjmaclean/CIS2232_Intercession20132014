package actions;

import business.Account;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import forms.AccountForm;
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
 * @since June 9,2014
 *
 * Creating CreateNewAccountAction class, this will try to create a new account or
 * return an error.
 */
public class CreateNewAccountAction extends Action {

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

        //Gathering the account form data.
        AccountForm newAccountForm = (AccountForm) request.getAttribute("accountForm");
        ActionMessages messages = new ActionMessages();
        String forwardMapping = Constants.FAILURE;

        Account saveAccount = new Account();
        boolean wasNewAccountAddedSuccessfully = false;

        //This code might throw an exception if the user account is already created.
        try {
            //Set boolean variable to the result of trying to update the database.
            wasNewAccountAddedSuccessfully = saveAccount.saveNewAccount(newAccountForm);
            if (wasNewAccountAddedSuccessfully) {
                messages.add("message1", (new ActionMessage("label.customer.added.successfully")));
                forwardMapping = Constants.SUCCESS;
            } else {
                messages.add("error", (new ActionMessage("label.customer.added.error")));
                forwardMapping = Constants.FAILURE;
            }
        } catch (MySQLIntegrityConstraintViolationException e) {
            messages.add("error", (new ActionMessage("label.customer.duplicate.error")));
            forwardMapping = Constants.FAILURE;
        } catch (Exception e) {
            String errorMessage = e.getMessage();
            e.printStackTrace();
        }
        saveMessages(request, messages);
        return mapping.findForward(forwardMapping);
    }
}

package actions;

import business.Order;
import forms.LoginForm;
import forms.OrderForm;
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
 * Creating FinalizeOrderAction class, this will try to finalize the order or
 * return an error.
 */
public class FinalizeOrderAction extends Action {

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

        //This will gather the order form data.
        OrderForm newOrderForm = (OrderForm) request.getAttribute("orderForm");
        ActionMessages messages = new ActionMessages();

        //Getting the userId, this stores the user Id when a user first logs in.
        HttpSession session = request.getSession();
        LoginForm user = (LoginForm) session.getAttribute(Constants.USER_KEY);
        int userId = user.getAuthenticatedUserId();

        //Trying to save a new order to the database.
        Order saveOrder = new Order();
        boolean wasOrderAddedSuccessfully = saveOrder.saveNewOrder(newOrderForm, userId);
        String forwardMapping;

        //If successful, display success, otherwise an error will be produced.
        if (wasOrderAddedSuccessfully) {
            messages.add("message1", (new ActionMessage("label.order.created.successfully")));
            forwardMapping = Constants.SUCCESS;
        } else {
            messages.add("error", (new ActionMessage("label.order.created.error")));
            forwardMapping = Constants.FAILURE;
        }
        saveMessages(request, messages);
        return mapping.findForward(forwardMapping);
    }
}

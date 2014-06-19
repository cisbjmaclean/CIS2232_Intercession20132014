package actions;

import business.OrderLine;
import business.OrderLineView;
import java.util.ArrayList;
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
public class ViewOrderDetailsAction extends Action {

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

        OrderLineView newOrderLineView = (OrderLineView) request.getAttribute("viewOrderDetailsForm");
        ActionMessages messages = new ActionMessages();

        boolean wereOrderDetailsRetrievedSuccessfully = newOrderLineView.retrieveOrderDetails();
        String forwardMapping;

        ArrayList<OrderLineView> orderLines = OrderLineView.getOrderLines();
        double orderTotal = 0.00;
        for (OrderLineView theLine : orderLines) {
            orderTotal += theLine.getOrder_line_total();
        }

        if (wereOrderDetailsRetrievedSuccessfully) {
            request.getSession().setAttribute("AllOrderLines", orderLines);
            request.getSession().setAttribute("OrderTotalView", orderTotal);
            messages.add("message1", (new ActionMessage("label.order.details.retrieved.successfully")));
            forwardMapping = Constants.SUCCESS;
        } else {
            messages.add("error", (new ActionMessage("label.order.details.retrieved.error")));
            forwardMapping = Constants.FAILURE;
        }
        saveMessages(request, messages);
        return mapping.findForward(forwardMapping);
    }
}

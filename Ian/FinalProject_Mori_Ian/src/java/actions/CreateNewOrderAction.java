package actions;

import business.OrderLine;
import forms.OrderForm;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * @author Ian Mori
 * @since May 15,2014
 *
 * Creating LoginAction class, this will log a user in or return an error.
 */
public class CreateNewOrderAction extends Action {

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

        OrderForm newOrderForm = (OrderForm) request.getAttribute("orderForm");
        newOrderForm.getTotalOrderLines();
        OrderLine.setOrderedItems(newOrderForm.getOrderLines());

        ArrayList<OrderLine> orderLines = OrderLine.getOrderedItems();
        double orderTotal = 0.00;
        for (OrderLine theLine : orderLines) {
            orderTotal += theLine.getOrderLineTotal();
        }
        
        request.getSession().setAttribute("AllItems", orderLines);
        request.getSession().setAttribute("OrderTotal", orderTotal);
        return mapping.findForward("finalize");
    }
}

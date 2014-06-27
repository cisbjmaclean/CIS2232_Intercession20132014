package business;

import forms.AdminModifyCustomerForm;
import forms.CustomerForm;
import forms.LoginForm;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Michael
 * @since Jun 17, 2014
 *
 * This class is used to get the specific customer information to be used when
 * updating a customer.
 */
public class SetCustomerUpdateInfo {

    private ArrayList<CustomerForm> allCustomers;
    private ArrayList<LoginForm> allLogins;

    /**
     * This method uses the customer id to get the requested customer details
     * that will be used to populate the update customer jsp.
     *
     * @param customerID
     * @param request
     */
    public void setCustomer(AdminModifyCustomerForm customerID, HttpServletRequest request) {
        allCustomers = (ArrayList<CustomerForm>) request.getSession().getAttribute("allCustomers");
        for (CustomerForm allCustomers : allCustomers) {
            if (allCustomers.getCustomerID() == customerID.getCustomerID()) {
                request.getSession().setAttribute("customerDetails", allCustomers);
            }
        }
        allLogins = (ArrayList<LoginForm>) request.getSession().getAttribute("allLogins");
        for (LoginForm allLogins : allLogins) {
            if (allLogins.getCustomerID() == customerID.getCustomerID()) {
                request.getSession().setAttribute("customer", allLogins);
            }
        }
    }
}

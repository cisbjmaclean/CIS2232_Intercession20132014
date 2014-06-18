
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
 */
public class SetCustomerUpdateInfo {

    private ArrayList<CustomerForm> allCustomers;
    private ArrayList<LoginForm> allLogins;
    
    public void setCustomer(AdminModifyCustomerForm customerId, HttpServletRequest request) {
        allCustomers = (ArrayList<CustomerForm>) request.getSession().getAttribute("allCustomers");
        for (CustomerForm allCustomers : allCustomers) {
            if (allCustomers.getCustomerId() == customerId.getCustomerId()){
                request.getSession().setAttribute("customerInfo", allCustomers);
            }     
        }
        allLogins = (ArrayList<LoginForm>) request.getSession().getAttribute("allLogins");
        for (LoginForm allLogins : allLogins) {
            if (allLogins.getCustomerId() == customerId.getCustomerId()){
                request.getSession().setAttribute("customerLogin", allLogins);
            }     
        }
    }
}

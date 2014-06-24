
package business;

import forms.AdminModifyCustomerForm;
import forms.CustomerForm;
import forms.LoginForm;
import java.util.ArrayList;
import java.util.Iterator;
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
        for (Iterator<CustomerForm> it = allCustomers.iterator(); it.hasNext();) {
            CustomerForm allCustomers = it.next();
            if (allCustomers.getCustomerId() == customerId.getCustomerId()){
                request.getSession().setAttribute("customerDetails", allCustomers);
            }     
        }
        allLogins = (ArrayList<LoginForm>) request.getSession().getAttribute("allLogins");
        for (Iterator<LoginForm> it = allLogins.iterator(); it.hasNext();) {
            LoginForm allLogins = it.next();
            if (allLogins.getCustomerId() == customerId.getCustomerId()){
                request.getSession().setAttribute("customer", allLogins);
            }     
        }
    }
}

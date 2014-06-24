
package business;

import forms.AdminCustomerSearchForm;
import forms.CustomerForm;
import forms.LoginForm;
import java.util.ArrayList;

/**
 *
 * @author Michael
 * @since Jun 17, 2014
 */
public class SearchCustomers {

    private ArrayList<CustomerForm> searchCustomers;

    public ArrayList<CustomerForm> seachByEmail(AdminCustomerSearchForm searchForm, ArrayList<CustomerForm> allCustomers) {       
        searchCustomers = new ArrayList();
        for (CustomerForm customer : allCustomers) {
            if (customer.getEmail().equalsIgnoreCase(searchForm.getCustomerEmail())) {
                searchCustomers.add(customer);
            }
        }
        return searchCustomers;
    }

    public ArrayList<CustomerForm> seachByUsername(AdminCustomerSearchForm searchForm, ArrayList<LoginForm> allLogins, ArrayList<CustomerForm> allCustomers) {
        searchCustomers = new ArrayList();
        for (LoginForm login : allLogins) {
            if (login.getUsername().equalsIgnoreCase(searchForm.getCustomerUsername())) {
                for (CustomerForm customer : allCustomers) {
                    if (login.getCustomerId() == customer.getCustomerId()) {
                        searchCustomers.add(customer);
                    }
                }
            }
        }
       return searchCustomers;
    }

    public ArrayList<CustomerForm>seachByLastName(AdminCustomerSearchForm searchForm, ArrayList<CustomerForm> allCustomers) {
        searchCustomers = new ArrayList();
        for (CustomerForm customer : allCustomers) {
            if (customer.getLastName().equalsIgnoreCase(searchForm.getCustomerLastName())) {
                searchCustomers.add(customer);
            }
        }
        return searchCustomers;      
    }
}

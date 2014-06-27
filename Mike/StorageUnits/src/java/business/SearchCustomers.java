package business;

import forms.AdminCustomerSearchForm;
import forms.CustomerForm;
import forms.LoginForm;
import java.util.ArrayList;

/**
 *
 * @author Michael
 * @since Jun 17, 2014
 *
 * This class is used by the administrators to search for customers by specific
 * criteria.
 *
 */
public class SearchCustomers {

    private ArrayList<CustomerForm> searchCustomers;

    /**
     * This method uses the email criteria to populate an ArrayList then return
     * it.
     *
     * @param searchForm
     * @param allCustomers
     * @return
     */
    public ArrayList<CustomerForm> seachByEmail(AdminCustomerSearchForm searchForm, ArrayList<CustomerForm> allCustomers) {
        searchCustomers = new ArrayList();
        for (CustomerForm customer : allCustomers) {
            if (customer.getEmail().equalsIgnoreCase(searchForm.getCustomerEmail())) {
                searchCustomers.add(customer);
            }
        }
        return searchCustomers;
    }

    /**
     * This method uses the username criteria to populate an ArrayList then
     * return it.
     *
     * @param searchForm
     * @param allLogins
     * @param allCustomers
     * @return
     */
    public ArrayList<CustomerForm> seachByUsername(AdminCustomerSearchForm searchForm, ArrayList<LoginForm> allLogins, ArrayList<CustomerForm> allCustomers) {
        searchCustomers = new ArrayList();
        for (LoginForm login : allLogins) {
            if (login.getUsername().equalsIgnoreCase(searchForm.getCustomerUsername())) {
                for (CustomerForm customer : allCustomers) {
                    if (login.getCustomerID() == customer.getCustomerID()) {
                        searchCustomers.add(customer);
                    }
                }
            }
        }
        return searchCustomers;
    }

    /**
     * This method uses the last name criteria to populate an ArrayList then
     * return it.
     *
     * @param searchForm
     * @param allCustomers
     * @return
     */
    public ArrayList<CustomerForm> seachByLastName(AdminCustomerSearchForm searchForm, ArrayList<CustomerForm> allCustomers) {
        searchCustomers = new ArrayList();
        for (CustomerForm customer : allCustomers) {
            if (customer.getLastName().equalsIgnoreCase(searchForm.getCustomerLastName())) {
                searchCustomers.add(customer);
            }
        }
        return searchCustomers;
    }
}

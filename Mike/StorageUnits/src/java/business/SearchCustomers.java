package business;

import forms.AdminCustomerSearchForm;
import forms.CustomerForm;
import forms.LoginForm;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Michael
 * @since Jun 17, 2014
 */
public class SearchCustomers {

    private ArrayList<CustomerForm> allCustomers;
    private ArrayList<LoginForm> allLogins;
    private ArrayList<CustomerForm> searchCustomers;
    private ArrayList<LoginForm> searchLogins;

    public void seachByEmail(AdminCustomerSearchForm searchForm, HttpServletRequest request) {
        allCustomers = (ArrayList<CustomerForm>) request.getSession().getAttribute("allCustomers");
        searchCustomers = new ArrayList();
        for (CustomerForm allCustomers : allCustomers) {
            if (allCustomers.getEmail().equals(searchForm.getCustomerEmail())) {
                searchCustomers.add(allCustomers);
            }
        }
        request.getSession().setAttribute("customerList", searchCustomers);
    }

    public void seachByUsername(AdminCustomerSearchForm searchForm, HttpServletRequest request) {
        allLogins = (ArrayList<LoginForm>) request.getSession().getAttribute("allLogins");
        allCustomers = (ArrayList<CustomerForm>) request.getSession().getAttribute("allCustomers");
        searchCustomers = new ArrayList();
        for (LoginForm allLogins : allLogins) {
            if (allLogins.getUsername().equals(searchForm.getCustomerUsername())) {
                for (CustomerForm allCustomers : allCustomers) {
                    if (allLogins.getCustomerId() == allCustomers.getCustomerId()) {
                        searchCustomers.add(allCustomers);
                    }
                }
            }
        }
        request.getSession().setAttribute("customerList", searchCustomers);
    }

    public void seachByLastName(AdminCustomerSearchForm searchForm, HttpServletRequest request) {
        allCustomers = (ArrayList<CustomerForm>) request.getSession().getAttribute("allCustomers");
        searchCustomers = new ArrayList();
        for (CustomerForm allCustomers : allCustomers) {
            if (allCustomers.getLastName().equals(searchForm.getCustomerLastName())) {
                searchCustomers.add(allCustomers);
            }
        }
        request.getSession().setAttribute("customerList", searchCustomers);
    }
}

package business;

import forms.AdminStorageUnitSearchForm;
import forms.CustomerForm;
import forms.StorageUnitForm;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Michael
 * @since Jun 19, 2014
 */
public class AdminSearchStorageUnits {

    private ArrayList<CustomerForm> allCustomers;
    private ArrayList<StorageUnitForm> searchUnits;
    private ArrayList<StorageUnitForm> storageUnits;

    public void seachByUnitId(AdminStorageUnitSearchForm searchForm, HttpServletRequest request) {
        storageUnits = (ArrayList<StorageUnitForm>) request.getSession().getAttribute("storageUnits");
        for (StorageUnitForm storageUnit : storageUnits) {
            if (storageUnit.getUnitId() == searchForm.getUnitId()) {
                request.setAttribute("UnitList", storageUnit);
            }
        }
    }

    public void seachByCustomerId(AdminStorageUnitSearchForm searchForm, HttpServletRequest request) {
        searchUnits = new ArrayList();
        storageUnits = (ArrayList<StorageUnitForm>) request.getSession().getAttribute("storageUnits");
        for (StorageUnitForm storageUnit : storageUnits) {
            if (storageUnit.getCustomerId() == searchForm.getUnitCustomerId()) {
                searchUnits.add(storageUnit);
            }
        }
        request.setAttribute("UnitList", searchUnits);
    }

    public void seachByLastName(AdminStorageUnitSearchForm searchForm, HttpServletRequest request) {
        int customerId = 0;
        allCustomers = (ArrayList<CustomerForm>) request.getSession().getAttribute("allCustomers");
        storageUnits = (ArrayList<StorageUnitForm>) request.getSession().getAttribute("storageUnits");
        for (CustomerForm allCustomers : allCustomers) {
            if (allCustomers.getLastName().equalsIgnoreCase(searchForm.getUnitCustomerLastName())) {
                customerId = allCustomers.getCustomerId();
            }
        }
        searchUnits = new ArrayList();
        for (StorageUnitForm storageUnit : storageUnits) {
            if (storageUnit.getCustomerId() == customerId) {
                searchUnits.add(storageUnit);
            }
        }
        request.setAttribute("UnitList", searchUnits);
    }
}

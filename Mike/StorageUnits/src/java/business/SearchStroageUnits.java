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
public class SearchStroageUnits {

    private ArrayList<CustomerForm> allCustomers;
    private ArrayList<StorageUnitForm> searchUnits;

    public void seachByUnitId(AdminStorageUnitSearchForm searchForm, HttpServletRequest request) {

        for (StorageUnitForm storageUnit : LoadStorageUnits.getStorageUnits()) {
            if (storageUnit.getUnitId() == searchForm.getUnitId()) {
                request.setAttribute("UnitList", storageUnit);
            }
        }
    }

    public void seachByCustomerId(AdminStorageUnitSearchForm searchForm, HttpServletRequest request) {
        searchUnits = new ArrayList();
        for (StorageUnitForm storageUnit : LoadStorageUnits.getStorageUnits()) {
            if (storageUnit.getCustomerId() == searchForm.getUnitCustomerId()) {
                searchUnits.add(storageUnit);
            }
        }
        request.setAttribute("UnitList", searchUnits);
    }

    public void seachByLastName(AdminStorageUnitSearchForm searchForm, HttpServletRequest request) {
        int customerId = 0;
        allCustomers = (ArrayList<CustomerForm>) request.getSession().getAttribute("allCustomers");
        for (CustomerForm allCustomers : allCustomers) {
            if (allCustomers.getLastName().equalsIgnoreCase(searchForm.getUnitCustomerLastName())) {
                customerId = allCustomers.getCustomerId();
            }
        }
        searchUnits = new ArrayList();   
        for (StorageUnitForm storageUnit : LoadStorageUnits.getStorageUnits()){
            if (storageUnit.getCustomerId() == customerId) {
                searchUnits.add(storageUnit);
            }
        }
        request.setAttribute("UnitList", searchUnits);
    }
}

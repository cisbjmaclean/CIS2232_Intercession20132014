package business;

import forms.AdminStorageUnitSearchForm;
import forms.CustomerForm;
import forms.StorageUnitForm;
import java.util.ArrayList;


/**
 *
 * @author Michael
 * @since Jun 19, 2014
 */
public class AdminSearchStorageUnits {

    private ArrayList<StorageUnitForm> searchUnits;

    public ArrayList seachByUnitId(AdminStorageUnitSearchForm searchForm, ArrayList<StorageUnitForm> storageUnits) {
        searchUnits = new ArrayList();
        for (StorageUnitForm storageUnit : storageUnits) {
            if (storageUnit.getUnitId() == searchForm.getUnitId()) {
                searchUnits.add(storageUnit);
            }
        }
        return searchUnits;
    }

    public ArrayList seachByCustomerId(AdminStorageUnitSearchForm searchForm, ArrayList<CustomerForm> allCustomers, ArrayList<StorageUnitForm> storageUnits) {
        searchUnits = new ArrayList();
        for (StorageUnitForm storageUnit : storageUnits) {
            if (storageUnit.getCustomerId() == searchForm.getUnitCustomerId()) {
                searchUnits.add(storageUnit);
            }
        }
        return searchUnits;
    }

    public ArrayList seachByLastName(AdminStorageUnitSearchForm searchForm, ArrayList<CustomerForm> allCustomers, ArrayList<StorageUnitForm> storageUnits) {
        int customerId = 0;
        for (CustomerForm customer : allCustomers) {
            if (customer.getLastName().equalsIgnoreCase(searchForm.getUnitCustomerLastName())) {
                customerId = customer.getCustomerId();
            }
        }
        searchUnits = new ArrayList();
        for (StorageUnitForm storageUnit : storageUnits) {
            if (storageUnit.getCustomerId() == customerId) {
                searchUnits.add(storageUnit);
            }
        }
        return searchUnits;
    }
}

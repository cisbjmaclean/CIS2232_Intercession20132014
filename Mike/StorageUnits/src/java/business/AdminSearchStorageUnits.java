package business;

import forms.AdminStorageUnitSearchForm;
import forms.CustomerForm;
import forms.StorageUnitForm;
import java.util.ArrayList;

/**
 *
 * @author Michael
 * @since Jun 19, 2014
 *
 * This class is used to return the results of the admin storage unit search.
 */
public class AdminSearchStorageUnits {

    private ArrayList<StorageUnitForm> searchUnits;

    /**
     * This method returns results based on unit id
     *
     * @param searchForm
     * @param storageUnits
     * @return
     */
    public ArrayList seachByUnitId(AdminStorageUnitSearchForm searchForm, ArrayList<StorageUnitForm> storageUnits) {
        searchUnits = new ArrayList();
        for (StorageUnitForm storageUnit : storageUnits) {
            if (storageUnit.getUnitID() == searchForm.getUnitID()) {
                searchUnits.add(storageUnit);
            }
        }
        return searchUnits;
    }

    /**
     * This method return results based on customer id.
     *
     * @param searchForm
     * @param allCustomers
     * @param storageUnits
     * @return
     */
    public ArrayList seachByCustomerId(AdminStorageUnitSearchForm searchForm, ArrayList<CustomerForm> allCustomers, ArrayList<StorageUnitForm> storageUnits) {
        searchUnits = new ArrayList();
        for (StorageUnitForm storageUnit : storageUnits) {
            if (storageUnit.getCustomerID() == searchForm.getUnitCustomerId()) {
                searchUnits.add(storageUnit);
            }
        }
        return searchUnits;
    }

    /**
     * This method returns results based on customer last name.
     *
     * @param searchForm
     * @param allCustomers
     * @param storageUnits
     * @return
     */
    public ArrayList seachByLastName(AdminStorageUnitSearchForm searchForm, ArrayList<CustomerForm> allCustomers, ArrayList<StorageUnitForm> storageUnits) {
        int customerID = 0;
        for (CustomerForm customer : allCustomers) {
            if (customer.getLastName().equalsIgnoreCase(searchForm.getUnitCustomerLastName())) {
                customerID = customer.getCustomerID();
            }
        }
        searchUnits = new ArrayList();
        for (StorageUnitForm storageUnit : storageUnits) {
            if (storageUnit.getCustomerID() == customerID) {
                searchUnits.add(storageUnit);
            }
        }
        return searchUnits;
    }
}

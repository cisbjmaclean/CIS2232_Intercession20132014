package business;

import forms.CustomerStorageUnitSearchForm;
import forms.StorageUnitForm;
import java.util.ArrayList;

/**
 *
 * @author Michael
 * @since Jun 20, 2014
 */
public class CustomerSearchStorageUnits {

    private int unitAvailability = -1;
    private String unitDimensions = "-1";
    private String dateTo = "-1";
    private int numberSearchCriteria;

    public void unitSeach(CustomerStorageUnitSearchForm searchCriteria, ArrayList<StorageUnitForm> storageUnits, ArrayList<StorageUnitForm> searchResults) {

        if (searchCriteria.getUnitAvailability() != -1) {
            unitAvailability = searchCriteria.getUnitAvailability();
            numberSearchCriteria++;
        }
        if (!searchCriteria.getUnitDimensions().equalsIgnoreCase("")) {
            unitDimensions = searchCriteria.getUnitDimensions();
            numberSearchCriteria++;
        }
        if (!searchCriteria.getDateTo().equalsIgnoreCase("Click Here")) {
            dateTo = searchCriteria.getDateTo();
            numberSearchCriteria++;
        }

        if (numberSearchCriteria == 1) {
            searchOneCriteria(storageUnits, searchResults);
        } else if (numberSearchCriteria == 2) {
            searchTwoCriteria(storageUnits, searchResults);
        } else if (numberSearchCriteria == 3) {
            searchThreeCriteria(storageUnits, searchResults);
        } else {
            getAll(storageUnits, searchResults);
        }
    }

    public void getAll(ArrayList<StorageUnitForm> storageUnits, ArrayList<StorageUnitForm> searchResults) {
        for (StorageUnitForm storageUnit : storageUnits) {
            searchResults.add(storageUnit);
        }
    }

    public void searchOneCriteria(ArrayList<StorageUnitForm> storageUnits, ArrayList<StorageUnitForm> searchResults) {
        for (StorageUnitForm storageUnit : storageUnits) {
            if (unitAvailability == storageUnit.getUnitAvailability()) {
                searchResults.add(storageUnit);
            } else if (unitDimensions.equals(storageUnit.getUnitDimensions())) {
                searchResults.add(storageUnit);
            } else if (dateTo.equals(storageUnit.getUnitDateTo())) {
                searchResults.add(storageUnit);
            }
        }
    }

    public void searchTwoCriteria(ArrayList<StorageUnitForm> storageUnits, ArrayList<StorageUnitForm> searchResults) {
        for (StorageUnitForm storageUnit : storageUnits) {
            if (unitAvailability == storageUnit.getUnitAvailability() && unitDimensions.equals(storageUnit.getUnitDimensions())) {
                searchResults.add(storageUnit);
            } else if (unitAvailability == storageUnit.getUnitAvailability() && dateTo.equals(storageUnit.getUnitDateTo())) {
                searchResults.add(storageUnit);
            } else if (unitDimensions.equals(storageUnit.getUnitDimensions()) && dateTo.equals(storageUnit.getUnitDateTo())) {
                searchResults.add(storageUnit);
            }
        }
    }

    public void searchThreeCriteria(ArrayList<StorageUnitForm> storageUnits, ArrayList<StorageUnitForm> searchResults) {
        for (StorageUnitForm storageUnit : storageUnits) {
            if (unitAvailability == storageUnit.getUnitAvailability() && unitDimensions.equals(storageUnit.getUnitDimensions()) && dateTo.equals(storageUnit.getUnitDateTo())) {
                searchResults.add(storageUnit);
            }
        }
    }
}

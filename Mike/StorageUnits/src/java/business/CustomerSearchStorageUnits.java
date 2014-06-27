package business;

import forms.CustomerStorageUnitSearchForm;
import forms.StorageUnitForm;
import java.util.ArrayList;

/**
 *
 * @author Michael
 * @since Jun 20, 2014
 *
 * This class is used for customer storage unit searches.
 */
public class CustomerSearchStorageUnits {

    private int unitAvailability = -1;
    private String unitDimensions = "-1";
    private String dateTo = "-1";
    private int numberSearchCriteria;

    /**
     * This method receives the search criteria and then returns the results.
     *
     * @param searchCriteria
     * @param storageUnits
     * @param searchResults
     */
    public void unitSeach(CustomerStorageUnitSearchForm searchCriteria, ArrayList<StorageUnitForm> storageUnits, ArrayList<StorageUnitForm> searchResults) {

        // Check if the search criteria was by unitAvailability
        if (searchCriteria.getUnitAvailability() != -1) {
            unitAvailability = searchCriteria.getUnitAvailability();
            numberSearchCriteria++;
        }
        // Check if the search criteria was by unitDimensions
        if (!searchCriteria.getUnitDimensions().equalsIgnoreCase("")) {
            unitDimensions = searchCriteria.getUnitDimensions();
            numberSearchCriteria++;
        }
        // Check if the search criteria was by dateTo
        if (!searchCriteria.getDateTo().equalsIgnoreCase("Click Here")) {
            dateTo = searchCriteria.getDateTo();
            numberSearchCriteria++;
        }

        // Count the number of search criteria.
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

    /**
     * This method will populate the ArrayList based on no criteria.
     *
     * @param storageUnits
     * @param searchResults
     */
    public void getAll(ArrayList<StorageUnitForm> storageUnits, ArrayList<StorageUnitForm> searchResults) {
        for (StorageUnitForm storageUnit : storageUnits) {
            searchResults.add(storageUnit);
        }
    }

    /**
     * This method will populate the ArrayList based on one criteria.
     *
     * @param storageUnits
     * @param searchResults
     */
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

    /**
     * This method will populate the ArrayList based on two criteria.
     *
     * @param storageUnits
     * @param searchResults
     */
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

    /**
     * This method will populate the ArrayList based on three criteria.
     *
     * @param storageUnits
     * @param searchResults
     */
    public void searchThreeCriteria(ArrayList<StorageUnitForm> storageUnits, ArrayList<StorageUnitForm> searchResults) {
        for (StorageUnitForm storageUnit : storageUnits) {
            if (unitAvailability == storageUnit.getUnitAvailability() && unitDimensions.equals(storageUnit.getUnitDimensions()) && dateTo.equals(storageUnit.getUnitDateTo())) {
                searchResults.add(storageUnit);
            }
        }
    }
}

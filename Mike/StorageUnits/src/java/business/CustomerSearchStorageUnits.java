package business;

import forms.CustomerStorageUnitSearchForm;
import forms.StorageUnitForm;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Michael
 * @since Jun 20, 2014
 */
public class CustomerSearchStorageUnits {

    private int unitAvailability = -1;
    private String unitDimensions = "-1";
    private String dateTo = "-1";
    private CustomerStorageUnitSearchForm searchCriteria;
    private int numberSearchCriteria;
    private ArrayList<StorageUnitForm> storageUnits;
    private ArrayList<StorageUnitForm> searchResults;

    public void unitSeach(HttpServletRequest request) {
        searchCriteria = (CustomerStorageUnitSearchForm) request.getAttribute("customerStorageUnitSearchForm");
        storageUnits = (ArrayList<StorageUnitForm>) request.getSession().getAttribute("storageUnits");
        searchResults = new ArrayList<>();

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
            searchOneCriteria();
        } else if (numberSearchCriteria == 2) {
            searchTwoCriteria();
        } else if (numberSearchCriteria == 3) {
            searchThreeCriteria();
        } else {
            searchResults = (ArrayList<StorageUnitForm>) request.getSession().getAttribute("storageUnits");
        }
        request.setAttribute("customerSearchResults", searchResults);

    }

    public void searchOneCriteria() {
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

    public void searchTwoCriteria() {
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

    public void searchThreeCriteria() {
        for (StorageUnitForm storageUnit : storageUnits) {
            if (unitAvailability == storageUnit.getUnitAvailability() && unitDimensions.equals(storageUnit.getUnitDimensions()) && dateTo.equals(storageUnit.getUnitDateTo())) {
                searchResults.add(storageUnit);
            }
        }
    }
}

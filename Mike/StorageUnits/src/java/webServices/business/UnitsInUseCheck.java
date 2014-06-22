package webServices.business;

import business.LoadStorageUnits;
import forms.StorageUnitForm;
import java.util.ArrayList;

/**
 *
 * @author Michael
 * @since Jun 22, 2014
 */
public class UnitsInUseCheck {

    private LoadStorageUnits loadUnits;
    private ArrayList<StorageUnitForm> units;
    private String unitsInUseString;

    public String getUnitsInUse(int customerId) {
        loadUnits = new LoadStorageUnits();
        units = new ArrayList();
        units.addAll(loadUnits.loadStorageUnits(null));

        if (units.size() > 0) {
            unitsInUseString = "The storageUnits you currenlty have in use are:";
            for (StorageUnitForm storageUnit : units) {
                if (storageUnit.getCustomerId() == customerId) {
                    if (storageUnit.getUnitInUse() == 1) {
                        unitsInUseString += "\nStorage Unit " + storageUnit.getUnitId();
                    }
                }
            }
        } else {
            unitsInUseString = "You currently have no storageUnits in use.";
        }
        return unitsInUseString;
    }
}

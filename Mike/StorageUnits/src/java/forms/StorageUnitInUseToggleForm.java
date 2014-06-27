package forms;

import org.apache.struts.validator.ValidatorForm;

/**
 *
 * @author Michael
 * @since Jun 21, 2014
 *
 * This class is the form used to hold the unit id and toggle value to toggle
 * the in use status of a storage unit.
 */
public class StorageUnitInUseToggleForm extends ValidatorForm {

    private int unitID;
    private int storageUnitToggle;

    public int getUnitID() {
        return unitID;
    }

    public void setUnitID(int unitID) {
        this.unitID = unitID;
    }

    public int getStorageUnitToggle() {
        return storageUnitToggle;
    }

    public void setStorageUnitToggle(int storageUnitToggle) {
        this.storageUnitToggle = storageUnitToggle;
    }
}

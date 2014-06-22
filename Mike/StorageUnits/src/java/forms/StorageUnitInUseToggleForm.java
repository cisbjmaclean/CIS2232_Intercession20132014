package forms;

import org.apache.struts.validator.ValidatorForm;

/**
 *
 * @author Michael
 * @since Jun 21, 2014
 */
public class StorageUnitInUseToggleForm extends ValidatorForm {

    private int unitId;
    private int storageUnitToggle;

    public int getUnitId() {
        return unitId;
    }

    public void setUnitId(int unitId) {
        this.unitId = unitId;
    }

    public int getStorageUnitToggle() {
        return storageUnitToggle;
    }

    public void setStorageUnitToggle(int storageUnitToggle) {
        this.storageUnitToggle = storageUnitToggle;
    }
}

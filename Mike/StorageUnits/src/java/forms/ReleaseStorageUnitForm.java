package forms;

import org.apache.struts.validator.ValidatorForm;

/**
 *
 * @author Michael
 * @since Jun 12, 2014
 *
 * This class is the form used to hold the id of the storage unit to be
 * released.
 */
public class ReleaseStorageUnitForm extends ValidatorForm {

    private int unitID;

    public int getUnitID() {
        return unitID;
    }

    public void setUnitID(int unitID) {
        this.unitID = unitID;
    }
}

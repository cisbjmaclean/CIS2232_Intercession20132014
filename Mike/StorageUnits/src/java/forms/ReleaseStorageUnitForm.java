package forms;

import org.apache.struts.validator.ValidatorForm;

/**
 *
 * @author Michael
 * @since Jun 12, 2014
 */
public class ReleaseStorageUnitForm extends ValidatorForm {

    private int unitId;

    public int getUnitId() {
        return unitId;
    }

    public void setUnitId(int unitId) {
        this.unitId = unitId;
    }
}

package forms;

import org.apache.struts.validator.ValidatorForm;

/**
 *
 * @author Michael
 * @since Jun 13, 2014
 */
public class ReserveStorageUnitForm extends ValidatorForm {

    private int unitId;
    private String dateTo;

    public int getUnitId() {
        return unitId;
    }

    public void setUnitId(int unitId) {
        this.unitId = unitId;
    }

    public String getDateTo() {
        return dateTo;
    }

    public void setDateTo(String dateTo) {
        this.dateTo = dateTo;
    }
}

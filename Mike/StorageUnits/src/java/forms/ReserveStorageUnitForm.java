package forms;

import org.apache.struts.validator.ValidatorForm;

/**
 *
 * @author Michael
 * @since Jun 13, 2014
 *
 * This class is the form used to hold the unit id and date to for reserving
 * storage units.
 */
public class ReserveStorageUnitForm extends ValidatorForm {

    private int unitID;
    private String dateTo;

    public int getUnitID() {
        return unitID;
    }

    public void setUnitID(int unitID) {
        this.unitID = unitID;
    }

    public String getDateTo() {
        return dateTo;
    }

    public void setDateTo(String dateTo) {
        this.dateTo = dateTo;
    }
}

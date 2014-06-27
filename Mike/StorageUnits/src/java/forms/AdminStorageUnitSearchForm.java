package forms;

import org.apache.struts.validator.ValidatorForm;

/**
 *
 * @author Michael
 * @since Jun 19, 2014
 *
 * This class is the form used to search for storage units.
 */
public class AdminStorageUnitSearchForm extends ValidatorForm {

    private int unitID;
    private int unitCustomerId;
    private String unitCustomerLastName;

    public int getUnitID() {
        return unitID;
    }

    public void setUnitID(int unitID) {
        this.unitID = unitID;
    }

    public int getUnitCustomerId() {
        return unitCustomerId;
    }

    public void setUnitCustomerId(int unitCustomerId) {
        this.unitCustomerId = unitCustomerId;
    }

    public String getUnitCustomerLastName() {
        return unitCustomerLastName;
    }

    public void setUnitCustomerLastName(String unitCustomerLastName) {
        this.unitCustomerLastName = unitCustomerLastName;
    }

}

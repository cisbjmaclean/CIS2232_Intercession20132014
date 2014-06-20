package forms;

import org.apache.struts.validator.ValidatorForm;

/**
 *
 * @author Michael
 * @since Jun 19, 2014
 */
public class AdminStorageUnitSearchForm extends ValidatorForm{

    private int unitId;
    private int unitCustomerId;
    private String unitCustomerLastName;

    public int getUnitId() {
        return unitId;
    }

    public void setUnitId(int unitId) {
        this.unitId = unitId;
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

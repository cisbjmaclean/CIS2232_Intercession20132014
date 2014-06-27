package forms;

import org.apache.struts.validator.ValidatorForm;

/**
 *
 * @author Michael Fesser
 * @since 5/30/2014
 *
 * This class is the form used to hold the details of the storage units.
 */
public class StorageUnitForm extends ValidatorForm {

    private int unitID;
    private String unitType;
    private String unitDimensions;
    private int unitAvailability;
    private String unitDateFrom;
    private String unitDateTo;
    private int unitInUse;
    public int customerID;

    public StorageUnitForm() {
    }

    public int getUnitID() {
        return unitID;
    }

    public void setUnitID(int unitID) {
        this.unitID = unitID;
    }

    public String getUnitType() {
        return unitType;
    }

    public void setUnitType(String unitType) {
        this.unitType = unitType;
    }

    public String getUnitDimensions() {
        return unitDimensions;
    }

    public void setUnitDimensions(String unitDimensions) {
        this.unitDimensions = unitDimensions;
    }

    public int getUnitAvailability() {
        return unitAvailability;
    }

    public void setUnitAvailability(int unitAvailability) {
        this.unitAvailability = unitAvailability;
    }

    public String getUnitDateFrom() {
        return unitDateFrom;
    }

    public void setUnitDateFrom(String unitDateFrom) {
        this.unitDateFrom = unitDateFrom;
    }

    public String getUnitDateTo() {
        return unitDateTo;
    }

    public void setUnitDateTo(String unitDateTo) {
        this.unitDateTo = unitDateTo;
    }

    public int getUnitInUse() {
        return unitInUse;
    }

    public void setUnitInUse(int unitInUse) {
        this.unitInUse = unitInUse;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerId(int customerID) {
        this.customerID = customerID;
    }
}

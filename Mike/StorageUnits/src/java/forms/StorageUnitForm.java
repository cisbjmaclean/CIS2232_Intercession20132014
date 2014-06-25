package forms;

import org.apache.struts.validator.ValidatorForm;

/**
 *
 * @author Michael Fesser
 * @since 5/30/2014
 */

public class StorageUnitForm extends ValidatorForm {

    private int unitId;
    private String unitType;
    private String unitDimensions;
    private int unitAvailability;
    private String unitDateFrom;
    private String unitDateTo;
    private int unitInUse;
    public int customerId;

    public StorageUnitForm() {
    }

    public int getUnitId() {
        return unitId;
    }

    public void setUnitId(int unitId) {
        this.unitId = unitId;
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

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
}

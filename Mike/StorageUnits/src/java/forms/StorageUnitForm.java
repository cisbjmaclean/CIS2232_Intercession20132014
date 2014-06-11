package forms;

import org.apache.struts.action.ActionForm;

/**
 *
 * @author Michael Fesser
 * @since 5/30/2014
 */
public class StorageUnitForm extends ActionForm {

    private int unitId;
    private String unitType;
    private String unitDimensions;
    private String  UnitAvalibility;
    private String  UnitDateFrom;
    private String  UnitDateTo;
    private int customerId;

    public StorageUnitForm(){
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

    public String getUnitAvalibility() {
        return UnitAvalibility;
    }

    public void setUnitAvalibility(String UnitAvalibility) {
        this.UnitAvalibility = UnitAvalibility;
    }

    public String getUnitDateFrom() {
        return UnitDateFrom;
    }

    public void setUnitDateFrom(String UnitDateFrom) {
        this.UnitDateFrom = UnitDateFrom;
    }

    public String getUnitDateTo() {
        return UnitDateTo;
    }

    public void setUnitDateTo(String UnitDateTo) {
        this.UnitDateTo = UnitDateTo;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
}

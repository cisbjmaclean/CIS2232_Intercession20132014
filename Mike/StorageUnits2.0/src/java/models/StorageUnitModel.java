package models;

import com.opensymphony.xwork2.ActionSupport;

/**
 *
 * @author Michael Fesser
 */
public class StorageUnitModel extends ActionSupport {

    private int unitId;
    private String unitType;
    private String unitDimensions;
    private String  UnitAvalibility;
    private String  UnitDateFrom;
    private String  UnitDateTo;

    public StorageUnitModel(){
    }
            
    public StorageUnitModel(int unitId, String unitType, String unitDimensions, String unitAvalibility, String unitDateFrom, String unitDateTo) {
        this.unitId = unitId;
        this.unitType = unitType;
        this.unitDimensions = unitDimensions;
        this.UnitAvalibility = unitAvalibility;
        this.UnitDateFrom = unitDateFrom;
        this.UnitDateTo = unitDateTo;
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

   
}

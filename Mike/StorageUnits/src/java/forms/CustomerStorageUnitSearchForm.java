package forms;

import org.apache.struts.validator.ValidatorForm;

/**
 *
 * @author Michael
 * @since Jun 20, 2014
 */
public class CustomerStorageUnitSearchForm extends ValidatorForm{
    
    private int unitAvailability;
    private String unitDimensions;
    private String dateTo;

    public int getUnitAvailability() {
        return unitAvailability;
    }

    public void setUnitAvailability(int unitAvailability) {
        this.unitAvailability = unitAvailability;
    }

    public String getUnitDimensions() {
        return unitDimensions;
    }

    public void setUnitDimensions(String unitDimensions) {
        this.unitDimensions = unitDimensions;
    }

    public String getDateTo() {
        return dateTo;
    }

    public void setDateTo(String dateTo) {
        this.dateTo = dateTo;
    }
}

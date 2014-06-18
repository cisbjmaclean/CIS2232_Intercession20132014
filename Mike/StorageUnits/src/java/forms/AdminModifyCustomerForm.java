package forms;

import org.apache.struts.validator.ValidatorForm;

/**
 *
 * @author Michael
 * @since Jun 17, 2014
 */
public class AdminModifyCustomerForm extends ValidatorForm{

    private int customerId;
    String action;

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    } 

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}


package forms;

import org.apache.struts.validator.ValidatorForm;

/**
 *
 * @author Michael
 * @since Jun 17, 2014
 * 
 * This class is the form used to modify customers.
 */
public class AdminModifyCustomerForm extends ValidatorForm{

    private int customerID;
    String action;

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    } 

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}


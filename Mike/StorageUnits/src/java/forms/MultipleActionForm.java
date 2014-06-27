package forms;

import org.apache.struts.validator.ValidatorForm;

/**
 *
 * @author Michael
 * @since Jun 10, 2014
 *
 * This class is the form used to hold the value of the menu choices.
 */
public class MultipleActionForm extends ValidatorForm {

    String action;

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}

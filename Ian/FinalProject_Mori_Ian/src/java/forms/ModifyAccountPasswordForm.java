package forms;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.validator.ValidatorForm;

/**
 *
 * @author prog
 */
public class ModifyAccountPasswordForm extends ValidatorForm{
    
      String newCustomerPassword, confirmNewCustomerPassword;

    public String getNewCustomerPassword() {
        return newCustomerPassword;
    }

    public void setNewCustomerPassword(String newCustomerPassword) {
        this.newCustomerPassword = newCustomerPassword;
    }

    public String getConfirmNewCustomerPassword() {
        return confirmNewCustomerPassword;
    }

    public void setConfirmNewCustomerPassword(String confirmNewCustomerPassword) {
        this.confirmNewCustomerPassword = confirmNewCustomerPassword;
    }

   
    
    
    
    @Override
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        ActionErrors errors = new ActionErrors();

        if (getNewCustomerPassword() == null || getNewCustomerPassword().length() < 1) {
            errors.add("password", new ActionMessage("error.new.password.required"));
        }
        if (!getNewCustomerPassword().equals(getConfirmNewCustomerPassword())) {
            errors.add("newPasswordMismatch", new ActionMessage("error.new.password.confirmation"));
        }
        return errors;
    }
    
    
}

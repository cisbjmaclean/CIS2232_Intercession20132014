package forms;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.validator.ValidatorForm;

/**
 * @author Ian Mori
 * @since June 9,2014
 *
 * Creating LoginForm class, holds the setters and getters for the form.
 */
public class LoginForm extends ValidatorForm {

    private String customerUsernameToValidate;
    private String customerPasswordToValidate;
    private String authenticatedUser;
    private int authenticatedUserId;

    public String getAuthenticatedUser() {
        return authenticatedUser;
    }

    public void setAuthenticatedUser(String authenticatedUser) {
        this.authenticatedUser = authenticatedUser;
    }

    public int getAuthenticatedUserId() {
        return authenticatedUserId;
    }

    public void setAuthenticatedUserId(int authenticatedUserId) {
        this.authenticatedUserId = authenticatedUserId;
    }

    public String getCustomerUsernameToValidate() {
        return customerUsernameToValidate;
    }

    public void setCustomerUsernameToValidate(String customerUsernameToValidate) {
        this.customerUsernameToValidate = customerUsernameToValidate;
    }

    public String getCustomerPasswordToValidate() {
        return customerPasswordToValidate;
    }

    public void setCustomerPasswordToValidate(String customerPasswordToValidate) {
        this.customerPasswordToValidate = customerPasswordToValidate;
    }

    public LoginForm() {
        super();
    }

    /**
     * This is the action called from the Struts framework.
     *
     * @param mapping The ActionMapping used to select this instance.
     * @param request The HTTP Request we are processing.
     * @return
     */
    @Override
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        ActionErrors errors = new ActionErrors();

        if (getCustomerUsernameToValidate() == null || getCustomerUsernameToValidate().length() < 1) {
            errors.add("username", new ActionMessage("error.username.required"));
        }
        if (getCustomerPasswordToValidate() == null || getCustomerPasswordToValidate().length() < 1) {
            errors.add("password", new ActionMessage("error.password.required"));
        }
        return errors;
    }
}

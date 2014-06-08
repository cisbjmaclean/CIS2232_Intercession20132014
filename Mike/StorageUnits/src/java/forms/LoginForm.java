package forms;

import org.apache.struts.action.ActionForm;

/**
 *
 * @author Michael Fesser
 * @since 5/25/2014
 * 
 * The purpose of this class is to hold that values from the form on the login page. 
 */
public class LoginForm extends ActionForm {

    private int customerId;
    private String username;
    private String password;
    private boolean validated;

     public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getValidated() {
        return validated;
    }

    public void setValidated(boolean validated) {
        this.validated = validated;
    }
}

package forms;

import org.apache.struts.validator.ValidatorForm;

/**
 * @author Ryan
 *
 * purpose: This class is used to create user objects. It is used during the 
 * login phase but also used when collecting the users from the database.
 * 
 */

public class LoginForm extends ValidatorForm {
    
    private int userID;

    private String userName = "";

    private String password = "";

    public LoginForm() {
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}

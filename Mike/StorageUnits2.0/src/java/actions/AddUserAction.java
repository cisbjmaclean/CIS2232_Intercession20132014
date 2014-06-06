package actions;

import business.AddUser;
import com.opensymphony.xwork2.ActionSupport;
import models.LoginModel;
import models.UserModel;

/**
 *
 * @author Michael Fesser
 * @since 6/3/2014
 *
 * The purpose of this class is to allow the function of the login page.
 */
public class AddUserAction extends ActionSupport {

    private static final long serialVersionUID = 1L;
    private LoginModel addUserLoginObject;
    private UserModel addUserDetailsObject;
    private AddUser addUser;
    private boolean userCreation = false;
    private boolean usernameTaken = false;
    private String created = "error";

    public String execute() throws Exception {
        addUser = new AddUser();
        usernameTaken = addUser.checkUsername(getAddUserLoginObject());
        if (!usernameTaken) {
            userCreation = addUser.addToDatabase(getAddUserDetailsObject(), getAddUserLoginObject());
        }
        if (userCreation) {
            created = "success";
        }
       return created;
    }

    public LoginModel getAddUserLoginObject() {
        return addUserLoginObject;
    }

    public void setAddUserLoginObject(LoginModel addUserLoginObject) {
        this.addUserLoginObject = addUserLoginObject;
    }

    public UserModel getAddUserDetailsObject() {
        return addUserDetailsObject;
    }

    public void setAddUserDetailsObject(UserModel addUserDetailsObject) {
        this.addUserDetailsObject = addUserDetailsObject;
    }

   
}

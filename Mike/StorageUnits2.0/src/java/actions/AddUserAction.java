package actions;

import business.AddUser;
import com.opensymphony.xwork2.ActionSupport;
import models.AddUserModel;

/**
 *
 * @author Michael Fesser
 * @since 6/3/2014
 *
 * The purpose of this class is to allow the function of the login page.
 */
public class AddUserAction extends ActionSupport {

    private static final long serialVersionUID = 1L;
    private AddUserModel addUserObject;
    private AddUser addUser;
    private boolean userCreation = false;
    private boolean usernameTaken = false;
    private String created = "error";

    public String execute() throws Exception {
        addUser = new AddUser();
        usernameTaken = addUser.checkUsername(addUserObject);
        if (!usernameTaken) {
            userCreation = addUser.addToDatabase(addUserObject);
        }
        if (userCreation) {
            created = "success";
        }
       return created;
    }

    public AddUserModel getAddUserObject() {
        return addUserObject;
    }

    public void setAddUserObject(AddUserModel addUserObject) {
        this.addUserObject = addUserObject;
    } 
}

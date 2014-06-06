package actions;

import com.opensymphony.xwork2.ActionSupport;
import business.AddUser;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
    // Flag for user creation.
    private boolean userCreation = false;
    private boolean usernameTaken = false;
    private String created = "error";
    private AddUserModel userForm;

    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        userForm = (AddUserModel) request.getAttribute("AddUserForm");
        AddUser addUser = new AddUser();
        usernameTaken = addUser.checkUsername(userForm);
        System.out.println(usernameTaken);
        if (!usernameTaken) {
            userCreation = addUser.addToDatabase(userForm);
        }
        if (userCreation) {
            created = "success";
        }
        return created;
    }
}

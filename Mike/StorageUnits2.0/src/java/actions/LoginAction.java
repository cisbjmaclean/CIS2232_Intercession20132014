package actions;

import business.Login;
import com.opensymphony.xwork2.ActionSupport;
import models.LoginModel;

/**
 *
 * @author Michael Fesser
 * @since 5/25/2014
 *
 * The purpose of this class is to allow the function of the login page.
 */
public class LoginAction extends ActionSupport {

    private static final long serialVersionUID = 1L;
    // Flag for login access.
    private boolean authenticate = false;
    private String loggedIn = "error";
    private Login validateLogin;
    private LoginModel login;

    /**
     * This method gets the fields from the login page and calls the user class
     * and its functions that validate them vs the password file.
     *
     * @return
     * @throws Exception
     */
    public String execute() throws Exception {

        validateLogin = new Login();
        authenticate = validateLogin.checkLogin(login);
        if (authenticate) {
            loggedIn = "success";
        }
        return loggedIn;
    }

    public LoginModel getLogin() {
        return login;
    }

    public void setLogin(LoginModel login) {
        this.login = login;
    }
}

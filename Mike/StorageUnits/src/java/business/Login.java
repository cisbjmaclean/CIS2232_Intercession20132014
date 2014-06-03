package business;

import forms.LoginForm;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.DatabaseConnection;
import util.DbUtils;

/**
 *
 * @author Michael Fesser
 */
public class Login {

    // The object used for each new connection.
    private DatabaseConnection dbConnection = new DatabaseConnection();
    // Used to allow for more security when sending data to a database.
    private PreparedStatement psAuthenticate;
    private String sql;
    // The connection object.
    private Connection con;
    private ResultSet rs = null;
    private boolean authenicate = false;

    /**
     * This method retrieves data from the database.
     *
     * @param validateLogin
     */
    public boolean checkLogin(LoginForm validateLogin) {

        // Try to connect to the database.
        try {
            this.con = dbConnection.databaseConnection();
        } catch (Exception e) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, e);
            System.err.println("The connection to the database failed.");
        }

        // Try to generate the query.
        try {
            // The query to send.
            this.sql = "SELECT `log_username`, `log_password` FROM `login`";
            this.psAuthenticate = this.con.prepareStatement(this.sql);
            // Send the query and get the results back.
            this.rs = this.psAuthenticate.executeQuery();

            String userName;
            String password;

            // Iterate over the result set.
            while (this.rs.next()) {
                userName = this.rs.getString("log_username");
                password = this.rs.getString("log_password");
                if (validateLogin.getUserName().equals(userName) && validateLogin.getPassword().equals(password)) {
                    this.authenicate = true;
                    break;
                }
            }
        } catch (Exception e) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, e);
            System.err.println("There was an issue with the query.");
        } finally {
            // Close the result set, psAuthenicate,  and the connection objects.
            DbUtils.close(this.rs, this.psAuthenticate, this.con);
        }
        return authenicate;
    }
}

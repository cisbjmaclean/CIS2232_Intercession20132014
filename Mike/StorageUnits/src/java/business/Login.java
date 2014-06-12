package business;

import forms.LoginForm;
import forms.UserForm;
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
    private UserForm user;

    /**
     * This method retrieves data from the database.
     *
     * @param validateLogin
     */
    public boolean checkLogin(LoginForm validateLogin) {

        // Try to connect to the database.
        try {
            con = dbConnection.databaseConnection();
        } catch (Exception e) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, e);
            System.err.println("The connection to the database failed.");
        }

        // Try to generate the query.
        try {
            int customerId;

            // The query to send.         
            sql = "SELECT `cus_id` FROM `login` WHERE `login_username` = ? AND `login_password` = ?";
            psAuthenticate = con.prepareStatement(sql);
            psAuthenticate.setString(1, validateLogin.getUsername());
            psAuthenticate.setString(2, validateLogin.getPassword());
            // Send the query and get the results back.
            rs = psAuthenticate.executeQuery();

            // Iterate over the result set.
            while (rs.next()) {
                customerId = rs.getInt("cus_id");
                validateLogin.setCustomerId(customerId);
                validateLogin.setValidated(true);
                authenicate = true;
            }
        } catch (Exception e) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, e);
            System.err.println("There was an issue with the query.");
        } finally {
            // Close the result set, psAuthenicate,  and the connection objects.
            DbUtils.close(rs, psAuthenticate, con);
        }
        return authenicate;
    }
}

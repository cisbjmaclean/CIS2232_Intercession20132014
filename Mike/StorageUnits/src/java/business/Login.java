package business;

import forms.LoginForm;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.DatabaseConnection;
import util.DbUtils;
import webServices.business.UnitsInUseCheck;

/**
 *
 * @author Michael Fesser
 * @since Jun 19, 2014
 *
 * This is the login class. All users use this class to login.
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
    private int customerID;
    private UnitsInUseCheck checkUnitsInUse;
    private String unitsInUse;
    private String authenticate = "none";

    /**
     * This method connects to the database and checks to see if a username has
     * been taken. It returns false if it has.
     *
     * @param validateLogin
     * @return
     * @throws java.lang.Exception
     */
    public String checkLogin(LoginForm validateLogin) throws Exception {

        // Try to connect to the database.
        try {
            con = dbConnection.databaseConnection();
        } catch (Exception e) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, e);
            System.err.println("The connection to the database failed.");
        }

        // Try to generate the query.
        try {

            // The query to send.         
            sql = "SELECT * FROM `customer_login` WHERE `cus_login_username` = ? AND `cus_login_password` = ?";
            psAuthenticate = con.prepareStatement(sql);
            psAuthenticate.setString(1, validateLogin.getUsername());
            psAuthenticate.setString(2, validateLogin.getPassword());
            // Send the query and get the results back.
            rs = psAuthenticate.executeQuery();

            // Iterate over the result set.
            while (rs.next()) {
                if (validateLogin.getPassword().equals(rs.getString("cus_login_password"))) {
                    customerID = rs.getInt("cus_id");
                    validateLogin.setCustomerId(customerID);
                    validateLogin.setValidated(true);
                    authenticate = "customer";
                }
            }
        } catch (Exception e) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, e);
            // Thrown if there is a critical error with the database.
            throw new Exception();
        } finally {
            // Close the result set, psAuthenicate,  and the connection objects.
            DbUtils.close(rs, psAuthenticate, con);
        }
        return authenticate;
    }

    /**
     * This method connects to the database and validates the admin login.
     *
     * @param validateLogin
     * @return
     * @throws Exception
     */
    public String checkAdminLogin(LoginForm validateLogin) throws Exception {
        // Try to connect to the database.
        try {
            con = dbConnection.databaseConnection();
        } catch (Exception e) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, e);
            System.err.println("The connection to the database failed.");
        }

        // Try to generate the query.
        try {
            int adminCode;

            // The query to send.         
            sql = "SELECT * FROM `admin_login` WHERE `admin_login_username` = ? AND `admin_login_password` = ?";
            psAuthenticate = con.prepareStatement(sql);
            psAuthenticate.setString(1, validateLogin.getUsername());
            psAuthenticate.setString(2, validateLogin.getPassword());
            // Send the query and get the results back.
            rs = psAuthenticate.executeQuery();

            // Iterate over the result set.
            while (rs.next()) {
                if (validateLogin.getPassword().equals(rs.getString("admin_login_password"))) {
                    adminCode = rs.getInt("admin_login_code");
                    validateLogin.setAdminCode(adminCode);
                    validateLogin.setValidated(true);
                    authenticate = "admin";
                }
            }
        } catch (Exception e) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, e);
            // Thrown if there is a critical error with the database.
            throw new Exception();
        } finally {
            // Close the result set, psAuthenicate,  and the connection objects.
            DbUtils.close(rs, psAuthenticate, con);
        }
        return authenticate;
    }

    /**
     * This method is used to allow a remote login to the server to allow a
     * customer to see which of their storage units are in use.
     *
     * @param username
     * @param password
     * @return
     */
    public String webServiceCheckStorageUnitsInUse(String username, String password) {

        // Try to connect to the database.
        try {
            con = dbConnection.databaseConnection();
        } catch (Exception e) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, e);
            System.err.println("The connection to the database failed.");
        }

        // Try to generate the query.
        try {
            checkUnitsInUse = new UnitsInUseCheck();
            // The query to send.         
            sql = "SELECT `cus_id` FROM `customer_login` WHERE `cus_login_username` = ? AND `cus_login_password` = ?";
            psAuthenticate = con.prepareStatement(sql);
            psAuthenticate.setString(1, username);
            psAuthenticate.setString(2, password);
            // Send the query and get the results back.
            rs = psAuthenticate.executeQuery();

            // Iterate over the result set.
            while (rs.next()) {
                customerID = rs.getInt("cus_id");
            }
        } catch (Exception e) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, e);
            System.err.println("There was an issue with the query.");
        } finally {
            // Close the result set, psAuthenicate,  and the connection objects.
            DbUtils.close(rs, psAuthenticate, con);
        }
        // Call the method to return the units in use or return an error if login validation fails.
        if (customerID != 0) {
            unitsInUse = checkUnitsInUse.getUnitsInUse(customerID);
        } else {
            unitsInUse = "There was an error with the login.";
        }
        return unitsInUse;
    }
}

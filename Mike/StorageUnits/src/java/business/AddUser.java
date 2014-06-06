package business;

import forms.AddUserForm;
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
public class AddUser {

    // The object used for each new connection.
    private DatabaseConnection dbConnection = new DatabaseConnection();
    // Used to allow for more security when sending data to a database.
    private PreparedStatement psAuthenticate;
    private String sql;
    // The connection object.
    private Connection con;
    private ResultSet rs = null;
    private boolean usernameTaken = false;

    public boolean checkUsername(AddUserForm userForm) {
        // Try to connect to the database.  
        try {
            this.con = dbConnection.databaseConnection();
        } catch (Exception e) {
            Logger.getLogger(AddUser.class.getName()).log(Level.SEVERE, null, e);
            System.err.println("The connection to the database failed.");
        }

        // Try to generate the query.
        try {
            // The query to send.
            this.sql = "SELECT `login_username` FROM `login`";
            // Added security for the fields being sent to the database.
            this.psAuthenticate = this.con.prepareStatement(this.sql);
            // Send the query and get the results back.
            this.rs = this.psAuthenticate.executeQuery();

            String checkUsername = null;

            // Iterate over the result set.
            while (this.rs.next()) {
                checkUsername = this.rs.getString("login_username");
                if (checkUsername.equals(userForm.getUsername())) {
                    usernameTaken = true;
                }
            }
        } catch (Exception e) {
            Logger.getLogger(AddUser.class.getName()).log(Level.SEVERE, null, e);
            System.err.println("There was an issue with the query.");
        } finally {
            // Close psAuthenicate,  and the connection objects.
            DbUtils.close(this.rs, this.psAuthenticate, this.con);
        }
        return usernameTaken;
    }

    public boolean addToDatabase(AddUserForm userForm) {
        // Try to connect to the database.  
        try {
            this.con = dbConnection.databaseConnection();
        } catch (Exception e) {
            Logger.getLogger(AddUser.class.getName()).log(Level.SEVERE, null, e);
            System.err.println("The connection to the database failed.");
        }

        // Try to generate the query.
        try {
            // The query to send.
            this.sql = "INSERT INTO `customer`(`cus_first_name`, `cus_middle_initial`, `cus_last_name`, `cus_street`, `cus_city`, `cus_province`, `cus_postal_code`, `cus_phone`, `cus_email`) "
                    + "VALUES (?,?,?,?,?,?,?,?,?)";
            // Added security for the fields being sent to the database.
            this.psAuthenticate = this.con.prepareStatement(this.sql);
            this.psAuthenticate.setString(1, userForm.getFirstName());
            this.psAuthenticate.setString(2, userForm.getMiddleInitial());
            this.psAuthenticate.setString(3, userForm.getLastName());
            this.psAuthenticate.setString(4, userForm.getStreet());
            this.psAuthenticate.setString(5, userForm.getCity());
            this.psAuthenticate.setString(6, userForm.getProvince());
            this.psAuthenticate.setString(7, userForm.getPostalCode());
            this.psAuthenticate.setString(8, userForm.getPhoneNumber());
            this.psAuthenticate.setString(9, userForm.getEmail());
            // Run the query.
            this.psAuthenticate.executeUpdate();

            // The query to send.
            this.sql = "SELECT `cus_id` FROM `customer` ORDER BY `cus_id` DESC LIMIT 1";
            this.psAuthenticate = this.con.prepareStatement(this.sql);
            // Send the query and get the results back.
            this.rs = this.psAuthenticate.executeQuery();

            String id = null;

            // Iterate over the result set.
            while (this.rs.next()) {
                id = this.rs.getString("cus_id");
            }

            // The query to send.
            this.sql = "INSERT INTO `login`(`cus_id`, `login_username`, `login_password`) VALUES (?,?,?)";
            // Added security for the fields being sent to the database.
            this.psAuthenticate = this.con.prepareStatement(this.sql);
            this.psAuthenticate.setString(1, id);
            this.psAuthenticate.setString(2, userForm.getUsername());
            this.psAuthenticate.setString(3, userForm.getPassword());
            // Run the query.
            this.psAuthenticate.executeUpdate();

        } catch (Exception e) {
            Logger.getLogger(AddUser.class.getName()).log(Level.SEVERE, null, e);
            System.err.println("There was an issue with the query.");
        } finally {
            // Close psAuthenicate,  and the connection objects.
            DbUtils.close(this.rs, this.psAuthenticate, this.con);
        }
        return true;
    }
}
package business;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.AddUserModel;
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

    public boolean checkUsername(AddUserModel addUserObject) {
        // Try to connect to the database.  
        try {
            con = dbConnection.databaseConnection();
        } catch (Exception e) {
            Logger.getLogger(AddUser.class.getName()).log(Level.SEVERE, null, e);
            System.err.println("The connection to the database failed.");
        }

        // Try to generate the query.
        try {
            // The query to send.
            sql = "SELECT `login_username` FROM `login`";
            // Added security for the fields being sent to the database.
            psAuthenticate = con.prepareStatement(sql);
            // Send the query and get the results back.
            rs = psAuthenticate.executeQuery();

            String checkUsername = null;

            // Iterate over the result set.
            while (rs.next()) {
                checkUsername = rs.getString("login_username");
                if (checkUsername.equals(addUserObject.getUsername())) {
                    usernameTaken = true;
                }
            }
        } catch (Exception e) {
            Logger.getLogger(AddUser.class.getName()).log(Level.SEVERE, null, e);
            System.err.println("There was an issue with the query.");
        } finally {
            // Close psAuthenicate,  and the connection objects.
            DbUtils.close(rs, psAuthenticate, con);
        }
        return usernameTaken;
    }

    public boolean addToDatabase(AddUserModel addUserObject) {
        // Try to connect to the database.  
        try {
            con = dbConnection.databaseConnection();
        } catch (Exception e) {
            Logger.getLogger(AddUser.class.getName()).log(Level.SEVERE, null, e);
            System.err.println("The connection to the database failed.");
        }

        // Try to generate the query.
        try {
            // The query to send.
            sql = "INSERT INTO `customer`(`cus_first_name`, `cus_middle_initial`, `cus_last_name`, `cus_street`, `cus_city`, `cus_province`, `cus_postal_code`, `cus_phone`, `cus_email`) "
                    + "VALUES (?,?,?,?,?,?,?,?,?)";
            // Added security for the fields being sent to the database.  
            psAuthenticate = con.prepareStatement(sql);
            psAuthenticate.setString(1, addUserObject.getFirstName());
            psAuthenticate.setString(2, addUserObject.getMiddleInitial());
            psAuthenticate.setString(3, addUserObject.getLastName());
            psAuthenticate.setString(4, addUserObject.getStreet());
            psAuthenticate.setString(5, addUserObject.getCity());
            psAuthenticate.setString(6, addUserObject.getProvince());
            psAuthenticate.setString(7, addUserObject.getPostalCode());
            psAuthenticate.setString(8, addUserObject.getPhoneNumber());
            psAuthenticate.setString(9, addUserObject.getEmail());
            // Run the query.
            psAuthenticate.executeUpdate();

            // The query to send.
            sql = "SELECT `cus_id` FROM `customer` ORDER BY `cus_id` DESC LIMIT 1";
            psAuthenticate = con.prepareStatement(sql);
            // Send the query and get the results back.
            rs = psAuthenticate.executeQuery();

            int id = 0;

            // Iterate over the result set.
            while (rs.next()) {
                id = rs.getInt("cus_id");
            }

            // The query to send.
            sql = "INSERT INTO `login`(`cus_id`, `login_username`, `login_password`) VALUES (?,?,?)";
            // Added security for the fields being sent to the database.
            psAuthenticate = con.prepareStatement(sql);
            psAuthenticate.setInt(1, id);
            psAuthenticate.setString(2, addUserObject.getUsername());
            psAuthenticate.setString(3, addUserObject.getPassword());
            // Run the query.
            psAuthenticate.executeUpdate();           

        } catch (Exception e) {
            Logger.getLogger(AddUser.class.getName()).log(Level.SEVERE, null, e);
            System.err.println("There was an issue with the query.");
        } finally {
            // Close psAuthenicate,  and the connection objects.
            DbUtils.close(rs, psAuthenticate, con);
        }
        return true;
    }
}

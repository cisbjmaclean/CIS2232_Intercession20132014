package business;

import forms.AddUpdateCustomerForm;
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
public class AddCustomer {

    // The object used for each new connection.
    private DatabaseConnection dbConnection = new DatabaseConnection();
    // Used to allow for more security when sending data to a database.
    private PreparedStatement psAuthenticate;
    private String sql;
    // The connection object.
    private Connection con;
    private ResultSet rs = null;
    private boolean usernameTaken = false;
    
    public boolean checkUsername(AddUpdateCustomerForm customerForm) {
        // Try to connect to the database.  
        try {
            con = dbConnection.databaseConnection();
        } catch (Exception e) {
            Logger.getLogger(AddCustomer.class.getName()).log(Level.SEVERE, null, e);
            System.err.println("The connection to the database failed.");
        }

        // Try to generate the query.
        try {
            // The query to send.
            sql = "SELECT `cus_login_username` FROM `customer_login`";
            // Added security for the fields being sent to the database.
            psAuthenticate = con.prepareStatement(sql);
            // Send the query and get the results back.
            rs = psAuthenticate.executeQuery();

            String checkUsername = null;

            // Iterate over the result set.
            while (rs.next()) {
                checkUsername = rs.getString("cus_login_username");
                if (checkUsername.equals(customerForm.getUsername())) {
                    usernameTaken = true;
                }
            }
        } catch (Exception e) {
            Logger.getLogger(AddCustomer.class.getName()).log(Level.SEVERE, null, e);
            System.err.println("There was an issue with the query.");
        } finally {
            // Close psAuthenicate,  and the connection objects.
            DbUtils.close(rs, psAuthenticate, con);
        }
        return usernameTaken;
    }

    public boolean addCustomer (AddUpdateCustomerForm customerForm) throws Exception {
        // Try to connect to the database.  
        try {
            con = dbConnection.databaseConnection();
        } catch (Exception e) {
            Logger.getLogger(AddCustomer.class.getName()).log(Level.SEVERE, null, e);
            System.err.println("The connection to the database failed.");
        }

        // Try to generate the query.
        try {          
            // The query to send.
            sql = "INSERT INTO `customer`(`cus_first_name`, `cus_middle_initial`, `cus_last_name`, `cus_address`, `cus_city`, `cus_province`, `cus_postal_code`, `cus_phone`, `cus_email`) "
                    + "VALUES (?,?,?,?,?,?,?,?,?)";
            // Added security for the fields being sent to the database.
            psAuthenticate = con.prepareStatement(sql);
            psAuthenticate.setString(1, customerForm.getFirstName());
            psAuthenticate.setString(2, customerForm.getMiddleInitial());
            psAuthenticate.setString(3, customerForm.getLastName());
            psAuthenticate.setString(4, customerForm.getAddress());
            psAuthenticate.setString(5, customerForm.getCity());
            psAuthenticate.setString(6, customerForm.getProvince());
            psAuthenticate.setString(7, customerForm.getPostalCode());
            psAuthenticate.setString(8, customerForm.getPhoneNumber());
            psAuthenticate.setString(9, customerForm.getEmail());
            // Run the query.
            psAuthenticate.executeUpdate();

            // The query to send.
            sql = "SELECT `cus_id` FROM `customer` ORDER BY `cus_id` DESC LIMIT 1";
            psAuthenticate = con.prepareStatement(sql);
            // Send the query and get the results back.
            rs = psAuthenticate.executeQuery();

            String id = null;

            // Iterate over the result set.
            while (rs.next()) {
                id = rs.getString("cus_id");
            }

            // The query to send.
            sql = "INSERT INTO `customer_login`(`cus_id`, `cus_login_username`, `cus_login_password`) VALUES (?,?,?)";
            // Added security for the fields being sent to the database.
            psAuthenticate = con.prepareStatement(sql);
            psAuthenticate.setString(1, id);
            psAuthenticate.setString(2, customerForm.getUsername());
            psAuthenticate.setString(3, customerForm.getPassword());
            // Run the query.
            psAuthenticate.executeUpdate();

        } catch (Exception e) {
            Logger.getLogger(AddCustomer.class.getName()).log(Level.SEVERE, null, e);
             throw new Exception();
        } finally {
            // Close psAuthenicate,  and the connection objects.
            DbUtils.close(rs, psAuthenticate, con);
        }
        return true;
    }
}

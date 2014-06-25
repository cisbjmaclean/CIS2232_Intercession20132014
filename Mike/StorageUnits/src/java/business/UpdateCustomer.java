package business;

import forms.AddUpdateCustomerForm;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import util.DatabaseConnection;
import util.DbUtils;

/**
 *
 * @author Michael
 * @since Jun 17, 2014
 */
public class UpdateCustomer {

    // The object used for each new connection.
    private DatabaseConnection dbConnection = new DatabaseConnection();
    // Used to allow for more security when sending data to a database.
    private PreparedStatement psAuthenticate;
    private String sql;
    // The connection object.
    private Connection con;
    private ResultSet rs = null;
    private boolean usernameTaken = false;
    private AddUpdateCustomerForm customerForm;

    public UpdateCustomer(HttpServletRequest request) {
        customerForm = (AddUpdateCustomerForm) request.getAttribute("addUpdateCustomerForm");
    }

    public boolean updateCustomer() throws Exception {
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
            sql = "UPDATE `customer` SET `cus_first_name`= ?,`cus_middle_initial`= ?,`cus_last_name`= ?,`cus_address`= ?,"
                    + "`cus_city`= ?,`cus_province`= ?,`cus_postal_code`= ?,`cus_phone`= ?,`cus_email`= ? WHERE `cus_id` = ?";

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
            psAuthenticate.setInt(10, customerForm.getCustomerId());
            // Run the query.
            psAuthenticate.executeUpdate();


            // The query to send.
            sql = "UPDATE `customer_login` SET `cus_login_username`=?,`cus_login_password`=? WHERE `cus_id` = ?";
            // Added security for the fields being sent to the database.
            psAuthenticate = con.prepareStatement(sql);        
            psAuthenticate.setString(1, customerForm.getUsername());
            psAuthenticate.setString(2, customerForm.getPassword());
            psAuthenticate.setInt(3, customerForm.getCustomerId());
            // Run the query.
            psAuthenticate.executeUpdate();

        } catch (Exception e) {
            Logger.getLogger(AddCustomer.class.getName()).log(Level.SEVERE, null, e);
            System.err.println("There was an issue with the query.");
            throw new Exception();
        } finally {
            // Close psAuthenicate,  and the connection objects.
            DbUtils.close(psAuthenticate, con);
        }
        return true;
    }
}

package business;

import forms.AdminModifyCustomerForm;
import forms.CustomerForm;
import forms.LoginForm;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.DatabaseConnection;
import util.DbUtils;

/**
 * @author Michael
 * @since Jun 17, 2014
 *
 * This class is used to delete customers for the database.
 */
public class DeleteCustomer {

    /*
     * Remember to update customer and login classes.
     */
    // The object used for each new connection.
    private DatabaseConnection dbConnection = new DatabaseConnection();
    // Used to allow for more security when sending data to a database.
    private PreparedStatement psAuthenticate;
    private String sql;
    // The connection object.
    private Connection con;
    private ResultSet rs = null;

    /**
     * This method accepts parameters and then deletes a customer and their
     * login based on the values passed in.
     *
     * @param customerID
     * @param allCustomers
     * @param allLogins
     * @throws Exception
     */
    public void deleteCustomer(AdminModifyCustomerForm customerID, ArrayList<CustomerForm> allCustomers, ArrayList<LoginForm> allLogins) throws Exception {
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
            sql = "DELETE FROM `customer` WHERE `cus_id` = ? LIMIT 1";
            psAuthenticate = con.prepareStatement(sql);
            psAuthenticate.setInt(1, customerID.getCustomerID());
            // Send the query and get the results back.
            psAuthenticate.executeUpdate();

            sql = "DELETE FROM `customer_login` WHERE `cus_id` = ? LIMIT 1";
            psAuthenticate = con.prepareStatement(sql);
            psAuthenticate.setInt(1, customerID.getCustomerID());
            // Send the query and get the results back.
            psAuthenticate.executeUpdate();

        } catch (Exception e) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, e);
            // Used if there is a critical database error
            throw new Exception();
        } finally {
            // Close the result set, psAuthenicate,  and the connection objects.
            DbUtils.close(rs, psAuthenticate, con);
        }

        // Remove the customer from the ArrayList that will be used to update the session.
        for (int i = 0; i < allCustomers.size(); i++) {
            if (allCustomers.get(i).getCustomerID() == customerID.getCustomerID()) {
                allCustomers.remove(i);
            }
        }

        // Remove the login from the ArrayList that will be used to update the session.
        for (int i = 0; i < allLogins.size(); i++) {
            if (allLogins.get(i).getCustomerID() == customerID.getCustomerID()) {
                allLogins.remove(i);
            }
        }
    }
}

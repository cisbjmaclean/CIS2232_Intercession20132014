package business;

import forms.CustomerForm;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.DatabaseConnection;
import util.DbUtils;

/**
 *
 * @author Michael
 * @since Jun 10, 2014
 */
public class LoadCustomer {

    // The object used for each new connection.
    private DatabaseConnection dbConnection = new DatabaseConnection();
    // Used to allow for more security when sending data to a database.
    private PreparedStatement psAuthenticate;
    private String sql;
    // The connection object.
    private Connection con;
    private ResultSet rs = null;
    private CustomerForm customer;

    public CustomerForm setCustomerInformation(int customerID) throws Exception {
        try {
            con = dbConnection.databaseConnection();
        } catch (Exception e) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, e);
            System.err.println("The connection to the database failed.");
        }

        try {
            // The query to send.
            sql = "SELECT * FROM `customer` WHERE `cus_id` = ?";
            psAuthenticate = con.prepareStatement(sql);
            psAuthenticate.setInt(1, customerID);
            // Send the query and get the results back.
            rs = psAuthenticate.executeQuery();
            customer = new CustomerForm();
            while (rs.next()) {
                customer.setCustomerId(rs.getInt("cus_id"));
                customer.setEmail(rs.getString("cus_email"));
                customer.setFirstName(rs.getString("cus_first_name"));
                customer.setMiddleInitial(rs.getString("cus_middle_initial"));
                customer.setLastName(rs.getString("cus_last_name"));
                customer.setAddress(rs.getString("cus_address"));
                customer.setCity(rs.getString("cus_city"));
                customer.setProvince(rs.getString("cus_province"));
                customer.setPostalCode(rs.getString("cus_postal_code"));
                customer.setPhoneNumber(rs.getString("cus_phone"));
            }

        } catch (Exception e) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, e);
            throw new Exception();
        } finally {
            // Close the result set, psAuthenicate,  and the connection objects.
            DbUtils.close(rs, psAuthenticate, con);
        }
        return customer;
    }
}

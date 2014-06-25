package business;

import forms.CustomerForm;
import forms.LoginForm;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import util.DatabaseConnection;
import util.DbUtils;

/**
 *
 * @author Michael
 * @since Jun 16, 2014
 */
public class LoadCustomers {

    // The object used for each new connection.
    private DatabaseConnection dbConnection = new DatabaseConnection();
    private ArrayList<CustomerForm> loadCustomers;
    private ArrayList<LoginForm> loadLogins;
    // Used to allow for more security when sending data to a database.
    private PreparedStatement psAuthenticate;
    private String sql;
    // The connection object.
    private Connection con;
    private ResultSet rs = null;
    private CustomerForm customer;
    private LoginForm login;

    public ArrayList loadCustomers(HttpServletRequest request) {
        try {
            con = dbConnection.databaseConnection();
        } catch (Exception e) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, e);
            System.err.println("The connection to the database failed.");
        }

        try {
            loadCustomers = new ArrayList();
            // The query to send.
            sql = "SELECT * FROM `customer`";
            psAuthenticate = con.prepareStatement(sql);
            // Send the query and get the results back.
            rs = psAuthenticate.executeQuery();
            while (rs.next()) {
                customer = new CustomerForm();
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
                loadCustomers.add(customer);
            }
        } catch (Exception e) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, e);
            System.err.println("There was an issue with the query.");
        } finally {
            // Close the result set, psAuthenicate,  and the connection objects.
            DbUtils.close(rs, psAuthenticate, con);
        }
        return loadCustomers;
    }

    public ArrayList loadLogins(HttpServletRequest request) throws Exception {

        try {
            con = dbConnection.databaseConnection();
        } catch (Exception e) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, e);
            System.err.println("The connection to the database failed.");
        }

        try {
            loadLogins = new ArrayList();
            sql = "SELECT * FROM `customer_login`";
            psAuthenticate = con.prepareStatement(sql);
            // Send the query and get the results back.
            rs = psAuthenticate.executeQuery();
            while (rs.next()) {
                login = new LoginForm();
                login.setCustomerId(rs.getInt("cus_id"));
                login.setUsername(rs.getString("cus_login_username"));
                login.setPassword(rs.getString("cus_login_password"));
                loadLogins.add(login);
            }
        } catch (Exception e) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, e);
            throw new Exception();
        } finally {
            // Close the result set, psAuthenicate,  and the connection objects.
            DbUtils.close(rs, psAuthenticate, con);
        }
        return loadLogins;
    }

    public ArrayList<CustomerForm> getLoadCustomers() {
        return loadCustomers;
    }

    public void setLoadCustomers(ArrayList<CustomerForm> loadCustomers) {
        this.loadCustomers = loadCustomers;
    }

    public ArrayList<LoginForm> getLoadLogins() {
        return loadLogins;
    }

    public void setLoadLogins(ArrayList<LoginForm> loadLogins) {
        this.loadLogins = loadLogins;
    }
}

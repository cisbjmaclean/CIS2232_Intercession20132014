package business;

import forms.UserForm;
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
public class LoadUsers {

    // The object used for each new connection.
    private DatabaseConnection dbConnection = new DatabaseConnection();
    private static ArrayList<UserForm> loadUsers;
    // Used to allow for more security when sending data to a database.
    private PreparedStatement psAuthenticate;
    private String sql;
    // The connection object.
    private Connection con;
    private ResultSet rs = null;
    private UserForm user;

    public ArrayList LoadUsers(HttpServletRequest request) {
        try {
            con = dbConnection.databaseConnection();
        } catch (Exception e) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, e);
            System.err.println("The connection to the database failed.");
        }

        try {
            loadUsers = new ArrayList();
            // The query to send.
            sql = "SELECT * FROM `customer`";
            psAuthenticate = con.prepareStatement(sql);
            // Send the query and get the results back.
            rs = psAuthenticate.executeQuery();
            user = new UserForm();
            while (rs.next()) {
                user.setCustomerId(rs.getInt("cus_id"));
                user.setEmail(rs.getString("cus_email"));
                user.setFirstName(rs.getString("cus_first_name"));
                user.setMiddleInitial(rs.getString("cus_middle_initial"));
                user.setLastName(rs.getString("cus_last_name"));
                user.setAddress(rs.getString("cus_address"));
                user.setCity(rs.getString("cus_city"));
                user.setProvince(rs.getString("cus_province"));
                user.setPostalCode(rs.getString("cus_postal_code"));
                user.setPhoneNumber(rs.getString("cus_phone"));
                loadUsers.add(user);
            }
        } catch (Exception e) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, e);
            System.err.println("There was an issue with the query.");
        } finally {
            // Close the result set, psAuthenicate,  and the connection objects.
            DbUtils.close(rs, psAuthenticate, con);
        }
        return loadUsers;
    }
}

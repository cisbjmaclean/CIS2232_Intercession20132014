package business;

import forms.ReleaseUnitForm;
import forms.StorageUnitForm;
import forms.UserForm;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import util.DatabaseConnection;
import util.DbUtils;

/**
 *
 * @author Michael
 * @since Jun 12, 2014
 */
public class ReleaseUnit {

    // The object used for each new connection.
    private DatabaseConnection dbConnection = new DatabaseConnection();
    // Used to allow for more security when sending data to a database.
    private PreparedStatement psAuthenticate;
    private String sql;
    // The connection object.
    private Connection con;
    private ArrayList<StorageUnitForm> units;
    private UserForm user;

    public void releaseUnit(ReleaseUnitForm release, HttpServletRequest request) {
        // Try to connect to the database.  
        try {
            con = dbConnection.databaseConnection();
        } catch (Exception e) {
            Logger.getLogger(AddUser.class.getName()).log(Level.SEVERE, null, e);
            System.err.println("The connection to the database failed.");
        }

        // Try to generate the query.
        try {
            units = (ArrayList<StorageUnitForm>) request.getSession().getAttribute("storageUnit");
            user = (UserForm) request.getSession().getAttribute("user");

            // The query to send.
            sql = "DELETE FROM `customer_unit` WHERE `unit_id` = ? AND `cus_id` = ?";
            // Added security for the fields being sent to the database.
            psAuthenticate = con.prepareStatement(sql);
            psAuthenticate.setInt(1, release.getUnitId());
            psAuthenticate.setInt(2, user.getCustomerId());
            // Run the query.
            psAuthenticate.executeUpdate();
        } catch (Exception e) {
            Logger.getLogger(AddUser.class.getName()).log(Level.SEVERE, null, e);
            System.err.println("There was an issue with the query.");
        } finally {
            // Close psAuthenicate,  and the connection objects.
            DbUtils.close(psAuthenticate, con);
        }
        for (StorageUnitForm unit : units) {
            if (unit.getUnitId() == release.getUnitId()) {
                unit.setCustomerId(0);
            }
        }
    }
}

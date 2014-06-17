package business;

import forms.StorageUnitForm;
import forms.LoginForm;
import forms.ReleaseUnitForm;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import util.DatabaseConnection;
import util.DbUtils;
import util.SortUnits;

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
    //private ArrayList<StorageUnitForm> storageUnits;
    private LoginForm user;
     private ReleaseUnitForm releaseUnit;

    public void releaseUnit(HttpServletRequest request) {
        // Try to connect to the database.  
        try {
            con = dbConnection.databaseConnection();
        } catch (Exception e) {
            Logger.getLogger(AddUser.class.getName()).log(Level.SEVERE, null, e);
            System.err.println("The connection to the database failed.");
        }

        // Try to generate the query.
        try {        
            user = (LoginForm) request.getSession().getAttribute("user");
            releaseUnit = (ReleaseUnitForm) request.getAttribute("releaseUnitForm");
            // The query to send.
            sql = "DELETE FROM `customer_unit` WHERE `unit_id` = ? AND `cus_id` = ?";
            // Added security for the fields being sent to the database.
            psAuthenticate = con.prepareStatement(sql);
            psAuthenticate.setInt(1, releaseUnit.getUnitId());
            psAuthenticate.setInt(2, user.getCustomerId());
            // Run the query.
            psAuthenticate.executeUpdate();
            
            // The query to send.
            sql = "UPDATE `unit` SET `unit_avalibility`= ?,`unit_date_from`= ?,`unit_date_to`= ? WHERE `unit_id` = ?";
            // Added security for the fields being sent to the database.
            psAuthenticate = con.prepareStatement(sql);
            psAuthenticate.setInt(1, 1);
            psAuthenticate.setString(2, "");
            psAuthenticate.setString(3, "");
            psAuthenticate.setInt(4, releaseUnit.getUnitId());
            // Run the query.
            psAuthenticate.executeUpdate();
            
        } catch (Exception e) {
            Logger.getLogger(AddUser.class.getName()).log(Level.SEVERE, null, e);
            System.err.println("There was an issue with the query.");
        } finally {
            // Close psAuthenicate,  and the connection objects.
            DbUtils.close(psAuthenticate, con);
        }
            for (StorageUnitForm unit : LoadStorageUnits.getStorageUnits()) {
            if (unit.getUnitId() == releaseUnit.getUnitId()) {
                unit.setCustomerId(0);
                unit.setUnitAvalibility("1");
                unit.setUnitDateTo("");
                unit.setUnitDateFrom("");
            }
        }
        SortUnits.compare(LoadStorageUnits.getStorageUnits());
    }
}

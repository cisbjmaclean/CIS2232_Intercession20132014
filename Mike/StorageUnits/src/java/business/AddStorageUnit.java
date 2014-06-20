package business;

import forms.StorageUnitForm;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Collections;
import java.util.Comparator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import util.DatabaseConnection;
import util.DbUtils;
import util.SortUnits;

/**
 *
 * @author Michael
 * @since Jun 19, 2014
 */
public class AddStorageUnit {

    // The object used for each new connection.
    private DatabaseConnection dbConnection = new DatabaseConnection();
    // Used to allow for more security when sending data to a database.
    private PreparedStatement psAuthenticate;
    private String sql;
    // The connection object.
    private Connection con;
    private StorageUnitForm unit;

    public void addStorageUnit(HttpServletRequest request) {
        // Try to connect to the database.  
        try {
            con = dbConnection.databaseConnection();
        } catch (Exception e) {
            Logger.getLogger(AddCustomer.class.getName()).log(Level.SEVERE, null, e);
            System.err.println("The connection to the database failed.");
        }

        // Try to generate the query.
        try {
            unit = (StorageUnitForm) request.getAttribute("storageUnitForm");
            // The query to send.
            sql = "INSERT INTO `storage_unit`(`storage_unit_type`, `storage_unit_dimensions`, `storage_unit_availability`, `storage_unit_date_from`, `storage_unit_date_to`) "
                    + "VALUES (?,?,?,?,?)";
            // Added security for the fields being sent to the database.
            psAuthenticate = con.prepareStatement(sql);
            psAuthenticate.setString(1, unit.getUnitType());
            psAuthenticate.setString(2, unit.getUnitDimensions());
            psAuthenticate.setInt(3, unit.getUnitAvailability());
            psAuthenticate.setString(4, "");
            psAuthenticate.setString(5, "");

            // Run the query.
            psAuthenticate.executeUpdate();

        } catch (Exception e) {
            Logger.getLogger(AddCustomer.class.getName()).log(Level.SEVERE, null, e);
            System.err.println("There was an issue with the query.");
        } finally {
            // Close psAuthenicate,  and the connection objects.
            DbUtils.close(psAuthenticate, con);
        }
         Collections.sort(LoadStorageUnits.getStorageUnits(), new SortUnits());
    }
}

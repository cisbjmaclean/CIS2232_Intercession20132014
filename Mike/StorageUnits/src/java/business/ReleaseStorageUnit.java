package business;

import forms.ReleaseStorageUnitForm;
import forms.StorageUnitForm;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import util.DatabaseConnection;
import util.DbUtils;
import util.SortStorageUnits;

/**
 *
 * @author Michael
 * @since Jun 12, 2014
 */
public class ReleaseStorageUnit {

    // The object used for each new connection.
    private DatabaseConnection dbConnection = new DatabaseConnection();
    // Used to allow for more security when sending data to a database.
    private PreparedStatement psAuthenticate;
    private String sql;
    // The connection object.
    private Connection con;
    private ReleaseStorageUnitForm releaseUnit;
    private ArrayList<StorageUnitForm> storageUnits;

    public void releaseUnit(HttpServletRequest request) {
        // Try to connect to the database.  
        try {
            con = dbConnection.databaseConnection();
        } catch (Exception e) {
            Logger.getLogger(AddCustomer.class.getName()).log(Level.SEVERE, null, e);
            System.err.println("The connection to the database failed.");
        }

        // Try to generate the query.
        try {
            releaseUnit = (ReleaseStorageUnitForm) request.getAttribute("releaseStorageUnitForm");
            // The query to send.
            sql = "DELETE FROM `customer_storage_unit` WHERE `storage_unit_id` = ?";
            // Added security for the fields being sent to the database.
            psAuthenticate = con.prepareStatement(sql);
            psAuthenticate.setInt(1, releaseUnit.getUnitId());
            // Run the query.
            psAuthenticate.executeUpdate();

            // The query to send.
            sql = "UPDATE `storage_unit` SET `storage_unit_availability`= ?,`storage_unit_date_from`= ?,`storage_unit_date_to`= ? WHERE `storage_unit_id` = ?";
            // Added security for the fields being sent to the database.
            psAuthenticate = con.prepareStatement(sql);
            psAuthenticate.setInt(1, 1);
            psAuthenticate.setString(2, "");
            psAuthenticate.setString(3, "");
            psAuthenticate.setInt(4, releaseUnit.getUnitId());
            // Run the query.
            psAuthenticate.executeUpdate();

        } catch (Exception e) {
            Logger.getLogger(AddCustomer.class.getName()).log(Level.SEVERE, null, e);
            System.err.println("There was an issue with the query.");
        } finally {
            // Close psAuthenicate,  and the connection objects.
            DbUtils.close(psAuthenticate, con);
        }
        storageUnits = (ArrayList<StorageUnitForm>) request.getSession().getAttribute("storageUnits");
        setUnit(storageUnits);
        SortStorageUnits.sortDefault(request, storageUnits);  
    }

    public void setUnit(ArrayList<StorageUnitForm> storageUnits) {              
        for (StorageUnitForm storageUnit : storageUnits)  {
            if (storageUnit.getUnitId() == releaseUnit.getUnitId()) {
                storageUnit.setCustomerId(0);
                storageUnit.setUnitAvailability(1);
                storageUnit.setUnitDateTo("");
                storageUnit.setUnitDateFrom("");
            }
        }
    }
}

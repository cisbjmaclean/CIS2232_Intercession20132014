package business;


import forms.ReleaseStorageUnitForm;
import forms.StorageUnitForm;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.DatabaseConnection;
import util.DbUtils;


/**
 *
 * @author Michael
 * @since Jun 12, 2014
 * 
 * This class is used to release storage units.  It is used by both the admins and customers.
 */
public class ReleaseStorageUnit {

    // The object used for each new connection.
    private DatabaseConnection dbConnection = new DatabaseConnection();
    // Used to allow for more security when sending data to a database.
    private PreparedStatement psAuthenticate;
    private String sql;
    // The connection object.
    private Connection con;

    /**
     * This method accepts parameters then uses them to release ownership of a
     * specific storage unit.
     *
     * @param releaseUnitForm
     * @param storageUnits
     * @throws Exception
     */
    public void releaseUnit(ReleaseStorageUnitForm releaseUnitForm, ArrayList<StorageUnitForm> storageUnits) throws Exception {
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
            sql = "DELETE FROM `customer_storage_unit` WHERE `storage_unit_id` = ?";
            // Added security for the fields being sent to the database.
            psAuthenticate = con.prepareStatement(sql);
            psAuthenticate.setInt(1, releaseUnitForm.getUnitID());
            // Run the query.
            psAuthenticate.executeUpdate();

            // The query to send.
            sql = "UPDATE `storage_unit` SET `storage_unit_availability`= ?,`storage_unit_date_from`= ?,`storage_unit_date_to`= ?,`storage_unit_in_use`= ? WHERE `storage_unit_id` = ?";
            // Added security for the fields being sent to the database.
            psAuthenticate = con.prepareStatement(sql);
            psAuthenticate.setInt(1, 1);
            psAuthenticate.setString(2, "--/--/--");
            psAuthenticate.setString(3, "--/--/--");
            psAuthenticate.setInt(4, 0);
            psAuthenticate.setInt(5, releaseUnitForm.getUnitID());
            // Run the query.
            psAuthenticate.executeUpdate();

        } catch (Exception e) {
            Logger.getLogger(AddCustomer.class.getName()).log(Level.SEVERE, null, e);
            // Thrown if there is a critical error with the database.
            throw new Exception();
        } finally {
            // Close psAuthenicate,  and the connection objects.
            DbUtils.close(psAuthenticate, con);
        }       
        setUnit(releaseUnitForm, storageUnits);  
    }

    /** 
     * This method updates an ArrayList that is used to update the session.  
     * Passing the initial storage units ArrayList that is in was breaking on the back button.
     * 
     * @param releaseUnitForm
     * @param storageUnits 
     */
    public void setUnit(ReleaseStorageUnitForm releaseUnitForm, ArrayList<StorageUnitForm> storageUnits) {              
        for (StorageUnitForm storageUnit : storageUnits)  {
            if (storageUnit.getUnitID() == releaseUnitForm.getUnitID()) {
                storageUnit.setCustomerId(0);
                storageUnit.setUnitAvailability(1);
                storageUnit.setUnitDateTo("--/--/--");
                storageUnit.setUnitDateFrom("--/--/--");
                storageUnit.setUnitInUse(0);
            }
        }
    }
}

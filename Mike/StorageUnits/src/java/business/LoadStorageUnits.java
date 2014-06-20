package business;

import forms.StorageUnitForm;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import util.DatabaseConnection;
import util.DbUtils;
import util.SortUnits;

/**
 *
 * @author Michael Fesser
 */
public class LoadStorageUnits {

    // The object used for each new connection.
    private DatabaseConnection dbConnection = new DatabaseConnection();
    private static ArrayList<StorageUnitForm> storageUnits;
    // Used to allow for more security when sending data to a database.
    private PreparedStatement psAuthenticate;
    private String sql;
    // The connection object.
    private Connection con;
    private ResultSet rs = null;
    private StorageUnitForm unit;
    private int customerId = 0;

    /**
     * This method retrieves data from the database.
     *
     * @param request
     * @return
     */
    public ArrayList loadStorageUnits(HttpServletRequest request) {

        // Try to connect to the database.
        try {
            con = dbConnection.databaseConnection();
        } catch (Exception e) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, e);
            System.err.println("The connection to the database failed.");
        }

        // Try to generate the query.
        try {
            storageUnits = new ArrayList();
            // The query to send.
            sql = "SELECT `storage_unit`.`storage_unit_id`, `storage_unit`.`storage_unit_type`, `storage_unit`.`storage_unit_dimensions`, "
                    + "`storage_unit`.`storage_unit_availability`, `storage_unit`.`storage_unit_date_from`, `storage_unit`.`storage_unit_date_to`,"
                    + " `customer_storage_unit`.`cus_id` FROM `storage_unit` LEFT OUTER JOIN `customer_storage_unit` "
                    + "ON `storage_unit`.`storage_unit_id` = `customer_storage_unit`.`storage_unit_id`";
            psAuthenticate = con.prepareStatement(sql);
            // Send the query and get the results back.
            rs = psAuthenticate.executeQuery();
            // Iterate over the result set.
            while (rs.next()) {
                unit = new StorageUnitForm();
                unit.setUnitId(rs.getInt("storage_unit_id"));
                unit.setUnitType(rs.getString("storage_unit_type"));
                unit.setUnitDimensions(rs.getString("storage_unit_dimensions"));
                unit.setUnitAvailability(rs.getInt("storage_unit_availability"));
                unit.setUnitDateFrom(rs.getString("storage_unit_date_from"));
                unit.setUnitDateTo(rs.getString("storage_unit_date_to"));
                unit.setCustomerId(rs.getInt("cus_id"));
                storageUnits.add(unit);
                customerId = 0;
            }
        } catch (Exception e) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, e);
            System.err.println("There was an issue with the query.");
        } finally {
            // Close the result set, psAuthenicate,  and the connection objects.
            DbUtils.close(rs, psAuthenticate, con);
        }
        Collections.sort(storageUnits, new SortUnits());
        return storageUnits;
    }

    public static ArrayList<StorageUnitForm> getStorageUnits() {
        return storageUnits;
    }

    public static void setStorageUnits(ArrayList<StorageUnitForm> storageUnits) {
        LoadStorageUnits.storageUnits = storageUnits;
    }
}

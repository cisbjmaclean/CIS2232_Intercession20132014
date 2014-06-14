package business;

import forms.StorageUnitForm;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
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
    // Used to allow for more security when sending data to a database.
    private static ArrayList<StorageUnitForm> storageUnits = new ArrayList();
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
            // The query to send.
            sql = "SELECT `unit`.`unit_id`, `unit`.`unit_type`, `unit`.`unit_dimensions`, `unit`.`unit_avalibility`, "
                    + "`unit`.`unit_date_from`, `unit`.`unit_date_to`, `customer_unit`.`cus_id` FROM `unit` LEFT OUTER JOIN "
                    + "`customer_unit` ON `unit`.`unit_id` = `customer_unit`.`unit_id`";
            psAuthenticate = con.prepareStatement(sql);
            // Send the query and get the results back.
            rs = psAuthenticate.executeQuery();
            // Iterate over the result set.
            while (rs.next()) {
                unit = new StorageUnitForm();
                unit.setUnitId(rs.getInt("unit_id"));
                unit.setUnitType(rs.getString("unit_type"));
                unit.setUnitDimensions(rs.getString("unit_dimensions"));
                unit.setUnitAvalibility(rs.getString("unit_avalibility"));
                unit.setUnitDateFrom(rs.getString("unit_date_from"));
                unit.setUnitDateTo(rs.getString("unit_date_to"));
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
        SortUnits.compare(storageUnits);
        return storageUnits;
    }

    public static ArrayList<StorageUnitForm> getStorageUnits() {
        return storageUnits;
    }

    public static void setStorageUnits(ArrayList<StorageUnitForm> storageUnits) {
        LoadStorageUnits.storageUnits = storageUnits;
    }
}

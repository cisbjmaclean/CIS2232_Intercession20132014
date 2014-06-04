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

/**
 *
 * @author Michael Fesser
 */
public class LoadStorageUnits {

    // The object used for each new connection.
    private DatabaseConnection dbConnection = new DatabaseConnection();
    // Used to allow for more security when sending data to a database.
    private ArrayList<StorageUnitForm> storageUnits = new ArrayList();
    private PreparedStatement psAuthenticate;
    private String sql;
    // The connection object.
    private Connection con;
    private ResultSet rs = null;

    /**
     * This method retrieves data from the database.
     *
     * @param request
     */
    public void loadStorageUnits(HttpServletRequest request) {

        // Try to connect to the database.
        try {
            this.con = dbConnection.databaseConnection();
        } catch (Exception e) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, e);
            System.err.println("The connection to the database failed.");
        }

        // Try to generate the query.
        try {
            // The query to send.
            this.sql = "SELECT * FROM `unit`";
            this.psAuthenticate = this.con.prepareStatement(this.sql);
            // Send the query and get the results back.
            this.rs = this.psAuthenticate.executeQuery();

            int unitId;
            String unitType;
            String unitDimensions;
            String unitAvalibility;
            String unitDateFrom;
            String unitDateTo;
            StorageUnitForm unit;

            // Iterate over the result set.
            while (this.rs.next()) {
                unitId = this.rs.getInt("unit_id");
                unitType = this.rs.getString("unit_type");
                unitDimensions = this.rs.getString("unit_dimensions");
                unitAvalibility = this.rs.getString("unit_avalibility");
                unitDateFrom = this.rs.getString("unit_date_from");
                unitDateTo = this.rs.getString("unit_date_to");
                unit = new StorageUnitForm(unitId, unitType, unitDimensions, unitAvalibility, unitDateFrom, unitDateTo);
                storageUnits.add(unit);
            }
        } catch (Exception e) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, e);
            System.err.println("There was an issue with the query.");
        } finally {
            // Close the result set, psAuthenicate,  and the connection objects.
            DbUtils.close(this.rs, this.psAuthenticate, this.con);
        }
    }

    public ArrayList<StorageUnitForm> getStorageUnits() {
        return storageUnits;
    }

}

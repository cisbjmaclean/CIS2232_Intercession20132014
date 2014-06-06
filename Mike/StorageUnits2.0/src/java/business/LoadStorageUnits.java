package business;

import models.StorageUnitModel;
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
    private ArrayList<StorageUnitModel> storageUnits = new ArrayList();
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
            sql = "SELECT * FROM `unit`";
            psAuthenticate = con.prepareStatement(sql);
            // Send the query and get the results back.
            rs = psAuthenticate.executeQuery();

            int unitId;
            String unitType;
            String unitDimensions;
            String unitAvalibility;
            String unitDateFrom;
            String unitDateTo;
            StorageUnitModel unit;

            // Iterate over the result set.
            while (rs.next()) {
                unitId = rs.getInt("unit_id");
                unitType = rs.getString("unit_type");
                unitDimensions = rs.getString("unit_dimensions");
                unitAvalibility = rs.getString("unit_avalibility");
                unitDateFrom = rs.getString("unit_date_from");
                unitDateTo = rs.getString("unit_date_to");
                unit = new StorageUnitModel(unitId, unitType, unitDimensions, unitAvalibility, unitDateFrom, unitDateTo);
                storageUnits.add(unit);
            }
        } catch (Exception e) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, e);
            System.err.println("There was an issue with the query.");
        } finally {
            // Close the result set, psAuthenicate,  and the connection objects.
            DbUtils.close(rs, psAuthenticate, con);
        }
        return storageUnits;
    }
}

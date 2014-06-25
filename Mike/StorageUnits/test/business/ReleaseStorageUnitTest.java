package business;

import forms.ReleaseStorageUnitForm;
import forms.StorageUnitForm;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import util.DatabaseConnection;
import util.DbUtils;

/**
 *
 * @author Michael Fesser
 */
public class ReleaseStorageUnitTest {

    // The object used for each new connection.
    private DatabaseConnection dbConnection = new DatabaseConnection();
    // Used to allow for more security when sending data to a database.
    private PreparedStatement psAuthenticate;
    private String sql;
    private ResultSet rs = null;
    // The connection object.
    private Connection con;
    private ReleaseStorageUnitForm releaseUnitForm;
    private ArrayList<StorageUnitForm> storageUnits;
    private ReleaseStorageUnit instance;
    private StorageUnitForm unit;
    private int customerId;

    public ReleaseStorageUnitTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        try {
            storageUnits = new ArrayList();
            // Try to connect to the database.
            try {
                con = dbConnection.databaseConnection();
            } catch (Exception e) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, e);
                System.err.println("The connection to the database failed.");
            }

            // The query to send.
            sql = "SELECT `storage_unit`.`storage_unit_id`, `storage_unit`.`storage_unit_type`, `storage_unit`.`storage_unit_dimensions`, "
                    + "`storage_unit`.`storage_unit_availability`, `storage_unit`.`storage_unit_date_from`, `storage_unit`.`storage_unit_date_to`,"
                    + " `storage_unit`.`storage_unit_in_use`, `customer_storage_unit`.`cus_id` FROM `storage_unit` LEFT OUTER JOIN `customer_storage_unit` "
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
                unit.setUnitInUse(rs.getInt("storage_unit_in_use"));
                unit.setCustomerId(rs.getInt("cus_id"));
                storageUnits.add(unit);
            }
        } catch (Exception e) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, e);
            System.err.println("There was an issue with the query.");
        } finally {
            // Close the result set, psAuthenicate,  and the connection objects.
            DbUtils.close(rs, psAuthenticate, con);
        }
        releaseUnitForm = new ReleaseStorageUnitForm();
        releaseUnitForm.setUnitId(1);
    }

    @After
    public void tearDown() {

        // Try to connect to the database.
        try {
            con = dbConnection.databaseConnection();
        } catch (Exception e) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, e);
            System.err.println("The connection to the database failed.");
        }

        // Try to generate the query.
        try {
            con = dbConnection.databaseConnection();
        } catch (Exception e) {
            Logger.getLogger(AddCustomer.class.getName()).log(Level.SEVERE, null, e);
            System.err.println("The connection to the database failed.");
        }

        // Try to generate the query.
        try {
            sql = "INSERT INTO `customer_storage_unit`(`storage_unit_id`, `cus_id`) VALUES (?,?)";
            // Added security for the fields being sent to the database.
            psAuthenticate = con.prepareStatement(sql);
            psAuthenticate.setInt(1, 1);
            psAuthenticate.setInt(2, 1);
            // Run the query.
            psAuthenticate.executeUpdate();

            // The query to send.
            sql = "UPDATE `storage_unit` SET `storage_unit_availability`= ?,`storage_unit_date_from`= ?,`storage_unit_date_to`= ?,`storage_unit_in_use`= ? WHERE `storage_unit_id` = ?";
            // Added security for the fields being sent to the database.
            psAuthenticate = con.prepareStatement(sql);
            psAuthenticate.setInt(1, 0);
            psAuthenticate.setString(2, "06/23/2014");
            psAuthenticate.setString(3, "06/24/2014");
            psAuthenticate.setInt(4, 0);
            psAuthenticate.setInt(5, 1);
            // Run the query.
            psAuthenticate.executeUpdate();

        } catch (Exception e) {
            Logger.getLogger(AddCustomer.class.getName()).log(Level.SEVERE, null, e);
            System.err.println("There was an issue with the query.");
        } finally {
            // Close psAuthenicate,  and the connection objects.
            DbUtils.close(psAuthenticate, con);
        }
    }

    /**
     * Test of releaseUnit method, of class ReleaseStorageUnit.
     */
    @Test
    public void testReleaseUnit() {
        System.out.println("releaseUnit");
        instance = new ReleaseStorageUnit();
        int result = 0;
        int expResult = 1;

        System.out.println(storageUnits.size());
        try {
            instance.releaseUnit(releaseUnitForm, storageUnits);
        } catch (Exception ex) {
            Logger.getLogger(ReleaseStorageUnitTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        for (StorageUnitForm storageUnit : storageUnits) {
            if (storageUnit.getUnitId() == releaseUnitForm.getUnitId()) {
                result = storageUnit.getUnitAvailability();
            }
        }
        assertEquals(expResult, result);
    }

    public void releaseUnit(ReleaseStorageUnitForm releaseUnitForm, ArrayList<StorageUnitForm> storageUnits) {
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
            psAuthenticate.setInt(1, releaseUnitForm.getUnitId());
            // Run the query.
            psAuthenticate.executeUpdate();

            // The query to send.
            sql = "UPDATE `storage_unit` SET `storage_unit_availability`= ?,`storage_unit_date_from`= ?,`storage_unit_date_to`= ?,`storage_unit_in_use`= ? WHERE `storage_unit_id` = ?";
            // Added security for the fields being sent to the database.
            psAuthenticate = con.prepareStatement(sql);
            psAuthenticate.setInt(1, 1);
            psAuthenticate.setString(2, "");
            psAuthenticate.setString(3, "");
            psAuthenticate.setInt(4, 0);
            psAuthenticate.setInt(5, releaseUnitForm.getUnitId());
            // Run the query.
            psAuthenticate.executeUpdate();

        } catch (Exception e) {
            Logger.getLogger(AddCustomer.class.getName()).log(Level.SEVERE, null, e);
            System.err.println("There was an issue with the query.");
        } finally {
            // Close psAuthenicate,  and the connection objects.
            DbUtils.close(psAuthenticate, con);
        }
        setUnit(releaseUnitForm, storageUnits);
    }

    public void setUnit(ReleaseStorageUnitForm releaseUnitForm, ArrayList<StorageUnitForm> storageUnits) {
        for (StorageUnitForm storageUnit : storageUnits) {
            if (storageUnit.getUnitId() == releaseUnitForm.getUnitId()) {
                storageUnit.setCustomerId(0);
                storageUnit.setUnitAvailability(1);
                storageUnit.setUnitDateTo("");
                storageUnit.setUnitDateFrom("");
                storageUnit.setUnitInUse(0);
            }
        }
    }
}

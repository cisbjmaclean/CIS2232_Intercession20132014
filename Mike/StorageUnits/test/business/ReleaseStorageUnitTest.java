/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package business;

import forms.ReleaseStorageUnitForm;
import forms.StorageUnitForm;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
    // The connection object.
    private Connection con;
    private ReleaseStorageUnitForm releaseUnitForm;
    private ArrayList<StorageUnitForm> storageUnits;
    private ReleaseStorageUnit instance;
    
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
        releaseUnitForm = new ReleaseStorageUnitForm();
        storageUnits = new ArrayList<>();
        instance = new ReleaseStorageUnit();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of releaseUnit method, of class ReleaseStorageUnit.
     */
    @Test
    public void testReleaseUnit() {
        System.out.println("releaseUnit");     
        instance = new ReleaseStorageUnit();
        instance.releaseUnit(releaseUnitForm, storageUnits);
        
    }

    /**
     * Test of setUnit method, of class ReleaseStorageUnit.
     */
    @Test
    public void testSetUnit() {
        System.out.println("setUnit");       
        instance.setUnit(releaseUnitForm, storageUnits);
        
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
            psAuthenticate.setInt(4, releaseUnitForm.getUnitId());
            psAuthenticate.setInt(5, 0);
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
        for (StorageUnitForm storageUnit : storageUnits)  {
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


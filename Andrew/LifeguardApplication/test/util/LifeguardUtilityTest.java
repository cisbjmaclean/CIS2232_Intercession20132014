/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Andrew
 */
public class LifeguardUtilityTest {
    
    public LifeguardUtilityTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    //Method taken and modified from BJ and Roger's Registration Board application
    private int getNumberOfLifeguards() {
        PreparedStatement ps = null;
        String sql = null;
        Connection conn = null;
        int count = 0;
        try {
            conn = ConnectionUtils.getConnection();

            sql = "select count(*) from lifeguard";

            ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            
            if (rs.next()){
                count = rs.getInt(1);
            }

        } catch (Exception e) {
            String errorMessage = e.getMessage();
            e.printStackTrace();
        } finally {
            DbUtils.close(ps, conn);
        }

        System.out.println("Count=" + count);
        return count;
    }
    
    
    //Method taken and modified from BJ and Roger's Registration Board application
    public void deleteTestData() {
        PreparedStatement ps = null;
        String sql = null;
        Connection conn = null;
        int count = 0;
        try {
            conn = ConnectionUtils.getConnection();

            sql = "delete from lifeguard where first_name = 'testing'";

            ps = conn.prepareStatement(sql);

            ps.executeUpdate();
            

        } catch (Exception e) {
            String errorMessage = e.getMessage();
            e.printStackTrace();
        } finally {
            DbUtils.close(ps, conn);
        }

    }

    /**
     * Test of addLifeguard method, of class LifeguardUtility.
     */
    @Test
    public void testAddLifeguard() {
        int initialCount = getNumberOfLifeguards();
        System.out.println("addLifeguard");
        String firstName = "testing";
        String lastName = "testing";
        String phoneNumber = "9023144730";
        String NLS = "2014-06-01";
        String CPR = "2014-06-01";
        boolean result = LifeguardUtility.addLifeguard(firstName, lastName, phoneNumber, NLS, CPR);
        
        int finalCount = getNumberOfLifeguards();
        assertEquals(initialCount+1, finalCount);
        deleteTestData();
        
    }
    
}

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
public class ScheduleUtilityTest {
    
    public ScheduleUtilityTest() {
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
        deleteTestData();
    }
    
    //Method taken and modified from BJ and Roger's Registration Board application
    private int getNumberOfShifts() {
        PreparedStatement ps = null;
        PreparedStatement ps1 = null;
        PreparedStatement ps2 = null;
        String sql = null;
        String sql1 = null;
        String sql2 = null;
        Connection conn = null;
        int count = 0;
        try {
            conn = ConnectionUtils.getConnection();

            sql = "select count(*) from simmons";
            sql1 = "select count(*) from split";
            sql2 = "select count(*) from victoria_park";

            ps = conn.prepareStatement(sql);
            ps1 = conn.prepareStatement(sql1);
            ps2 = conn.prepareStatement(sql2);

            ResultSet rs = ps.executeQuery();
            ResultSet rs1 = ps1.executeQuery();
            ResultSet rs2 = ps2.executeQuery();
            
            if (rs.next()){
                count += rs.getInt(1);
            }
            
            if (rs1.next()){
                count += rs1.getInt(1);
            }
            
            if (rs2.next()){
                count += rs2.getInt(1);
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
        PreparedStatement ps1 = null;
        PreparedStatement ps2 = null;
        String sql = null;
        String sql1 = null;
        String sql2 = null;
        Connection conn = null;
        int count = 0;
        try {
            conn = ConnectionUtils.getConnection();

            sql = "delete from simmons where lifeguard_1 = 'testing'";
            sql1 = "delete from split where lifeguard_1 = 'testing'";
            sql2 = "delete from victoria_park where lifeguard_1 = 'testing'";

            ps = conn.prepareStatement(sql);
            ps1 = conn.prepareStatement(sql1);
            ps2 = conn.prepareStatement(sql2);

            ps.executeUpdate();
            ps1.executeUpdate();
            ps2.executeUpdate();
            

        } catch (Exception e) {
            String errorMessage = e.getMessage();
            e.printStackTrace();
        } finally {
            DbUtils.close(ps, conn);
        }

    }

    /**
     * Test of modifySchedule method, of class ScheduleUtility.
     */
    @Test
    public void testModifySchedule() {
        System.out.println("modifySchedule");
        int initialCount = getNumberOfShifts();
        
        String date = "2011-01-01";
        String simmonsLifeguard1 = "testing";
        String simmonsLifeguard2 = "testing";
        String simmonsLifeguard3 = "testing";
        String splitLifeguard1 = "testing";
        String splitLifeguard2 = "testing";
        String vpLifeguard1 = "testing";
        String vpLifeguard2 = "testing";
        String vpLifeguard3 = "testing";
        
        boolean result = ScheduleUtility.modifySchedule(date, simmonsLifeguard1, simmonsLifeguard2, simmonsLifeguard3, splitLifeguard1, splitLifeguard2, vpLifeguard1, vpLifeguard2, vpLifeguard3);
        
        int finalCount = getNumberOfShifts();
        assertEquals(initialCount+3, finalCount);
        
    }
    
}

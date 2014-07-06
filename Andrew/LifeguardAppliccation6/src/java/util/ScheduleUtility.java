/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Andrew
 */
public class ScheduleUtility {
    
    //This method adds or modifies the schedule for a given day. It returns a boolean, but is not currently required by the program.
    public static boolean modifySchedule(String date, String simmonsLifeguard1, String simmonsLifeguard2, String simmonsLifeguard3, String splitLifeguard1, String splitLifeguard2, String vpLifeguard1, String vpLifeguard2, String vpLifeguard3) {
        PreparedStatement ps = null;
        String sql = null;
        Connection conn = null;
        boolean valid = false;

        try {
            conn = ConnectionUtils.getConnection();

            sql = "INSERT INTO simmons (shift_date,lifeguard_1,lifeguard_2,lifeguard_3) "
                    + "VALUES ('"+date+"','"+simmonsLifeguard1+"','"+simmonsLifeguard2+"','"+simmonsLifeguard3+"')"
                    + "ON DUPLICATE KEY UPDATE "
                    + "shift_date = VALUES(shift_date), lifeguard_1 = VALUES(lifeguard_1), lifeguard_2 = VALUES(lifeguard_2), lifeguard_3 = VALUES(lifeguard_3)";

            ps = conn.prepareStatement(sql);
            ps.executeUpdate();    
            valid = true;
                
            
        } catch (Exception e) {
            String errorMessage = e.getMessage();
            e.printStackTrace();
        } finally {
            DbUtils.close(ps, conn);
        }
        try {
            conn = ConnectionUtils.getConnection();

            sql = "INSERT INTO split (shift_date,lifeguard_1,lifeguard_2) "
                    + "VALUES ('"+date+"','"+splitLifeguard1+"','"+splitLifeguard2+"')"
                    + "ON DUPLICATE KEY UPDATE "
                    + "shift_date = VALUES(shift_date), lifeguard_1 = VALUES(lifeguard_1), lifeguard_2 = VALUES(lifeguard_2)";

            ps = conn.prepareStatement(sql);
            ps.executeUpdate();    
            valid = true;
                
            
        } catch (Exception e) {
            String errorMessage = e.getMessage();
            e.printStackTrace();
        } finally {
            DbUtils.close(ps, conn);
        }
        try {
            conn = ConnectionUtils.getConnection();

            sql = "INSERT INTO victoria_park (shift_date,lifeguard_1,lifeguard_2,lifeguard_3) "
                    + "VALUES ('"+date+"','"+vpLifeguard1+"','"+vpLifeguard2+"','"+vpLifeguard3+"')"
                    + "ON DUPLICATE KEY UPDATE "
                    + "shift_date = VALUES(shift_date), lifeguard_1 = VALUES(lifeguard_1), lifeguard_2 = VALUES(lifeguard_2), lifeguard_3 = VALUES(lifeguard_3)";

            ps = conn.prepareStatement(sql);
            ps.executeUpdate();    
            valid = true;
                
            
        } catch (Exception e) {
            String errorMessage = e.getMessage();
            e.printStackTrace();
        } finally {
            DbUtils.close(ps, conn);
        }

        return valid;
    }
    //This static method is used by the web service FutureShifts and finds the shifts for a certain lifeguard
    public static String findShifts(String firstName, String lastName){
        PreparedStatement ps = null;
                String sql = null;
                Connection conn = null;
                boolean valid = false;
                String lifeguardName = firstName+" "+lastName;
                String output = "";

                try {
                    conn = ConnectionUtils.getConnection();
                    sql = "SELECT shift_date FROM simmons WHERE lifeguard_1 = '"+lifeguardName+"' OR lifeguard_2 = '"+lifeguardName+"' OR lifeguard_3 = '"+lifeguardName+"'";

                    ps = conn.prepareStatement(sql);
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
                        output += "\nSimmons: "+ rs.getString("shift_date");
                        
                    }
                } catch (Exception e) {
                    String errorMessage = e.getMessage();
                    e.printStackTrace();
                } finally {
                    DbUtils.close(ps, conn);
                }
                
                try {
                    conn = ConnectionUtils.getConnection();
                    sql = "SELECT shift_date FROM split WHERE lifeguard_1 = '"+lifeguardName+"' OR lifeguard_2 = '"+lifeguardName+"'";

                    ps = conn.prepareStatement(sql);
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
                        output += "\nSplit: "+ rs.getString("shift_date");
                        
                    }
                } catch (Exception e) {
                    String errorMessage = e.getMessage();
                    e.printStackTrace();
                } finally {
                    DbUtils.close(ps, conn);
                }
                
                try {
                    conn = ConnectionUtils.getConnection();
                    sql = "SELECT shift_date FROM simmons WHERE lifeguard_1 = '"+lifeguardName+"' OR lifeguard_2 = '"+lifeguardName+"' OR lifeguard_3 = '"+lifeguardName+"'";

                    ps = conn.prepareStatement(sql);
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
                        output += "\nVictoria Park: "+ rs.getString("shift_date");
                        
                    }
                } catch (Exception e) {
                    String errorMessage = e.getMessage();
                    e.printStackTrace();
                } finally {
                    DbUtils.close(ps, conn);
                }
        return output;
    }
}

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
public class LifeguardUtility {
    
    //This method adds a new lifeguard to the database. It returns a boolean, but this is not currently required by the program.
    public static boolean addLifeguard(String firstName, String lastName, String phoneNumber, String NLS, String CPR) {
        PreparedStatement ps = null;
        String sql = null;
        Connection conn = null;
        boolean valid = false;

        try {
            conn = ConnectionUtils.getConnection();

            sql = "INSERT INTO lifeguard (first_name,last_name,phone_number,nls_expiration,cpr_expiration) "
                    + "VALUES ('"+firstName+"','"+lastName+"','"+phoneNumber+"','"+NLS+"','"+CPR+"')";

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
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package util;

import business.Member;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Andrew Reid
 * @date 20140622
 * @purpose This class will be used for user validation
 */
public class Validation {
    
    //This method is used for login. It accepts a username and password, and returns a member.
    public static Member authenticateUser(String userId, String password) {
        PreparedStatement ps = null;
        String sql = null;
        Connection conn = null;
        boolean valid = false;
        Member currentMember = new Member();

        try {
            conn = ConnectionUtils.getConnection();

            sql = "SELECT * FROM lifeguard_access WHERE username = ? and password = ?";

            ps = conn.prepareStatement(sql);
            ps.setString(1, userId);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                
                currentMember.setMemberType(rs.getInt("member_type"));
                currentMember.setMemberId(rs.getInt("member_id"));
                currentMember.setUsername(userId);
                
            }
        } catch (Exception e) {
            String errorMessage = e.getMessage();
            e.printStackTrace();
        } finally {
            DbUtils.close(ps, conn);
        }

        return currentMember;
    }
}

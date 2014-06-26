package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import util.ConnectionUtils;

/**
 *
 * @author Ryan Forrester
 * 
 * Purpose: This web service takes in a users names and gives back the next field
 * that the user has booked.
 */

@WebService(serviceName = "Authentication")
public class Validate {


    @WebMethod(operationName = "get")
    public String get(String name) {
        String result = "";
        PreparedStatement psAuthenticate = null;
        String sql = null;
        Connection conn = null;
        try {
            conn = ConnectionUtils.getConnection();
        } catch (Exception ex) {
            System.out.println("There was a connection error");
        }

        try {
            Calendar c = Calendar.getInstance();
            Date dt = c.getTime();
            String modifiedDate = new SimpleDateFormat("yyyy-MM-dd").format(dt);
            
            sql = "SELECT * "
                    + "FROM `booked_field`, `time`, `user`, `field` "
                    + "WHERE booked_field.DATE >= \"" + modifiedDate + "\" "
                    + "AND user.NAME = \"" + name + "\" " 
                    + "AND booked_field.TIME_NUM = time.TIME_NUM "
                    + "AND booked_field.USER_ID = user.USER_ID "
                    + "AND booked_field.FIELD_NUM = field.FIELD_NUM"       
                    + " ORDER BY booked_field.DATE, booked_field.TIME_NUM ASC LIMIT 1";
            psAuthenticate = conn.prepareStatement(sql);
            ResultSet rs = psAuthenticate.executeQuery();
            
            while (rs.next()) {
                result = "The next field booked by " + rs.getString("NAME") + " is "
                        + rs.getString("FIELD_NAME") + " on " + rs.getString("DATE")
                        + " at " + rs.getString("TIME_DEF") + ".";
                System.out.println(result);
            }
        } catch (Exception e) {
            String errorMessage = e.getMessage();
            e.printStackTrace();
        }
        return result;
    }
}

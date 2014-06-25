package business;

import forms.SupportSessionForm;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.ConnectionUtils;
import util.DbUtils;

/**
 * @author Ian Mori
 * @since June 9, 2014
 *
 * Support Session class, similar to the Order class, this contains
 * functionality for updating the Support Session table.
 */
public class SupportSession {

    /**
     * This method will add a new support session to the database of return
     * false.
     */
    public boolean saveNewSupportSession(SupportSessionForm newSupportSession, int userId) {
        boolean wasSupportSessionBookedSuccessfully = false;
        Connection conn = null;
        try {
            conn = ConnectionUtils.getConnection();
        } catch (Exception ex) {
            Logger.getLogger(Account.class.getName()).log(Level.SEVERE, null, ex);
        }
        PreparedStatement psNewSupportSession = null;
        String sqlNewSupportSession = "insert into support_session_tb(support_session_id, "
                + "customer_id, first_name, email, support_session_date, support_session_description)"
                + " values(?,?,?,?,?,?)";
        try {
            psNewSupportSession = conn.prepareStatement(sqlNewSupportSession);

            //Same as before, setting the variables gathered from the form into the database.
            psNewSupportSession.setNull(1, java.sql.Types.INTEGER);
            psNewSupportSession.setInt(2, userId);
            psNewSupportSession.setString(3, newSupportSession.getFirstName());
            psNewSupportSession.setString(4, newSupportSession.getEmail());
            psNewSupportSession.setString(5, newSupportSession.getSupportSessionDate());
            psNewSupportSession.setString(6, newSupportSession.getSupportSessionDescription());

            //If there is an integer greater than 0, we have a successful update.
            int results = psNewSupportSession.executeUpdate();
            if (results > 0) {
                wasSupportSessionBookedSuccessfully = true;
            }
        } catch (Exception e) {
            String errorMessage = e.getMessage();
            e.printStackTrace();
            wasSupportSessionBookedSuccessfully = false;
        } finally {
            DbUtils.close(psNewSupportSession, conn);
        }
        return wasSupportSessionBookedSuccessfully;
    }
}

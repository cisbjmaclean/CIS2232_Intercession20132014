package business;

import forms.SupportSessionForm;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.struts.validator.ValidatorForm;
import util.ConnectionUtils;
import util.DbUtils;

/**
 *
 * @author prog
 */
public class SupportSession extends ValidatorForm {

    public boolean saveNewSupportSession(SupportSessionForm newSupportSession, int userId) {

        boolean wasSupportSessionBookedSuccessfully = false;
        Connection conn = null;
        try {
            conn = ConnectionUtils.getConnection();
        } catch (Exception ex) {
            Logger.getLogger(Account.class.getName()).log(Level.SEVERE, null, ex);
        }
        PreparedStatement psNewUserRegistration = null;
        String sqlNewUserRegistration;

        sqlNewUserRegistration = "insert into support_session_tb(support_session_id, "
                + "customer_id, first_name, email, support_session_date, support_session_description)"
                + " values(?,?,?,?,?,?)";
        try {
            psNewUserRegistration = conn.prepareStatement(sqlNewUserRegistration);

            psNewUserRegistration.setNull(1, java.sql.Types.INTEGER);
            psNewUserRegistration.setInt(2, userId);
            psNewUserRegistration.setString(3, newSupportSession.getFirstName());
            psNewUserRegistration.setString(4, newSupportSession.getEmail());
            psNewUserRegistration.setString(5, newSupportSession.getSupportSessionDate());
            psNewUserRegistration.setString(6, newSupportSession.getSupportSessionDescription());

            int results = psNewUserRegistration.executeUpdate();
            if (results > 0) {
                wasSupportSessionBookedSuccessfully = true;
            }
        } catch (Exception e) {
            String errorMessage = e.getMessage();
            e.printStackTrace();
            wasSupportSessionBookedSuccessfully = false;
        } finally {
            DbUtils.close(psNewUserRegistration, conn);
        }
        return wasSupportSessionBookedSuccessfully;
    }
}

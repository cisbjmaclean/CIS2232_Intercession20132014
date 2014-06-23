package business;

import forms.LoginForm;
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
public class ModifyAccountPassword extends ValidatorForm {

    public boolean modifyNewAccount(String password, int userId) {

        boolean wasAccountModifiedSuccessfully = false;
        LoginForm getId = new LoginForm();
        Connection conn = null;
        try {
            conn = ConnectionUtils.getConnection();
        } catch (Exception ex) {
            Logger.getLogger(Account.class.getName()).log(Level.SEVERE, null, ex);
        }
        PreparedStatement psNewAccountModification = null;
        String sqlNewAccountModification = "UPDATE customer_tb SET customer_password = '" + password + "' "
                + "WHERE customer_id = " + userId;
        try {
            psNewAccountModification = conn.prepareStatement(sqlNewAccountModification);
            int results = psNewAccountModification.executeUpdate();
            if (results > 0) {
                wasAccountModifiedSuccessfully = true;
            }
        } catch (Exception e) {
            String errorMessage = e.getMessage();
            e.printStackTrace();
            wasAccountModifiedSuccessfully = false;
        } finally {
            DbUtils.close(psNewAccountModification, conn);
        }
        return wasAccountModifiedSuccessfully;
    }
}

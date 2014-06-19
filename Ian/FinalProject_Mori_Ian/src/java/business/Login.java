package business;

import forms.LoginForm;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.struts.validator.ValidatorForm;
import util.ConnectionUtils;
import util.DbUtils;

/**
 * @author Ian Mori
 */
//May 28,2014 - added variables for instrument assignment and removed unused code.
public class Login extends ValidatorForm {

    /**
     * This method will load the instruments from the database with their
     * adjusted price and instrument type.
     *
     * @author Ian Mori- May 28,2014 - removed unused code and added
     * functionality for the music db.
     */
    public static boolean loadAuthenticatedUserFromDatabase(LoginForm formBean) {

        boolean wasUserLoadedSuccessfully = false;
        PreparedStatement psAuthenticate = null;
        String sql;
        Connection conn = null;
        try {
            conn = ConnectionUtils.getConnection();
        } catch (Exception ex) {
            Logger.getLogger(Account.class.getName()).log(Level.SEVERE, null, ex);
        }
        sql = "SELECT customer_id, customer_username, customer_password FROM customer_tb "
                + "WHERE customer_username = ? AND customer_password = ?";
        try {
            psAuthenticate = conn.prepareStatement(sql);
            psAuthenticate.setString(1, formBean.getCustomerUsernameToValidate());
            psAuthenticate.setString(2, formBean.getCustomerPasswordToValidate());

            ResultSet rs = psAuthenticate.executeQuery();
            if (rs.next()) {
                formBean.setAuthenticatedUserId(rs.getInt(1));
                formBean.setAuthenticatedUser(formBean.getCustomerUsernameToValidate());
                wasUserLoadedSuccessfully = true;
            }
        } catch (Exception e) {
            String errorMessage = e.getMessage();
            e.printStackTrace();
            wasUserLoadedSuccessfully = false;

        } finally {
            DbUtils.close(psAuthenticate, conn);
        }
        return wasUserLoadedSuccessfully;
    }
}

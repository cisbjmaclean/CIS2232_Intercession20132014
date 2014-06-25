package business;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.struts.validator.ValidatorForm;
import util.ConnectionUtils;
import util.DbUtils;

/**
 * @author Ian Mori
 * @since June 9, 2014
 *
 * This is the ModifyAccount class, this will query the database and change a
 * user's password.
 */
public class ModifyAccountPassword extends ValidatorForm {

    /**
     * This method will alter a user's password, it will also return true or
     * false depending on the outcome.
     */
    public boolean modifyNewAccount(String password, int userId) {

        //Setting up variables, connection, and sql statement.
        boolean wasAccountModifiedSuccessfully = false;
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
            //If there is an integer greater than 0, we know the update ran successfully.
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

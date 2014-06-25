package business;

import forms.LoginForm;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.ConnectionUtils;
import util.DbUtils;

/**
 * @author Ian Mori
 * @since June 9, 2014
 *
 * This is the Login class, this will query the database to log a user in.
 */
public class Login {

    /**
     * This method will return true or false, depending on the variables passed
     * to be queried. It will allow a user to login or return an error.
     */
    public static boolean loadAuthenticatedUserFromDatabase(LoginForm formBean) {
        //Setting up initial variables, connection, sql statement.
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
            
            //Using the username and password, and checking if they combination matches.
            psAuthenticate.setString(1, formBean.getCustomerUsernameToValidate());
            psAuthenticate.setString(2, formBean.getCustomerPasswordToValidate());
            
            //If there is a result, the user will be logged in with the credentials used.
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

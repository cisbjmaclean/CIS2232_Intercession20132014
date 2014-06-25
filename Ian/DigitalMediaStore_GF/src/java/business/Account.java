package business;

import forms.AccountForm;
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
 * This is the Account class which will use the form data and try and submit it
 * to the database.
 */
public class Account {

    /**
     * This method will save a new account to the database or throw an exception
     * depending on the outcome of the method.
     *
     * @return
     */
    public boolean saveNewAccount(AccountForm newAccountForm) throws Exception {

        //Setting up inital variables, connection, and sql statement.
        boolean wasAccountSavedToDatabaseSuccessfully = false;
        Connection conn = null;
        try {
            conn = ConnectionUtils.getConnection();
        } catch (Exception ex) {
            Logger.getLogger(Account.class.getName()).log(Level.SEVERE, null, ex);
        }
        PreparedStatement psNewUserRegistration = null;
        String sqlNewUserRegistration;
        sqlNewUserRegistration = "INSERT INTO customer_tb(customer_id, customer_username, customer_password,"
                + " customer_first_name, customer_last_name, customer_email, customer_street_address, customer_city,"
                + " customer_province, customer_postal_code, customer_telephone, customer_balance)"
                + " VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";

        psNewUserRegistration = conn.prepareStatement(sqlNewUserRegistration);

        //Sending the data gathered from the form to database.
        psNewUserRegistration.setNull(1, java.sql.Types.INTEGER);
        psNewUserRegistration.setString(2, newAccountForm.getCustomerUsername());
        psNewUserRegistration.setString(3, newAccountForm.getCustomerPassword());
        psNewUserRegistration.setString(4, newAccountForm.getCustomerFirstName());
        psNewUserRegistration.setString(5, newAccountForm.getCustomerLastName());
        psNewUserRegistration.setString(6, newAccountForm.getCustomerEmail());
        psNewUserRegistration.setString(7, newAccountForm.getCustomerStreetAddress());
        psNewUserRegistration.setString(8, newAccountForm.getCustomerCity());
        psNewUserRegistration.setString(9, newAccountForm.getCustomerProvince());
        psNewUserRegistration.setString(10, newAccountForm.getCustomerPostalCode());
        psNewUserRegistration.setString(11, newAccountForm.getCustomerTelephone());
        psNewUserRegistration.setDouble(12, 0.00);

        //This just lets us know if the query ran successfully or not.
        int results = psNewUserRegistration.executeUpdate();
        if (results > 0) {
            wasAccountSavedToDatabaseSuccessfully = true;
        } else {
            wasAccountSavedToDatabaseSuccessfully = false;
            DbUtils.close(psNewUserRegistration, conn);
        }
        return wasAccountSavedToDatabaseSuccessfully;
    }
}

package business;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.ConnectionUtils;

/**
 * @author Ian Mori
 * @since June 9, 2014
 *
 * This is the CustomerBalance class, the use for this class is updating a 
 * customer's balance.
 */
public class CustomerBalance {

    public boolean updateCustomerBalance(int customerId, double orderTotal) {

        //Set up initial variables, connection, and sql statement.
        boolean wasCustomerBalanceUpdatedSuccesfully = false;
        Connection conn = null;
        try {
            conn = ConnectionUtils.getConnection();
        } catch (Exception ex) {
            Logger.getLogger(Account.class.getName()).log(Level.SEVERE, null, ex);
        }
        PreparedStatement psCustomerBalanceUpdate = null;
        String sqlUpdateBalance = "UPDATE customer_tb "
                + "SET customer_balance = customer_balance + " + orderTotal
                + " WHERE customer_id = " + customerId;
        try {
            psCustomerBalanceUpdate = conn.prepareStatement(sqlUpdateBalance);

            //If there is a result, we know that balance was updated successfully.
            int results = psCustomerBalanceUpdate.executeUpdate();
            if (results > 0) {
                wasCustomerBalanceUpdatedSuccesfully = true;
            }
        } catch (Exception e) {
            String errorMessage = e.getMessage();
            e.printStackTrace();
            wasCustomerBalanceUpdatedSuccesfully = false;
        }
        return wasCustomerBalanceUpdatedSuccesfully;
    }
}

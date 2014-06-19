package business;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.ConnectionUtils;

/**
 *
 * @author prog
 */
public class CustomerBalance {

    public boolean updateCustomerBalance(int customerId, double orderTotal) {

        boolean wasCustomerBalanceUpdatedSuccesfully = false;
        Connection conn = null;
        try {
            conn = ConnectionUtils.getConnection();
        } catch (Exception ex) {
            Logger.getLogger(Account.class.getName()).log(Level.SEVERE, null, ex);
        }
        PreparedStatement psCustomerBalanceUpdate = null;

        String sqlNewOrderRetrieval = "UPDATE customer_tb "
                + "SET customer_balance = customer_balance + " + orderTotal
                + " WHERE customer_id = " + customerId;
        try {
            psCustomerBalanceUpdate = conn.prepareStatement(sqlNewOrderRetrieval);

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

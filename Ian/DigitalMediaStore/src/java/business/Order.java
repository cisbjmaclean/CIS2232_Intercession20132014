package business;

import forms.OrderForm;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.struts.validator.ValidatorForm;
import util.ConnectionUtils;
import util.DbUtils;

/**
 *
 * @author prog
 */
public class Order extends ValidatorForm {

    public boolean saveNewOrder(OrderForm newOrderForm, int userId) {

        boolean wasOrderLineAddedSuccessfully = false;
        boolean wereAllOrderLinesAddedSuccessfully = false;
        Connection conn = null;
        try {
            conn = ConnectionUtils.getConnection();
        } catch (Exception ex) {
            Logger.getLogger(Account.class.getName()).log(Level.SEVERE, null, ex);
        }
        PreparedStatement psNewOrderRegistration = null;
        String sqlNewOrderRegistration;
        sqlNewOrderRegistration = "INSERT INTO order_tb(order_id, customer_id, order_date)"
                + " VALUES(?,?,?)";
        try {
            psNewOrderRegistration = conn.prepareStatement(sqlNewOrderRegistration, PreparedStatement.RETURN_GENERATED_KEYS);
            psNewOrderRegistration.setNull(1, java.sql.Types.INTEGER);
            psNewOrderRegistration.setInt(2, userId);
            psNewOrderRegistration.setDate(3, new java.sql.Date(System.currentTimeMillis()));
            psNewOrderRegistration.executeUpdate();

            ResultSet rs = psNewOrderRegistration.getGeneratedKeys();
            int currentOrderId = 0;
            if (rs.next()) {
                currentOrderId = rs.getInt(1);
            }
//
            OrderLine orderLine = new OrderLine();
//            newOrderForm.getTotalOrderLines();
            wasOrderLineAddedSuccessfully = orderLine.saveNewOrderLine(currentOrderId, userId, newOrderForm);
        } catch (Exception e) {
            String errorMessage = e.getMessage();
            e.printStackTrace();
            wasOrderLineAddedSuccessfully = false;
        } finally {
            DbUtils.close(psNewOrderRegistration, conn);
        }
        OrderForm.getOrderLines().clear();
        return wasOrderLineAddedSuccessfully;
    }
}

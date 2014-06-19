package business;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.struts.validator.ValidatorForm;
import util.ConnectionUtils;
import util.DbUtils;

/**
 *
 * @author prog
 */
public class OrderView extends ValidatorForm {

    private ArrayList<OrderView> orders = new ArrayList();
    private int orderId;
    private String orderDate;
    
    public ArrayList<OrderView> getOrders() {
        return orders;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    
    public boolean retrieveOrders(int userId) {

        boolean wereOrdersRetrievedSuccessfully = false;
        Connection conn = null;
        try {
            conn = ConnectionUtils.getConnection();
        } catch (Exception ex) {
            Logger.getLogger(Account.class.getName()).log(Level.SEVERE, null, ex);
        }
        PreparedStatement psNewOrderRegistration = null;
        String sqlNewOrderRetrieval = "SELECT order_id, order_date FROM order_tb "
                + "WHERE customer_id = " + userId;
        try {
            psNewOrderRegistration = conn.prepareStatement(sqlNewOrderRetrieval);
            ResultSet rs = psNewOrderRegistration.executeQuery();
            orders.clear();
            
            
            while (rs.next()) {
                OrderView order = new OrderView();
                order.setOrderId(rs.getInt(1));
                order.setOrderDate(rs.getString(2));
                orders.add(order);
            }
            
            
            
            wereOrdersRetrievedSuccessfully = true;
        } catch (Exception e) {
            String errorMessage = e.getMessage();
            e.printStackTrace();
            wereOrdersRetrievedSuccessfully = false;
        } finally {
            DbUtils.close(psNewOrderRegistration, conn);
        }
        return wereOrdersRetrievedSuccessfully;
    }
}

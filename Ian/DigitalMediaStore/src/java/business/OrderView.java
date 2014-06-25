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
 * @author Ian Mori
 * @since June 9, 2014
 *
 * OrderView class, this is used for querying the database to gather a
 * customer's order information.
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

    /**
     * This method will retrieve orders from the database depending on the
     * userId.
     */
    public boolean retrieveOrders(int userId) {

        //Inital variables, connection, sql.
        boolean wereOrdersRetrievedSuccessfully = false;
        Connection conn = null;
        try {
            conn = ConnectionUtils.getConnection();
        } catch (Exception ex) {
            Logger.getLogger(Account.class.getName()).log(Level.SEVERE, null, ex);
        }
        PreparedStatement psNewOrderRetrieval = null;
        String sqlNewOrderRetrieval = "SELECT order_id, order_date FROM order_tb "
                + "WHERE customer_id = " + userId;
        try {
            psNewOrderRetrieval = conn.prepareStatement(sqlNewOrderRetrieval);
            ResultSet rs = psNewOrderRetrieval.executeQuery();
            //Clear the order first to remove duplicates.
            orders.clear();

            //While there are results, loop through, gather the variables from the database.
            //The orders arrayList is added to with each result from the database.
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
            DbUtils.close(psNewOrderRetrieval, conn);
        }
        return wereOrdersRetrievedSuccessfully;
    }
}

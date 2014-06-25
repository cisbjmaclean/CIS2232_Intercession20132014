package business;

import forms.OrderForm;
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
 * The Order class, this contains functionality for saving an order to a
 * database.
 */
public class Order {

    /**
     * This method will save a new order to the database and call another method
     * to save each order line belonging to that order.
     */
    public boolean saveNewOrder(OrderForm newOrderForm, int userId) {

        //Initial variables, connection, sql statement.
        boolean wasOrderLineAddedSuccessfully = false;
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
            //Using the generated keys to get the primary key for the order table.
            psNewOrderRegistration = conn.prepareStatement(sqlNewOrderRegistration, PreparedStatement.RETURN_GENERATED_KEYS);
            //Setting variables into the database, using null and type integer for auto increment values.
            psNewOrderRegistration.setNull(1, java.sql.Types.INTEGER);
            psNewOrderRegistration.setInt(2, userId);
            psNewOrderRegistration.setDate(3, new java.sql.Date(System.currentTimeMillis()));
            psNewOrderRegistration.executeUpdate();

            //If we have a result, we can get the primary key.
            ResultSet rs = psNewOrderRegistration.getGeneratedKeys();
            int currentOrderId = 0;
            if (rs.next()) {
                currentOrderId = rs.getInt(1);
            }
            //Creating a new orderLine object for saving each orderline to the database.
            OrderLine orderLine = new OrderLine();
            //Calling a method to save each orderLine
            wasOrderLineAddedSuccessfully = orderLine.saveNewOrderLine(currentOrderId, userId, newOrderForm);
        } catch (Exception e) {
            String errorMessage = e.getMessage();
            e.printStackTrace();
            wasOrderLineAddedSuccessfully = false;
        } finally {
            DbUtils.close(psNewOrderRegistration, conn);
        }
        //Clear the orderLines arrayList so there aren't repeating values.
        OrderForm.getOrderLines().clear();
        return wasOrderLineAddedSuccessfully;
    }
}

package business;

import forms.OrderForm;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.ConnectionUtils;

/**
 *
 * @author prog
 */
public class OrderLine {

    private static ArrayList<OrderLine> orderedItems = new ArrayList();
    
    private int productId;
    private int productQuantity;
    private double salePrice;
    private double orderLineTotal;
    private String productName;

    public OrderLine() {
    }

    public OrderLine(int productId, int productQuantity, double salePrice, String productName) {
        this.productId = productId;
        this.productQuantity = productQuantity;
        this.salePrice = salePrice;
        this.orderLineTotal = salePrice * productQuantity;
        this.productName = productName;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public String getProductName() {
        return productName;
    }
    
    public void setSalePrice(double salePrice) {
        this.salePrice = salePrice;
    }

    public void setOrderLineTotal(double orderLineTotal) {
        this.orderLineTotal = orderLineTotal;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    
    
    
    public int getProductId() {
        return productId;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public double getSalePrice() {
        return salePrice;
    }

    public double getOrderLineTotal() {
        return orderLineTotal;
    }

    public String getProudctName() {
        return productName;
    }

    public static ArrayList<OrderLine> getOrderedItems() {
        return orderedItems;
    }

    public static void setOrderedItems(ArrayList<OrderLine> orderedItems) {
        OrderLine.orderedItems = orderedItems;
    }
    
    

    public boolean saveNewOrderLine(int currentOrderId, int userId, OrderForm newOrderForm) {

        double orderTotal = 0.00;
        boolean wasCustomerBalanceUpdatedSuccessfully = false;
        boolean wasProductTableUpdatedSuccessfully = false;
        Connection conn = null;
        try {
            conn = ConnectionUtils.getConnection();
        } catch (Exception ex) {
            Logger.getLogger(Account.class.getName()).log(Level.SEVERE, null, ex);
        }
        PreparedStatement psNewOrderLineRegistration = null;
        String sqlNewOrderLineRegistration;
        sqlNewOrderLineRegistration = "INSERT INTO order_line_tb(order_line_id, order_id, "
                + "product_id, quantity_ordered, sale_price) "
                + "VALUES(?,?,?,?,?)";
        try {
            psNewOrderLineRegistration = conn.prepareStatement(sqlNewOrderLineRegistration);
            for (OrderLine orderLine : newOrderForm.getOrderLines()) {
                int prodId = orderLine.getProductId();
                int prodQuantity = orderLine.getProductQuantity();
                double lineTotal = orderLine.getOrderLineTotal();
                Product productQuantityUpdate = new Product();

                psNewOrderLineRegistration.setNull(1, java.sql.Types.INTEGER);
                psNewOrderLineRegistration.setInt(2, currentOrderId);
                psNewOrderLineRegistration.setInt(3, prodId);
                psNewOrderLineRegistration.setInt(4, prodQuantity);
                psNewOrderLineRegistration.setDouble(5, orderLine.getSalePrice());
                orderTotal += lineTotal;

                psNewOrderLineRegistration.executeUpdate();
                wasProductTableUpdatedSuccessfully = productQuantityUpdate.updateProductTable(prodId, prodQuantity);
            }
            CustomerBalance balance = new CustomerBalance();
            wasCustomerBalanceUpdatedSuccessfully = balance.updateCustomerBalance(userId, orderTotal);
        } catch (Exception e) {
            String errorMessage = e.getMessage();
            e.printStackTrace();
            wasProductTableUpdatedSuccessfully = false;
            wasCustomerBalanceUpdatedSuccessfully = false;
        }
        return wasProductTableUpdatedSuccessfully && wasCustomerBalanceUpdatedSuccessfully;
    }
}

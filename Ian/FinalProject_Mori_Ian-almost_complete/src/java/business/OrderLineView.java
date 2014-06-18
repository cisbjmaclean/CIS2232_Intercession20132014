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
public class OrderLineView extends ValidatorForm {

    private static ArrayList<OrderLineView> orderLines = new ArrayList();
    private int order_id;
    private int product_id;
    private int quantity_ordered;
    private double sale_price;
    private double order_line_total;
    private String productName;

    public static ArrayList<OrderLineView> getOrderLines() {
        return orderLines;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getQuantity_ordered() {
        return quantity_ordered;
    }

    public void setQuantity_ordered(int quantity_ordered) {
        this.quantity_ordered = quantity_ordered;
    }

    public double getSale_price() {
        return sale_price;
    }

    public void setSale_price(double sale_price) {
        this.sale_price = sale_price;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getOrder_line_total() {
        return order_line_total;
    }

    public void setOrder_line_total(double order_line_total) {
        this.order_line_total = order_line_total;
    }
    
    

    public boolean retrieveOrderDetails() {
        boolean wereOrderDetailsRetrievedSuccessfully = false;
        Connection conn = null;
        try {
            conn = ConnectionUtils.getConnection();
        } catch (Exception ex) {
            Logger.getLogger(Account.class.getName()).log(Level.SEVERE, null, ex);
        }
        PreparedStatement psNewOrderRetrieval = null;
        String sqlNewOrderRetrieval = "SELECT product_id, quantity_ordered, sale_price FROM order_line_tb "
                + "WHERE order_id = " + getOrder_id();
        try {
            psNewOrderRetrieval = conn.prepareStatement(sqlNewOrderRetrieval);
            ResultSet rs = psNewOrderRetrieval.executeQuery();
            Product product = new Product();
            while (rs.next()) {
                
                OrderLineView newOrderLine = new OrderLineView();
                newOrderLine.setProduct_id(rs.getInt(1));
                newOrderLine.setQuantity_ordered(rs.getInt(2));
                newOrderLine.setSale_price(rs.getDouble(3));
                newOrderLine.setOrder_line_total(newOrderLine.getQuantity_ordered() 
                        * newOrderLine.getSale_price());
                
                String result = product.retrieveProductName(newOrderLine.getProduct_id());
                if (!result.equals("false")) {
                    newOrderLine.setProductName(result);
                }
                orderLines.add(newOrderLine);
            }
            wereOrderDetailsRetrievedSuccessfully = true;
        } catch (Exception e) {
            String errorMessage = e.getMessage();
            e.printStackTrace();
            wereOrderDetailsRetrievedSuccessfully = false;
        } finally {
            DbUtils.close(psNewOrderRetrieval, conn);
        }
        return wereOrderDetailsRetrievedSuccessfully;
    }
}

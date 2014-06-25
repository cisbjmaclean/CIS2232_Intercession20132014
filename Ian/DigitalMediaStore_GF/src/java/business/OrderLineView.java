package business;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.struts.validator.ValidatorForm;
import util.ConnectionUtils;
import util.DbUtils;

/**
 *
 * @author Ian Mori
 * @since June 9,2014
 *
 * OrderLineView Class, this class holds the information for viewing order
 * lines.
 */
public class OrderLineView extends ValidatorForm {

    //Creating initial variables.
    private static ArrayList<OrderLineView> orderLines = new ArrayList();
    private int order_id;
    private int product_id;
    private int quantity_ordered;
    private double sale_price;
    private String salePriceAsString;
    private String orderLineTotalAsString;
    private double order_line_total;
    private String productName;
    DecimalFormat df = new DecimalFormat("#.00");

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

    public String getSalePriceAsString() {
        return salePriceAsString;
    }

    public void setSalePriceAsString(double salePrice) {
        this.salePriceAsString = df.format(salePrice);
    }

    public String getOrderLineTotalAsString() {
        return orderLineTotalAsString;
    }

    public void setOrderLineTotalAsString(double orderLineTotal) {
        this.orderLineTotalAsString = df.format(orderLineTotal);
    }

    /**
     * This method will retrieve the order details from the db and return true
     * or false depending on the outcome of the method.
     *
     * @return
     */
    public boolean retrieveOrderDetails() {

        //Setting up variables, connection and sql statement.
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
            //Executing the query and gathering the result set.
            psNewOrderRetrieval = conn.prepareStatement(sqlNewOrderRetrieval);
            ResultSet rs = psNewOrderRetrieval.executeQuery();
            Product product = new Product();
            
            //Clearing the orderLines so there is no incorrect data
            orderLines.clear();

            //While there are results, loop through and set the results.
            while (rs.next()) {
                OrderLineView newOrderLine = new OrderLineView();
                newOrderLine.setProduct_id(rs.getInt(1));
                newOrderLine.setQuantity_ordered(rs.getInt(2));

                //Using both salePrice variables for actual calculations and proper 2 digit decimal display.
                double salesPrice = rs.getDouble(3);
                newOrderLine.setSalePriceAsString(salesPrice);
                newOrderLine.setSale_price(salesPrice);
                double orderLineTotal = newOrderLine.getQuantity_ordered() * newOrderLine.getSale_price();
                newOrderLine.setOrderLineTotalAsString(orderLineTotal);
                newOrderLine.setOrder_line_total(orderLineTotal);

                //Gathering the product name by using the current product id.
                String result = product.retrieveProductName(newOrderLine.getProduct_id());
             
                //The above method will return a String as "false" or give back the String product name.
                if (!result.equals("false")) {
                    newOrderLine.setProductName(result);
                }
                //If everything has gone through successfully we add it to out orderLines arrayList and loop through
                //again if there are more results
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

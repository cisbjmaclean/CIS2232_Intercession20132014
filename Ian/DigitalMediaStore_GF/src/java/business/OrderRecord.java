package business;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * @author Ian Mori
 * @since June 9, 2014
 * 
 * OrderRecord class, this is used for properly saving customer data to a file.
 */
public class OrderRecord {

    private int userId, orderId, orderLineId, orderLineQuantity, productId;
    private double salesPrice;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getOrderLineId() {
        return orderLineId;
    }

    public void setOrderLineId(int orderLineId) {
        this.orderLineId = orderLineId;
    }

    public int getOrderLineQuantity() {
        return orderLineQuantity;
    }

    public void setOrderLineQuantity(int orderLineQuantity) {
        this.orderLineQuantity = orderLineQuantity;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public double getSalesPrice() {
        return salesPrice;
    }

    public void setSalesPrice(double salesPrice) {
        this.salesPrice = salesPrice;
    }

    /**
     * Gathering the String record, properly formatted to save in the file.
     */
    public String getStringRecord() {
        NumberFormat nf = new DecimalFormat("0000.00");
        String delimiter = ",";

        return String.format("%05d", orderLineId) + delimiter + String.format("%05d", orderId) + delimiter
                + String.format("%05d", userId) + delimiter + String.format("%05d", productId) + delimiter
                + String.format("%05d", orderLineQuantity) + delimiter + nf.format(salesPrice)
                + System.getProperty("line.separator");
    }
}

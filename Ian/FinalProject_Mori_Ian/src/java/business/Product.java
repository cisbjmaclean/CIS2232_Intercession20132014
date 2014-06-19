package business;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.ConnectionUtils;

/**
 *
 * @author prog
 */
public class Product {

    private String product_name, product_description;
    private int quantity_on_hand;
    private double product_price;

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getProduct_description() {
        return product_description;
    }

    public void setProduct_description(String product_description) {
        this.product_description = product_description;
    }

    public int getQuantity_on_hand() {
        return quantity_on_hand;
    }

    public void setQuantity_on_hand(int quantity_on_hand) {
        this.quantity_on_hand = quantity_on_hand;
    }

    public double getProduct_price() {
        return product_price;
    }

    public void setProduct_price(double product_price) {
        this.product_price = product_price;
    }

    public boolean updateProductTable(int productId, int productQuantity) {
        boolean wasProductTableUpdatedSuccesfully = false;
        Connection conn = null;
        try {
            conn = ConnectionUtils.getConnection();
        } catch (Exception ex) {
            Logger.getLogger(Account.class.getName()).log(Level.SEVERE, null, ex);
        }
        PreparedStatement psUpdateProduct = null;

        String sqlNewOrderRetrieval = "UPDATE product_tb "
                + "SET quantity_on_hand = quantity_on_hand - " + productQuantity
                + " WHERE product_id = " + productId;
        try {
            psUpdateProduct = conn.prepareStatement(sqlNewOrderRetrieval);

            int results = psUpdateProduct.executeUpdate();
            if (results > 0) {
                wasProductTableUpdatedSuccesfully = true;
            }
        } catch (Exception e) {
            String errorMessage = e.getMessage();
            e.printStackTrace();
            wasProductTableUpdatedSuccesfully = false;
        }
        return wasProductTableUpdatedSuccesfully;
    }

    public String retrieveProductName(int productId) {
        String queryResult = "false";
        Connection conn = null;
        try {
            conn = ConnectionUtils.getConnection();
        } catch (Exception ex) {
            Logger.getLogger(Account.class.getName()).log(Level.SEVERE, null, ex);
        }
        PreparedStatement psProductNameRetrieval = null;

        String sqlProductNameRetrieval = "SELECT product_name FROM product_tb "
                + " WHERE product_id = " + productId;
        try {
            psProductNameRetrieval = conn.prepareStatement(sqlProductNameRetrieval);
            ResultSet rs = psProductNameRetrieval.executeQuery();

            if (rs.next()) {
                queryResult = rs.getString(1);
            }
        } catch (Exception e) {
            String errorMessage = e.getMessage();
            e.printStackTrace();
            queryResult = "false";
        }
        return queryResult;
    }

    public boolean retrieveProductDetails(String productName) {

        boolean wasQuerySuccessful = false;
        Connection conn = null;
        try {
            conn = ConnectionUtils.getConnection();
        } catch (Exception ex) {
            Logger.getLogger(Account.class.getName()).log(Level.SEVERE, null, ex);
        }
        PreparedStatement psNewOrderRegistration = null;
        String sqlProductNameRetrieval = "SELECT product_name, quantity_on_hand, product_description,"
                + " product_price FROM product_tb "
                + " WHERE product_name LIKE '%" + productName + "%'";
        try {
            psNewOrderRegistration = conn.prepareStatement(sqlProductNameRetrieval);
            ResultSet rs = psNewOrderRegistration.executeQuery();

            if (rs.next()) {
                setProduct_name(rs.getString(1));
                setQuantity_on_hand(rs.getInt(2));
                setProduct_description(rs.getString(3));
                setProduct_price(rs.getDouble(4));

                wasQuerySuccessful = true;
            }
        } catch (Exception e) {
            String errorMessage = e.getMessage();
            e.printStackTrace();
            wasQuerySuccessful = false;
        }
        return wasQuerySuccessful;
    }
}
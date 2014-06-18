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
    
    public boolean updateProductTable(int productId, int productQuantity) {
        boolean wasProductTableUpdatedSuccesfully = false;
        Connection conn = null;
        try {
            conn = ConnectionUtils.getConnection();
        } catch (Exception ex) {
            Logger.getLogger(Account.class.getName()).log(Level.SEVERE, null, ex);
        }
        PreparedStatement psNewOrderRegistration = null;
        
        String sqlNewOrderRetrieval = "UPDATE product_tb "
                + "SET quantity_on_hand = quantity_on_hand - " + productQuantity
                + " WHERE product_id = " + productId;
        try {
            psNewOrderRegistration = conn.prepareStatement(sqlNewOrderRetrieval);
            
            int results = psNewOrderRegistration.executeUpdate();
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
        String didQueryRunSuccesfully = "false";
        Connection conn = null;
        try {
            conn = ConnectionUtils.getConnection();
        } catch (Exception ex) {
            Logger.getLogger(Account.class.getName()).log(Level.SEVERE, null, ex);
        }
        PreparedStatement psNewOrderRegistration = null;
        
        String sqlProductNameRetrieval = "SELECT product_name FROM product_tb "
                + " WHERE product_id = " + productId;
        try {
            psNewOrderRegistration = conn.prepareStatement(sqlProductNameRetrieval);
            ResultSet rs = psNewOrderRegistration.executeQuery();
            
            if (rs.next()) {
                didQueryRunSuccesfully = rs.getString(1);
            }
        } catch (Exception e) {
            String errorMessage = e.getMessage();
            e.printStackTrace();
            didQueryRunSuccesfully = "false";
        }
        return didQueryRunSuccesfully;
    }
}

package business;

import java.io.StringWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import util.ConnectionUtils;

/**
 * @author Ian Mori
 * @since June 9, 2014
 *
 * Product class, this is class is used in testing and houses functionality for
 * querying and updating the product table.
 */
@XmlRootElement(name = "Product")
@XmlType(propOrder = {"product_name", "quantity_on_hand", "product_description", "product_price"})
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

    /**
     * When this method is called and runs successfully, it will update the
     * product table or return false.
     */
    public boolean updateProductTable(int productId, int productQuantity) {
        boolean wasProductTableUpdatedSuccesfully = false;
        Connection conn = null;
        try {
            conn = ConnectionUtils.getConnection();
        } catch (Exception ex) {
            Logger.getLogger(Account.class.getName()).log(Level.SEVERE, null, ex);
        }
        PreparedStatement psUpdateProduct = null;
        String sqlUpdateProduct = "UPDATE product_tb "
                + "SET quantity_on_hand = quantity_on_hand - " + productQuantity
                + " WHERE product_id = " + productId;
        try {
            psUpdateProduct = conn.prepareStatement(sqlUpdateProduct);

            //If there is a result greater than 0, the update was successful.
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

    /**
     * This method simply retrieves a product's name from the database.
     */
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

            //This will return the name of the product if the query was successful or return a String equal to "false";
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

    /**
     *
     * This method will query the database and return the product name or return
     * false;
     */
    public boolean retrieveProductDetails(String productName) {
        boolean wasQuerySuccessful = false;
        Connection conn = null;
        try {
            conn = ConnectionUtils.getConnection();
        } catch (Exception ex) {
            Logger.getLogger(Account.class.getName()).log(Level.SEVERE, null, ex);
        }
        PreparedStatement psProductRetrieval = null;
        String sqlProductNameRetrieval = "SELECT product_name, quantity_on_hand, product_description,"
                + " product_price FROM product_tb "
                + " WHERE product_name LIKE '%" + productName + "%'";
        try {
            psProductRetrieval = conn.prepareStatement(sqlProductNameRetrieval);
            ResultSet rs = psProductRetrieval.executeQuery();

            //If there is a result, we can set the variables gathered from the query.
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

    /**
     * This method is used for the web service, it outputs the results to an XML
     * string.
     */
    public String toStringXML() {
        String xmlProduct = "";
        try {
            // create JAXB context and instantiate marshaller
            JAXBContext context = JAXBContext.newInstance(Product.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            // Write to System.out
            StringWriter sw = new StringWriter();
            m.marshal(this, sw);
            xmlProduct = sw.toString();
            System.out.println("xmlEncodedProduct=" + xmlProduct);
        } catch (JAXBException ex) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
        }
        return xmlProduct;
    }
}

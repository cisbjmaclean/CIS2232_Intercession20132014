package business;

import forms.OrderForm;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardOpenOption.READ;
import static java.nio.file.StandardOpenOption.WRITE;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.ConnectionUtils;
import util.FileUtility;

/**
 * @author Ian Mori
 * @since June 9, 2014
 *
 * The OrderLine class, this contains functionality for saving each orderLine to
 * a database.
 */
public class OrderLine {

    private static ArrayList<OrderLine> orderedItems = new ArrayList();
    private int productId;
    private int productQuantity;
    private double salePrice;
    private double orderLineTotal;
    private String productName;
    private String salePriceAsString;
    static Path orderFile = Paths.get("C:\\completedOrders\\orders.txt");
    static String record = FileUtility.createStringFormat();
    DecimalFormat df = new DecimalFormat("#.00");

    public OrderLine() {
    }

    public OrderLine(int productId, int productQuantity, double salePrice, String productName) {
        this.productId = productId;
        this.productQuantity = productQuantity;
        this.salePrice = salePrice;
        this.orderLineTotal = salePrice * productQuantity;
        this.productName = productName;
        this.salePriceAsString = df.format(salePrice);
    }

    public String getSalePriceAsString() {
        return salePriceAsString;
    }

    public void setSalePriceAsString(String salePriceAsString) {
        this.salePriceAsString = salePriceAsString;
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

    /**
     * This method will try to save each orderLine to the database, it also
     * calls on a couple methods to update related tables.
     */
    public boolean saveNewOrderLine(int currentOrderId, int userId, OrderForm newOrderForm) {

        //Initial variables, connection, and sql.
        double orderTotal = 0.00;
        boolean wasCustomerBalanceUpdatedSuccessfully = false;
        boolean wasProductTableUpdatedSuccessfully = false;
        Connection conn = null;
        //Setting up a FileChannel object, this will be used to write each orderline to a file.
        FileChannel fc = null;
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
            //If there is no file, one will be created with the proper directory under c://
            if (Files.notExists(orderFile)) {
                FileUtility.createFileIfDoesntExist(orderFile, record);
            }
            fc = (FileChannel) Files.newByteChannel(orderFile, READ, WRITE);

            psNewOrderLineRegistration = conn.prepareStatement(sqlNewOrderLineRegistration, PreparedStatement.RETURN_GENERATED_KEYS);

            //Iterating through the orderLines and setting the variables in the database.
            for (OrderLine orderLine : newOrderForm.getOrderLines()) {
                int prodId = orderLine.getProductId();
                int prodQuantity = orderLine.getProductQuantity();
                double salesPrice = orderLine.getSalePrice();
                double lineTotal = orderLine.getOrderLineTotal();

                psNewOrderLineRegistration.setNull(1, java.sql.Types.INTEGER);
                psNewOrderLineRegistration.setInt(2, currentOrderId);
                psNewOrderLineRegistration.setInt(3, prodId);
                psNewOrderLineRegistration.setInt(4, prodQuantity);
                psNewOrderLineRegistration.setDouble(5, Math.round(salesPrice * 100.0) / 100.0);
                orderTotal += lineTotal;

                psNewOrderLineRegistration.executeUpdate();

                //If the update ran, we can gather the current orderLineId.
                ResultSet rs = psNewOrderLineRegistration.getGeneratedKeys();
                int currentOrderLineId = 0;
                if (rs.next()) {
                    currentOrderLineId = rs.getInt(1);
                }
                //Creating a Product object and updating the product table.
                Product productQuantityUpdate = new Product();
                wasProductTableUpdatedSuccessfully = productQuantityUpdate.updateProductTable(prodId, prodQuantity);

                //Creating an OrderRecord object, this is used for saving to a file.
                OrderRecord orderRecord = new OrderRecord();
                orderRecord.setUserId(userId);
                orderRecord.setOrderId(currentOrderId);
                orderRecord.setOrderLineId(currentOrderLineId);
                orderRecord.setProductId(prodId);
                orderRecord.setOrderLineQuantity(prodQuantity);
                orderRecord.setSalesPrice(Math.round(salesPrice * 100.0) / 100.0);

                //Saving the order to a file, iterating through each orderline.
                FileUtility.saveRecord(orderRecord, fc);
            }
            //Finally we create a CustomerBalance object and update the customer balance.
            CustomerBalance balance = new CustomerBalance();
            wasCustomerBalanceUpdatedSuccessfully = balance.updateCustomerBalance(userId, orderTotal);
        } catch (Exception e) {
            String errorMessage = e.getMessage();
            e.printStackTrace();
            wasProductTableUpdatedSuccessfully = false;
            wasCustomerBalanceUpdatedSuccessfully = false;
        }
        try {
            fc.close();
        } catch (IOException ex) {
            Logger.getLogger(OrderLine.class.getName()).log(Level.SEVERE, null, ex);
        }
        return wasProductTableUpdatedSuccessfully && wasCustomerBalanceUpdatedSuccessfully;
    }
}

package forms;

import business.OrderLine;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.validator.ValidatorForm;

/**
 * @author Ian Mori
 * @since June 9, 2014
 *
 * OrderForm class, the will gather data from the user input from the create
 * order jsp.
 */
public class OrderForm extends ValidatorForm {

    private static ArrayList<OrderLine> orderLines = new ArrayList();

    private int orderLine1Quantity;
    private int orderLine2Quantity;
    private int orderLine3Quantity;
    private int orderLine4Quantity;
    private int orderLine5Quantity;

    private double orderLine1SalePrice;
    private double orderLine2SalePrice;
    private double orderLine3SalePrice;
    private double orderLine4SalePrice;
    private double orderLine5SalePrice;

    private int orderLine1Id;
    private int orderLine2Id;
    private int orderLine3Id;
    private int orderLine4Id;
    private int orderLine5Id;

    private String orderLine1ProductName;
    private String orderLine2ProductName;
    private String orderLine3ProductName;
    private String orderLine4ProductName;
    private String orderLine5ProductName;

    public static ArrayList<OrderLine> getOrderLines() {
        return orderLines;
    }

    public static void setOrderLines(ArrayList<OrderLine> orderLines) {
        OrderForm.orderLines = orderLines;
    }

    public int getOrderLine1Quantity() {
        return orderLine1Quantity;
    }

    public void setOrderLine1Quantity(int orderLine1Quantity) {
        this.orderLine1Quantity = orderLine1Quantity;
    }

    public int getOrderLine2Quantity() {
        return orderLine2Quantity;
    }

    public void setOrderLine2Quantity(int orderLine2Quantity) {
        this.orderLine2Quantity = orderLine2Quantity;
    }

    public int getOrderLine3Quantity() {
        return orderLine3Quantity;
    }

    public void setOrderLine3Quantity(int orderLine3Quantity) {
        this.orderLine3Quantity = orderLine3Quantity;
    }

    public int getOrderLine4Quantity() {
        return orderLine4Quantity;
    }

    public void setOrderLine4Quantity(int orderLine4Quantity) {
        this.orderLine4Quantity = orderLine4Quantity;
    }

    public int getOrderLine5Quantity() {
        return orderLine5Quantity;
    }

    public void setOrderLine5Quantity(int orderLine5Quantity) {
        this.orderLine5Quantity = orderLine5Quantity;
    }

    public double getOrderLine1SalePrice() {
        return orderLine1SalePrice;
    }

    public void setOrderLine1SalePrice(double orederLine1SalePrice) {
        this.orderLine1SalePrice = orederLine1SalePrice;
    }

    public double getOrderLine2SalePrice() {
        return orderLine2SalePrice;
    }

    public void setOrderLine2SalePrice(double orederLine2SalePrice) {
        this.orderLine2SalePrice = orederLine2SalePrice;
    }

    public double getOrderLine3SalePrice() {
        return orderLine3SalePrice;
    }

    public void setOrderLine3SalePrice(double orederLine3SalePrice) {
        this.orderLine3SalePrice = orederLine3SalePrice;
    }

    public double getOrderLine4SalePrice() {
        return orderLine4SalePrice;
    }

    public void setOrderLine4SalePrice(double orederLine4SalePrice) {
        this.orderLine4SalePrice = orederLine4SalePrice;
    }

    public double getOrderLine5SalePrice() {
        return orderLine5SalePrice;
    }

    public void setOrderLine5SalePrice(double orederLine5SalePrice) {
        this.orderLine5SalePrice = orederLine5SalePrice;
    }

    public int getOrderLine1Id() {
        return orderLine1Id;
    }

    public void setOrderLine1Id(int orderLine1Id) {
        this.orderLine1Id = orderLine1Id;
    }

    public int getOrderLine2Id() {
        return orderLine2Id;
    }

    public void setOrderLine2Id(int orderLine2Id) {
        this.orderLine2Id = orderLine2Id;
    }

    public int getOrderLine3Id() {
        return orderLine3Id;
    }

    public void setOrderLine3Id(int orderLine3Id) {
        this.orderLine3Id = orderLine3Id;
    }

    public int getOrderLine4Id() {
        return orderLine4Id;
    }

    public void setOrderLine4Id(int orderLine4Id) {
        this.orderLine4Id = orderLine4Id;
    }

    public int getOrderLine5Id() {
        return orderLine5Id;
    }

    public void setOrderLine5Id(int orderLine5Id) {
        this.orderLine5Id = orderLine5Id;
    }

    public String getOrderLine1ProductName() {
        return orderLine1ProductName;
    }

    public void setOrderLine1ProductName(String orderLine1ProductName) {
        this.orderLine1ProductName = orderLine1ProductName;
    }

    public String getOrderLine2ProductName() {
        return orderLine2ProductName;
    }

    public void setOrderLine2ProductName(String orderLine2ProductName) {
        this.orderLine2ProductName = orderLine2ProductName;
    }

    public String getOrderLine3ProductName() {
        return orderLine3ProductName;
    }

    public void setOrderLine3ProductName(String orderLine3ProductName) {
        this.orderLine3ProductName = orderLine3ProductName;
    }

    public String getOrderLine4ProductName() {
        return orderLine4ProductName;
    }

    public void setOrderLine4ProductName(String orderLine4ProductName) {
        this.orderLine4ProductName = orderLine4ProductName;
    }

    public String getOrderLine5ProductName() {
        return orderLine5ProductName;
    }

    public void setOrderLine5ProductName(String orderLine5ProductName) {
        this.orderLine5ProductName = orderLine5ProductName;
    }

    /**
     * This method will get the total number of orderLines, it checks if there
     * is at least one item ordered for that order line.
     */
    public void getTotalOrderLines() {

        //Clearing the orderLines so the information isn't duplicated.
        orderLines.clear();

        //if the order quantity is over 0, create a new product object, and add it to the arraylist.
        if (getOrderLine1Quantity() > 0) {
            OrderLine orderLine1 = new OrderLine(getOrderLine1Id(), getOrderLine1Quantity(),
                    getOrderLine1SalePrice(), getOrderLine1ProductName());
            orderLines.add(orderLine1);
        }
        if (getOrderLine2Quantity() > 0) {
            OrderLine orderLine2 = new OrderLine(getOrderLine2Id(), getOrderLine2Quantity(),
                    getOrderLine2SalePrice(), getOrderLine2ProductName());
            orderLines.add(orderLine2);
        }
        if (getOrderLine3Quantity() > 0) {
            OrderLine orderLine3 = new OrderLine(getOrderLine3Id(), getOrderLine3Quantity(),
                    getOrderLine3SalePrice(), getOrderLine3ProductName());
            orderLines.add(orderLine3);
        }
        if (getOrderLine4Quantity() > 0) {
            OrderLine orderLine4 = new OrderLine(getOrderLine4Id(), getOrderLine4Quantity(),
                    getOrderLine4SalePrice(), getOrderLine4ProductName());
            orderLines.add(orderLine4);
        }
        if (getOrderLine5Quantity() > 0) {
            OrderLine orderLine5 = new OrderLine(getOrderLine5Id(), getOrderLine5Quantity(),
                    getOrderLine5SalePrice(), getOrderLine5ProductName());
            orderLines.add(orderLine5);
        }
    }

    /**
     * This is the action called from the Struts framework.
     *
     * @param mapping The ActionMapping used to select this instance.
     * @param request The HTTP Request we are processing.
     * @return
     */
    @Override
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        ActionErrors errors = new ActionErrors();

        if (getOrderLine1Quantity() < 0) {
            errors.add("username", new ActionMessage("error.product.1.invalid.amount"));
        }
        if (getOrderLine2Quantity() < 0) {
            errors.add("username", new ActionMessage("error.product.2.invalid.amount"));
        }
        if (getOrderLine3Quantity() < 0) {
            errors.add("username", new ActionMessage("error.product.3.invalid.amount"));
        }
        if (getOrderLine4Quantity() < 0) {
            errors.add("username", new ActionMessage("error.product.4.invalid.amount"));
        }
        if (getOrderLine5Quantity() < 0) {
            errors.add("username", new ActionMessage("error.product.5.invalid.amount"));
        }
        return errors;
    }
}

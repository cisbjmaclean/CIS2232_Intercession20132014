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
 * @author Ian Mori
 * @since June 9, 2014
 *
 * This is the AccountDetilsView class, it will query the database and try and
 * return a user's account details.
 */
public class AccountDetailsView extends ValidatorForm {

    //Initial variables, setters, and getters.
    private ArrayList<AccountDetailsView> accountDetails = new ArrayList();
    private String customerFirstName, customerLastName, customerEmail, customerStreetAddress,
            customerCity, customerProvince, customerPostalCode, customerTelephone;
    private double customerBalance;

    public ArrayList<AccountDetailsView> getAccountDetails() {
        return accountDetails;
    }

    public void setAccountDetails(ArrayList<AccountDetailsView> accountDetails) {
        this.accountDetails = accountDetails;
    }

    public String getCustomerFirstName() {
        return customerFirstName;
    }

    public void setCustomerFirstName(String customerFirstName) {
        this.customerFirstName = customerFirstName;
    }

    public String getCustomerLastName() {
        return customerLastName;
    }

    public void setCustomerLastName(String customerLastName) {
        this.customerLastName = customerLastName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerStreetAddress() {
        return customerStreetAddress;
    }

    public void setCustomerStreetAddress(String customerStreetAddress) {
        this.customerStreetAddress = customerStreetAddress;
    }

    public String getCustomerCity() {
        return customerCity;
    }

    public void setCustomerCity(String customerCity) {
        this.customerCity = customerCity;
    }

    public String getCustomerProvince() {
        return customerProvince;
    }

    public void setCustomerProvince(String customerProvince) {
        this.customerProvince = customerProvince;
    }

    public String getCustomerPostalCode() {
        return customerPostalCode;
    }

    public void setCustomerPostalCode(String customerPostalCode) {
        this.customerPostalCode = customerPostalCode;
    }

    public String getCustomerTelephone() {
        return customerTelephone;
    }

    public void setCustomerTelephone(String customerTelephone) {
        this.customerTelephone = customerTelephone;
    }

    public double getCustomerBalance() {
        return customerBalance;
    }

    public void setCustomerBalance(double customerBalance) {
        this.customerBalance = customerBalance;
    }

    /**
     * This method will return true or false depending on if the account details
     * were retrieved successfully or not from the database.
     *
     * @param userId
     * @return
     */
    public boolean retrieveAccountDetails(int userId) {

        //Setting up initial variables, connection, and sql statement.
        boolean wereAccountDetailsRetrievedSuccessfully = false;
        Connection conn = null;
        try {
            conn = ConnectionUtils.getConnection();
        } catch (Exception ex) {
            Logger.getLogger(Account.class.getName()).log(Level.SEVERE, null, ex);
        }
        PreparedStatement psNewAccountRetrieval = null;
        String sqlNewAccountRetrieval = "SELECT customer_first_name, customer_last_name, customer_email, "
                + "customer_street_address, customer_city, customer_province, customer_postal_code, "
                + "customer_telephone, customer_balance "
                + "FROM customer_tb WHERE customer_id = " + userId;
        try {
            psNewAccountRetrieval = conn.prepareStatement(sqlNewAccountRetrieval);
            ResultSet rs = psNewAccountRetrieval.executeQuery();

            //We only want on result, so if there is a result, we set the variables gathered from the database.
            if (rs.next()) {
                AccountDetailsView newAccountView = new AccountDetailsView();
                newAccountView.setCustomerFirstName(rs.getString(1));
                newAccountView.setCustomerLastName(rs.getString(2));
                newAccountView.setCustomerEmail(rs.getString(3));
                newAccountView.setCustomerStreetAddress(rs.getString(4));
                newAccountView.setCustomerCity(rs.getString(5));
                newAccountView.setCustomerProvince(rs.getString(6));
                newAccountView.setCustomerPostalCode(rs.getString(7));
                newAccountView.setCustomerTelephone(rs.getString(8));
                newAccountView.setCustomerBalance(rs.getDouble(9));
                accountDetails.add(newAccountView);
                wereAccountDetailsRetrievedSuccessfully = true;
            }
        } catch (Exception e) {
            String errorMessage = e.getMessage();
            e.printStackTrace();
            wereAccountDetailsRetrievedSuccessfully = false;
        } finally {
            DbUtils.close(psNewAccountRetrieval, conn);
        }
        return wereAccountDetailsRetrievedSuccessfully;
    }
}

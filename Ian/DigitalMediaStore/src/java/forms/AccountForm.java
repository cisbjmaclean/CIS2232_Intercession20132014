package forms;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.validator.ValidatorForm;

/**
 * @author Ian Mori
 * @since June 9, 2014
 *
 * AccountForm class, the will gather data from the user input from the create
 * account jsp.
 */
public class AccountForm extends ValidatorForm {

    private String customerUsername, customerPassword, customerFirstName, customerLastName, customerEmail,
            customerStreetAddress, customerCity, customerProvince, customerPostalCode, customerTelephone;

    public String getCustomerUsername() {
        return customerUsername;
    }

    public void setCustomerUsername(String customerUsername) {
        this.customerUsername = customerUsername;
    }

    public String getCustomerPassword() {
        return customerPassword;
    }

    public void setCustomerPassword(String customerPassword) {
        this.customerPassword = customerPassword;
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
        this.customerPostalCode = customerPostalCode.replaceAll("\\s+", "").toUpperCase();
    }

    public String getCustomerTelephone() {
        return customerTelephone;
    }

    public void setCustomerTelephone(String customerTelephone) {
        this.customerTelephone = customerTelephone;
    }

    @Override
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        ActionErrors errors = new ActionErrors();

        if (getCustomerFirstName().length() < 1 || getCustomerFirstName() == null) {
            errors.add("firstname", new ActionMessage("error.first.name.invalid"));
        }
        if (getCustomerLastName().length() < 1 || getCustomerLastName() == null) {
            errors.add("lastname", new ActionMessage("error.last.name.invalid"));
        }
        if (getCustomerUsername().length() < 1 || getCustomerUsername() == null) {
            errors.add("username", new ActionMessage("error.username.invalid"));
        }
        if (getCustomerPassword().length() < 1 || getCustomerPassword() == null) {
            errors.add("password", new ActionMessage("error.password.invalid"));
        }
        if (getCustomerStreetAddress().length() < 1 || getCustomerStreetAddress() == null) {
            errors.add("address", new ActionMessage("error.address.invalid"));
        }
        if (getCustomerCity().length() < 1 || getCustomerCity() == null) {
            errors.add("city", new ActionMessage("error.city.invalid"));
        }
        if (getCustomerProvince().length() < 1 || getCustomerProvince() == null) {
            errors.add("province", new ActionMessage("error.province.invalid"));
        }
        if (getCustomerPostalCode().length() < 1 || getCustomerPostalCode() == null) {
            errors.add("postalcode", new ActionMessage("error.postal.code.invalid"));
        }
        if (getCustomerTelephone().length() < 1 || getCustomerTelephone() == null) {
            errors.add("telephone", new ActionMessage("error.telephone.invalid"));
        }
        if (getCustomerEmail().length() < 1 || getCustomerEmail() == null) {
            errors.add("email", new ActionMessage("error.email.invalid"));
        }
        return errors;
    }
}

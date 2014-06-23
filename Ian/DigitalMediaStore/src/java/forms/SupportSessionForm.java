package forms;

import org.apache.struts.validator.ValidatorForm;

/**
 *
 * @author prog
 */
public class SupportSessionForm extends ValidatorForm{

    private String supportSessionDate;
    private String firstName;
    private String email;
    private String supportSessionDescription;

    public String getSupportSessionDate() {
        return supportSessionDate;
    }

    public void setSupportSessionDate(String supportSessionDate) {
        this.supportSessionDate = supportSessionDate;
        System.out.println(this.supportSessionDate);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSupportSessionDescription() {
        return supportSessionDescription;
    }

    public void setSupportSessionDescription(String supportSessionDescription) {
        this.supportSessionDescription = supportSessionDescription;
    }
}

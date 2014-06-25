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
 * SupportSessionForm class, the will gather data from the user input from the
 * create support session jsp.
 */
public class SupportSessionForm extends ValidatorForm {

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

        if (getFirstName().length() < 1 || getFirstName() == null) {
            errors.add("firstname", new ActionMessage("error.first.name.invalid"));
        }
        if (getEmail().length() < 1 || getEmail() == null) {
            errors.add("email", new ActionMessage("error.email.invalid"));
        }
        if (getSupportSessionDate().length() < 1 || getSupportSessionDate() == null) {
            errors.add("supportDate", new ActionMessage("error.support.session.date.invalid"));
        }
        return errors;
    }
}

package forms;

import org.apache.struts.action.ActionForm;

/**
 *
 * @author bjmaclean
 */
public class MenuForm extends ActionForm {

    private String option;

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }
}

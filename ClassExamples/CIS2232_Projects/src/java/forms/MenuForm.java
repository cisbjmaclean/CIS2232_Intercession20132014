

package forms;

import org.apache.struts.action.ActionForm;

/**
 *
 * @author bjmaclean
 */
public class MenuForm extends ActionForm{

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
    private String option = "";
    private String action = "";

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }
    
}

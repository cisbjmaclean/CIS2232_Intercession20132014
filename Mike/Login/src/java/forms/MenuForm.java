package forms;

import org.apache.struts.action.ActionForm;

/**
 *
 * @author Michael Fesser
 * @since 5/25/2014
 * 
 * The purpose of this class is to hold that values from the form on the welcome page. 
 */
public class MenuForm extends ActionForm{
    
    String option = "";

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

}

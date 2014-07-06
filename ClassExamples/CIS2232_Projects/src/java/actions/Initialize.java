package actions;

import business.Student;
import forms.MenuForm;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import util.Util;

/**
 *
 * @author bjmaclean
 */
public class Initialize extends Action {

    public ActionForward execute(
            ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response)
            throws Exception {

        
        
        System.out.println("Initializing");
        Util.resources = ResourceBundle.getBundle("resources.ApplicationResource", Locale.getDefault());

        ActionForward findForward = mapping.findForward("main");
        return findForward;

    }

}

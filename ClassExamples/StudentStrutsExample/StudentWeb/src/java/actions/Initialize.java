package actions;

import business.Student;
import forms.MenuForm;
import java.util.ArrayList;
import java.util.Collection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

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

        System.out.println("Loading the file");
        Student.loadFile(request);
        System.out.println("Loaded the file ("+Student.getStudents().size()+" students loaded)");
        
        ActionForward findForward = mapping.findForward("main");
        return findForward;

    }

}

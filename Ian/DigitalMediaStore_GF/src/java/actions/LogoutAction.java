package actions;

import util.Constants;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * @author Ian Mori
 * @since May 15,2014
 * 
 * Creating logout action class and returning ActionForward.
 */
public class LogoutAction extends Action {

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {

        //Removing user from the session.
        HttpSession session = request.getSession();
        session.removeAttribute(Constants.USER_KEY);
        session.invalidate();
        return (mapping.findForward(Constants.SUCCESS));
    }
}
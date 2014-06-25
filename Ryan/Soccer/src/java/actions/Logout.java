package actions;

import forms.LoginForm;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.CREATE;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import util.ConnectionUtils;

/**
 * @author Ryan
 * 
 * purpose:
 * This class uses the login object and checks to see if it is a match on an 
 * external sheet. depending on the result the user is sent to a designated page.
 */
public class Logout extends Action{
    private static ArrayList<LoginForm> users = new ArrayList();
    
    public ActionForward execute(
            ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response)
            throws Exception {

        
        //Get the option chosen from the user. IMPORTANT
        LoginForm login = (LoginForm) request.getAttribute("loginForm");

        HttpSession session = request.getSession(true);
        try{
            session.removeAttribute("Username");
            session.invalidate();
        }catch(Exception ex){
            System.out.println("Error");
        }
        ActionForward findForward = mapping.findForward("logout");
        
        return findForward;
    }
}

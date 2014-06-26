package actions;


import forms.LoginForm;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import util.ConnectionUtils;

/**
 * @author Ryan
 *
 * This class is used to add a coach. It will check to make sure that someone enters 
 * the same name as another coach and adds them to the database.
 */
public class AddCoach extends Action {

    public static Boolean result = true;
    public static ArrayList<LoginForm> users;

    public ActionForward execute(
            ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response)
            throws Exception {

        //Get the option chosen from the user. IMPORTANT
        LoginForm login = (LoginForm) request.getAttribute("loginForm");
        // for debugging purposes, check to see if it worked.
        System.out.println(login.getUserName());
        result = true;
        checkDoubles(login);
        ActionMessages messages = new ActionMessages();
        ActionForward findForward;
        if (result) {
            loadInfo(login);
            findForward = mapping.findForward("addSuccess");
            messages.add("successCoach", (new ActionMessage("label.coach.success")));
        } else {
            messages.add("failCoach", (new ActionMessage("label.coach.fail")));
            findForward = mapping.findForward("addFail");
        }
        saveMessages(request, messages);
        return findForward;

    }

    public static void loadInfo(LoginForm login) {

        PreparedStatement psAuthenticate = null;
        String sql = null;
        Connection conn = null;
        try {
            conn = ConnectionUtils.getConnection();
        } catch (Exception ex) {
            System.out.println("There was a connection error");
        }

        try {
            // SQL for adding a coach
            sql = "INSERT INTO `user`(`NAME`, `PASSWORD`) VALUES (?,?)";

            psAuthenticate = conn.prepareStatement(sql);
            psAuthenticate.setString(1, login.getUserName());
            psAuthenticate.setString(2, login.getPassword());
            psAuthenticate.executeUpdate();
        } catch (Exception e) {
            String errorMessage = e.getMessage();
            e.printStackTrace();
        }

    }

    public void checkDoubles(LoginForm login) {
        //checks to see if the username already exist..
        users = new ArrayList<>();
        PreparedStatement psAuthenticate = null;
        String sql = null;
        Connection conn = null;
        try {
            conn = ConnectionUtils.getConnection();
        } catch (Exception ex) {
            System.out.println("There was a connection error");
        }

        try {
            sql = "SELECT * FROM `user` ORDER BY `NAME`";

            psAuthenticate = conn.prepareStatement(sql);

            ResultSet rs = psAuthenticate.executeQuery();
            while (rs.next()) {
                //Add fall the users to an arraylist so that they may be compared
                LoginForm tempUser = new LoginForm();

                tempUser.setUserName(rs.getString("NAME"));
                tempUser.setUserID(rs.getInt("USER_ID"));
                tempUser.setPassword(rs.getString("PASSWORD"));

                users.add(tempUser);

            }
            for (LoginForm user : users) {
                if (login.getUserName().equals(user.getUserName())) {
                    result = false;
                }
            }
        } catch (Exception e) {
            String errorMessage = e.getMessage();
            e.printStackTrace();
        }

    }
}

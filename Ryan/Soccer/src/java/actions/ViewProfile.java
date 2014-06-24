package actions;

import field.DateBook;
import field.Field;
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
import util.ConnectionUtils;

/**
 * @author Ryan
 *
 * purpose: This class uses the login object and checks to see if it is a match
 * on an external sheet. depending on the result the user is sent to a
 * designated page.
 */
public class ViewProfile extends Action {

    private static ArrayList<Field> fields;

    public ActionForward execute(
            ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response)
            throws Exception {

        LoginForm login = (LoginForm) request.getSession().getAttribute("loginForm");
        // for debugging purposes, check to see if it worked.
        System.out.println("The user is: " + login.getUserName());
        System.out.println("The user ID is: " + login.getUserID());

        System.out.println("Loading the users fields...");
        fields = new ArrayList();
        loadFromDatabase(login);

        //Have to load the collection into the request.
        ArrayList<Field> theFields = new ArrayList<>(fields);
        request.setAttribute("userFields", fields);
        request.setAttribute("userProfile", login);
        ActionForward findForwardFail = mapping.findForward("viewProfile");
        return findForwardFail;

    }

    public static void loadFromDatabase(LoginForm login) {
        String user = Integer.toString(login.getUserID());
        PreparedStatement psAuthenticate = null;
        String sql = null;
        Connection conn = null;
        try {
            conn = ConnectionUtils.getConnection();
        } catch (Exception ex) {
            System.out.println("There was a connection error");
        }

        try {
            Calendar c = Calendar.getInstance();
            Date dt = c.getTime();
            String modifiedDate = new SimpleDateFormat("yyyy-MM-dd").format(dt);
            
            sql = "SELECT * "
                    + "FROM `booked_field`, `time`, `user`, `field` "
                    + "WHERE booked_field.USER_ID = \"" + user + "\" "
                    + "AND booked_field.DATE >= \"" + modifiedDate + "\"" 
                    + "AND booked_field.TIME_NUM = time.TIME_NUM "
                    + "AND booked_field.USER_ID = user.USER_ID "
                    + "AND booked_field.FIELD_NUM = field.FIELD_NUM"
                    + " ORDER BY booked_field.DATE, booked_field.TIME_NUM ASC";
            psAuthenticate = conn.prepareStatement(sql);

            ResultSet rs = psAuthenticate.executeQuery();
            while (rs.next()) {
                //Add fall the users to an arraylist so that they may be compared
                Field tempField = new Field();

                tempField.setFieldName(rs.getString("FIELD_NAME"));
                tempField.setFieldDate(rs.getString("DATE"));
                tempField.setFieldTime(rs.getString("TIME_DEF"));
                System.out.println("This is the users field: " + tempField.getFieldName());
                fields.add(tempField);

            }
        } catch (Exception e) {
            String errorMessage = e.getMessage();
            e.printStackTrace();
        }

    }
}

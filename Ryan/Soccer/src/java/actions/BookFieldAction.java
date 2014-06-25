package actions;

import field.DateBook;
import field.Field;
import field.Time;
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
 * This class is used to populate the drop down boxes of the book a field page.
 * It access the database to get all the available information needed.
 */
public class BookFieldAction extends Action {

    private static ArrayList<Time> times;
    private static ArrayList<LoginForm> users;
    private static ArrayList<DateBook> dates;
    private static ArrayList<Field> fields;

    private static final int MAX_DAYS_AHEAD = 7;

    public ActionForward execute(
            ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response)
            throws Exception {

        System.out.println("populating drop down boxes for booking a field...");
        times = new ArrayList();
        fields = new ArrayList();
        dates = new ArrayList();
        users = new ArrayList();
        loadInfo();

        //Have to load the collection into the request.
        request.setAttribute("times", times);
        request.setAttribute("fields", fields);
        request.setAttribute("dates", dates);
        request.setAttribute("users", users);

        ActionForward findForward = mapping.findForward("bookSuccess");
        return findForward;

    }

    public static void loadInfo() {

        PreparedStatement psAuthenticate = null;
        String sql = null;
        Connection conn = null;
        try {
            conn = ConnectionUtils.getConnection();
        } catch (Exception ex) {
            System.out.println("There was a connection error");
        }

        try {
            //GETTING THE TIME #######
            sql = "SELECT * "
                    + "FROM `time` "
                    + " ORDER BY TIME_NUM ASC";
            psAuthenticate = conn.prepareStatement(sql);

            ResultSet rs = psAuthenticate.executeQuery();
            while (rs.next()) {

                Time tempTime = new Time();
                tempTime.setTimeDef(rs.getString("TIME_DEF"));
                tempTime.setTimeNum(rs.getInt("TIME_NUM"));
                times.add(tempTime);
            }
            
            //GETTING THE USER #######
            sql = "SELECT * "
                    + "FROM `user` "
                    + " ORDER BY NAME ASC";
            psAuthenticate = conn.prepareStatement(sql);

            rs = psAuthenticate.executeQuery();
            while (rs.next()) {

                LoginForm tempUser = new LoginForm();
                tempUser.setUserID(rs.getInt("USER_ID"));
                tempUser.setUserName(rs.getString("NAME"));
                users.add(tempUser);
            }
            
            //GETTING THE FIELD #######
            sql = "SELECT * "
                    + "FROM `field` "
                    + " ORDER BY FIELD_NUM ASC";
            psAuthenticate = conn.prepareStatement(sql);

            rs = psAuthenticate.executeQuery();
            while (rs.next()) {

                Field tempField = new Field();
                tempField.setFieldName(rs.getString("FIELD_NAME"));
                tempField.setFieldNum(rs.getInt("FIELD_NUM"));
                fields.add(tempField);
            }
            
            //GET THE DATE ##########
            
            
            String modifiedDate;
            Calendar c = Calendar.getInstance();
            Date dt = null;
            
            for (int i = 0; i < MAX_DAYS_AHEAD; i++) {
                dt = c.getTime();
                modifiedDate = new SimpleDateFormat("yyyy-MM-dd").format(dt);
                DateBook tempDate = new DateBook();
                tempDate.setDate(modifiedDate);
                dates.add(tempDate);
                c.setTime(dt);
                
                c.add(Calendar.DATE, 1);
            }
        } catch (Exception e) {
            String errorMessage = e.getMessage();
            e.printStackTrace();
        }

    }
}

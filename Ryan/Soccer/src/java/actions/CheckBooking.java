package actions;

import forms.BookingForm;
import forms.LoginForm;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import util.ConnectionUtils;
import util.DbUtils;

/**
 * @author Ryan
 *
 * purpose: This class uses the login object and checks to see if it is a match
 * on an external sheet. depending on the result the user is sent to a
 * designated page.
 */
public class CheckBooking extends Action {

    private static ArrayList<BookingForm> booking = new ArrayList();

    public ActionForward execute(
            ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response)
            throws Exception {

        //Get the option chosen from the user. IMPORTANT
        BookingForm book = (BookingForm) request.getAttribute("bookingForm");
        
        // for debugging purposes, check to see if it worked.
        System.out.println("Field Number: " + book.getFieldNum());
        System.out.println("User Number: " + book.getUserID());
        System.out.println("Date: " + book.getDate());
        System.out.println("Time: " + book.getTimeNum());

        ActionMessages messages = new ActionMessages();
        
        loadFromDatabase(book);
        if(!checkForMatch(book)){
            System.out.println("The field is not booked at this time... Booking the field..");
            writeToDatabase(book);
            messages.add("success", (new ActionMessage("label.booking.success")));
        }else{
            System.out.println("The field is already booked for this time");
            messages.add("fail", (new ActionMessage("label.booking.fail")));
        }
        saveMessages(request, messages);
        ActionForward findForward = mapping.findForward("bookSuccess");

        return findForward;

    }

    public static void loadFromDatabase(BookingForm book) {

        PreparedStatement psAuthenticate = null;
        String sql = null;
        Connection conn = null;
        try {
            conn = ConnectionUtils.getConnection();
        } catch (Exception ex) {
            System.out.println("There was a connection error");
        }

        try {
            sql = "SELECT * "
                    + "FROM `booked_field`";

            psAuthenticate = conn.prepareStatement(sql);
//            psAuthenticate.setString(1, bookingDate);
            ResultSet rs = psAuthenticate.executeQuery();
            while (rs.next()) {
                //Add fall the users to an arraylist so that they may be compared
                BookingForm tempBook = new BookingForm();

                tempBook.setFieldNum(rs.getInt("FIELD_NUM"));
                tempBook.setUserID(rs.getInt("USER_ID"));
                tempBook.setDate(rs.getString("DATE"));
                tempBook.setTimeNum(rs.getInt("TIME_NUM"));

                booking.add(tempBook);

            }
        } catch (Exception e) {
            String errorMessage = e.getMessage();
            e.printStackTrace();
        }

    }

    private Boolean checkForMatch(BookingForm book) {
        Boolean alreadyBooked = false;
        for (int i = 0; i < booking.size(); i++) {
            if (book.getFieldNum() == booking.get(i).getFieldNum()) {// If field number the same
                if (book.getDate().equals(booking.get(i).getDate())) { // if the date the same
                    if (book.getTimeNum() == booking.get(i).getTimeNum()) { // if time the same
                        alreadyBooked = true;
                    }
                }
            }
        }
        
        return alreadyBooked;
    }

    private void writeToDatabase(BookingForm book) {
        //This method only writes to the database if the field is not already booked
        //at this time.
        PreparedStatement psAuthenticate = null;
        String sql = null;
        Connection conn = null;
        try {
            conn = ConnectionUtils.getConnection();
        } catch (Exception ex) {
            System.out.println(ex);
        }

        /*
         * Setup the sql to insert the row.
         */
        
        try {
            sql = "INSERT INTO `booked_field`(`FIELD_NUM`, `USER_ID`, `DATE`, `TIME_NUM`) VALUES (?,?,?,?)";

            psAuthenticate = conn.prepareStatement(sql);
            psAuthenticate.setInt(1, book.getFieldNum());
            psAuthenticate.setInt(2, book.getUserID());
            psAuthenticate.setString(3, book.getDate());
            psAuthenticate.setInt(4, book.getTimeNum());
            psAuthenticate.executeUpdate();
            //conn.commit();

        } catch (Exception e) {
            String errorMessage = e.getMessage();
            e.printStackTrace();
        } finally {
            DbUtils.close(psAuthenticate, conn);
            System.out.println("field booked successfully");
        }
    }
}

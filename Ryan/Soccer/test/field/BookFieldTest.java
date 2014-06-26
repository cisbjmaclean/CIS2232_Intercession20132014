package field;

import actions.CheckBooking;
import forms.BookingForm;
import forms.LoginForm;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import util.ConnectionUtils;

/**
 *
 * @author Ryan
 * 
 * Purpose: This class test booking a field and making sure that the field is 
 * added to the database. It does this by first counting the database entries 
 * before and after the field has been booked and comparing the numbers to get the 
 * result.
 */
public class BookFieldTest {

    public BookFieldTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void insertBooking() throws Exception {
        int firstCount;
        int secondCount;
        System.out.println("Insert A Booked Field Test");
        LoginForm login = new LoginForm();
        
        BookingForm book = new BookingForm();
        book.setFieldNum(5);
        book.setUserID(2);
        book.setDate("1212-12-12");
        book.setTimeNum(2);
        firstCount = countDatabase();
        //need to make instance to write the temp user to database.
        CheckBooking check = new CheckBooking();
        check.writeToDatabase(book, login);
        secondCount = countDatabase();
        // TODO review the generated test code and remove the default call to fail.
        assertEquals("Answer must equal the same", firstCount + 1, secondCount);
        deleteFromDatabase();//delete after the test results.
    }

    public static void deleteFromDatabase() {
        System.out.println("Deleting the test booked field");
        PreparedStatement psAuthenticate = null;
        String sql = null;
        Connection conn = null;

        try {
            conn = ConnectionUtils.getConnection();
        } catch (Exception ex) {
            System.out.println("There was a connection error");
        }

        try {
            sql = "DELETE FROM `booked_field` WHERE DATE = \"1212-12-12\"";

            psAuthenticate = conn.prepareStatement(sql);
//            psAuthenticate.setString(1, bookingDate);
            psAuthenticate.executeUpdate();

        } catch (Exception e) {
            String errorMessage = e.getMessage();
            e.printStackTrace();
        }

    }

    public static int countDatabase() {
        System.out.println("Counting booking");
        PreparedStatement psAuthenticate = null;
        String sql = null;
        int count = 0;
        Connection conn = null;
        try {
            conn = ConnectionUtils.getConnection();
        } catch (Exception ex) {
            System.out.println("There was a connection error");
        }

        try {
            sql = "SELECT COUNT(*) "
                    + "FROM `booked_field`";

            psAuthenticate = conn.prepareStatement(sql);
//            psAuthenticate.setString(1, bookingDate);
            ResultSet rs = psAuthenticate.executeQuery();
            while (rs.next()) {
                //Add fall the users to an arraylist so that they may be compared
                count = rs.getInt(1);

            }
            
        } catch (Exception e) {
            String errorMessage = e.getMessage();
            e.printStackTrace();
        }
        return count;
    }
}

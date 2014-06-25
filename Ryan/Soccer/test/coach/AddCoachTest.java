package coach;

import actions.AddCoach;
import forms.LoginForm;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
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
 */
public class AddCoachTest {

    public AddCoachTest() {
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
    public void insertCoach() throws Exception {
        int firstCount;
        int secondCount;
        System.out.println("Insert A user test");
        LoginForm user = new LoginForm();
        user.setUserName("9999999999");
        user.setPassword("9999999999");
        firstCount = countDatabase();
        AddCoach.loadInfo(user);
        secondCount = countDatabase();
        // TODO review the generated test code and remove the default call to fail.
        assertEquals("Answer must equal the same", firstCount + 1, secondCount);
        deleteFromDatabase();
    }

    public static void deleteFromDatabase() {
        System.out.println("Deleting the test user");
        PreparedStatement psAuthenticate = null;
        String sql = null;
        Connection conn = null;

        try {
            conn = ConnectionUtils.getConnection();
        } catch (Exception ex) {
            System.out.println("There was a connection error");
        }

        try {
            sql = "DELETE FROM `user` WHERE NAME = \"9999999999\"";

            psAuthenticate = conn.prepareStatement(sql);
//            psAuthenticate.setString(1, bookingDate);
            psAuthenticate.executeUpdate();

        } catch (Exception e) {
            String errorMessage = e.getMessage();
            e.printStackTrace();
        }

    }

    public static int countDatabase() {
        System.out.println("Counting users");
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
                    + "FROM `user`";

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

    private void checkDatabase(LoginForm user) {
        ArrayList<LoginForm> users = new ArrayList<>();
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
            
        } catch (Exception e) {
            String errorMessage = e.getMessage();
            e.printStackTrace();
        }

    }
}


import business.Account;
import business.AccountDetailsView;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import util.ConnectionUtils;

/**
 * @author Ian Mori
 * @since June 24, 2014
 *
 * This is the third test class, it will test viewing account details, gathered
 * from the database.
 */
public class ViewAccountDetailsTest {

    private static AccountDetailsView accountDeatils;

    public ViewAccountDetailsTest() {
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
        //This tear down only needs to run once since it will remove the account from the database.
        int userId = 1;
        Connection conn = null;
        try {
            conn = ConnectionUtils.getConnection();
        } catch (Exception ex) {
            Logger.getLogger(Account.class.getName()).log(Level.SEVERE, null, ex);
        }
        PreparedStatement psProductNameRetrieval = null;
        String sqlProductNameRetrieval = "DELETE FROM customer_tb "
                + "WHERE customer_id = " + userId;
        try {
            psProductNameRetrieval = conn.prepareStatement(sqlProductNameRetrieval);
            psProductNameRetrieval.executeUpdate();

        } catch (Exception e) {
            String errorMessage = e.getMessage();
            e.printStackTrace();
        }
    }

    @Test
    public void testAccountDetailsView() {
        //This test gathers data from the database and confirms that the data retrieved matches the expected outcome.
        accountDeatils = new AccountDetailsView();
        int userId = 1;
        accountDeatils.retrieveAccountDetails(userId);

        String queryResult = "";
        Connection conn = null;
        try {
            conn = ConnectionUtils.getConnection();
        } catch (Exception ex) {
            Logger.getLogger(Account.class.getName()).log(Level.SEVERE, null, ex);
        }
        PreparedStatement psProductNameRetrieval = null;
        String sqlProductNameRetrieval = "SELECT customer_username FROM customer_tb "
                + "WHERE customer_id = " + userId;
        try {
            psProductNameRetrieval = conn.prepareStatement(sqlProductNameRetrieval);
            ResultSet rs = psProductNameRetrieval.executeQuery();

            if (rs.next()) {
                queryResult = rs.getString(1);
            }
        } catch (Exception e) {
            String errorMessage = e.getMessage();
            e.printStackTrace();
        }
        //Using the same user Id of 1, it should query and return the user name entered when creating the account.
        assertEquals("test-username", queryResult);
        tearDown();
    }
}


import business.Account;
import business.ModifyAccountPassword;
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
 * This is the second test class, it will test changing an account password in
 * the database.
 */
public class ModifyAccountTest {

    private ModifyAccountPassword modifyAccount;

    public ModifyAccountTest() {
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

    @Test
    public void testModifyingAccount() {

        //This test will try and change a user's password in the database.
        modifyAccount = new ModifyAccountPassword();
        int userId = 1;
        String password = "modified-test";
        modifyAccount.modifyNewAccount(password, userId);

        String queryResult = "";
        Connection conn = null;
        try {
            conn = ConnectionUtils.getConnection();
        } catch (Exception ex) {
            Logger.getLogger(Account.class.getName()).log(Level.SEVERE, null, ex);
        }
        PreparedStatement psProductNameRetrieval = null;
        String sqlProductNameRetrieval = "SELECT customer_password FROM customer_tb "
                + "WHERE customer_id = " + 1;
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
        //The second query will try and use a user Id of 1, which should match the password used
        //to change the account.
        assertEquals("modified-test", queryResult);
    }
}

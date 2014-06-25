
import business.Account;
import forms.AccountForm;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import util.ConnectionUtils;

/**
 * @author Ian Mori
 * @since June 24, 2014
 *
 * This is the first test class, it will test adding an account to the database.
 */
public class AccountTest {

    private static AccountForm accountForm;

    public AccountTest() {
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
    public void testCreatingNewAccount() {

        accountForm = new AccountForm();
        Account account = new Account();

        accountForm.setCustomerUsername("test-username");
        accountForm.setCustomerPassword("test-password");
        accountForm.setCustomerFirstName("test-first-name");
        accountForm.setCustomerLastName("test-last-name");
        accountForm.setCustomerEmail("test-email@test.com");
        accountForm.setCustomerStreetAddress("test-address");
        accountForm.setCustomerCity("test-city");
        accountForm.setCustomerProvince("PE");
        accountForm.setCustomerPostalCode("c1c1v1");
        accountForm.setCustomerTelephone("9999999999");

        try {
            account.saveNewAccount(accountForm);
        } catch (Exception ex) {
            Logger.getLogger(AccountTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        int queryResult = 0;
        Connection conn = null;
        try {
            conn = ConnectionUtils.getConnection();
        } catch (Exception ex) {
            Logger.getLogger(Account.class.getName()).log(Level.SEVERE, null, ex);
        }
        PreparedStatement psProductNameRetrieval = null;
        String sqlProductNameRetrieval = "SELECT count(*) FROM customer_tb ";
        try {
            psProductNameRetrieval = conn.prepareStatement(sqlProductNameRetrieval);
            ResultSet rs = psProductNameRetrieval.executeQuery();

            if (rs.next()) {
                queryResult = rs.getInt(1);
            }
        } catch (Exception e) {
            String errorMessage = e.getMessage();
            e.printStackTrace();
        }
        assertEquals(1, queryResult);
    }
}

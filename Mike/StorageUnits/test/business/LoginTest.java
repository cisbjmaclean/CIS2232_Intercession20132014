package business;

import forms.LoginForm;
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
import util.DatabaseConnection;
import util.DbUtils;

/**
 *
 * @author Michael Fesser
 */
public class LoginTest {
    
    // The object used for each new connection.
    private DatabaseConnection dbConnection = new DatabaseConnection();
    // Used to allow for more security when sending data to a database.
    private PreparedStatement psAuthenticate;
    private String sql;
    // The connection object.
    private Connection con;
    private ResultSet rs = null;
    private int customerId;
    private String authenticate;
    
    public LoginTest() {
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

    /**
     * Test of checkLogin method, of class Login.
     */
    @Test
    public void testCheckLogin() {
        System.out.println("checkLogin");
        LoginForm validateLogin = new LoginForm();
        Login instance = new Login();
        String expResult = "customer";
        
        validateLogin.setUsername("BJ");
        validateLogin.setPassword("password");
        
        String result = "none";
        
        try {
            result = instance.checkLogin(validateLogin);
        } catch (Exception ex) {
            Logger.getLogger(LoginTest.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        assertEquals(expResult, result);      
    }

    /**
     * Test of checkAdminLogin method, of class Login.
     */
    @Test
    public void testCheckAdminLogin() {
        System.out.println("checkAdminLogin");
        LoginForm validateLogin = new LoginForm();
        Login instance = new Login();
        String expResult = "admin";
        validateLogin.setUsername("admin.pyrolight");
        validateLogin.setPassword("password");
        
        String result = "none";
        try {
            result = instance.checkAdminLogin(validateLogin);
        } catch (Exception ex) {
            Logger.getLogger(LoginTest.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        assertEquals(expResult, result);      
    }
    
        /**
     * This method retrieves data from the database.
     *
     * @param validateLogin
     * @return
     */
    public String checkLogin(LoginForm validateLogin) {

        // Try to connect to the database.
        try {
            con = dbConnection.databaseConnection();
        } catch (Exception e) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, e);
            System.err.println("The connection to the database failed.");
        }

        // Try to generate the query.
        try {
            // The query to send.         
            sql = "SELECT `cus_id` FROM `customer_login` WHERE `cus_login_username` = ? AND `cus_login_password` = ?";
            psAuthenticate = con.prepareStatement(sql);
            psAuthenticate.setString(1, validateLogin.getUsername());
            psAuthenticate.setString(2, validateLogin.getPassword());
            // Send the query and get the results back.
            rs = psAuthenticate.executeQuery();
            // Iterate over the result set.
            while (rs.next()) {
                customerId = rs.getInt("cus_id");
                validateLogin.setCustomerId(customerId);
                validateLogin.setValidated(true);
                authenticate = "customer";
            }
        } catch (Exception e) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, e);
            System.err.println("There was an issue with the query.");
        } finally {
            // Close the result set, psAuthenicate,  and the connection objects.
            DbUtils.close(rs, psAuthenticate, con);
        }
        return authenticate;
    }

    public String checkAdminLogin(LoginForm validateLogin) {
        // Try to connect to the database.
        try {
            con = dbConnection.databaseConnection();
        } catch (Exception e) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, e);
            System.err.println("The connection to the database failed.");
        }

        // Try to generate the query.
        try {
            int adminCode;

            // The query to send.         
            sql = "SELECT `admin_login_code` FROM `admin_login` WHERE `admin_login_username` = ? AND `admin_login_password` = ?";
            psAuthenticate = con.prepareStatement(sql);
            psAuthenticate.setString(1, validateLogin.getUsername());
            psAuthenticate.setString(2, validateLogin.getPassword());
            // Send the query and get the results back.
            rs = psAuthenticate.executeQuery();

            // Iterate over the result set.
            while (rs.next()) {
                adminCode = rs.getInt("admin_login_code");
                validateLogin.setAdminCode(adminCode);
                validateLogin.setValidated(true);
                authenticate = "admin";
            }
        } catch (Exception e) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, e);
            System.err.println("There was an issue with the query.");
        } finally {
            // Close the result set, psAuthenicate,  and the connection objects.
            DbUtils.close(rs, psAuthenticate, con);
        }
        return authenticate;
    }
}



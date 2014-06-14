package business;

import forms.LoginForm;
import forms.ReserveUnitForm;
import forms.StorageUnitForm;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import util.DatabaseConnection;
import util.DbUtils;
import util.SortUnits;

/**
 *
 * @author Michael
 * @since Jun 13, 2014
 */
public class ReserveUnit {

    // The object used for each new connection.
    private DatabaseConnection dbConnection = new DatabaseConnection();
    // Used to allow for more security when sending data to a database.
    private PreparedStatement psAuthenticate;
    private String sql;
    // The connection object.
    private Connection con;
    private LoginForm user;
    private ReserveUnitForm reserveUnit;
    private DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
    private Calendar calendar = Calendar.getInstance();
    private String dateFrom;
    private String dateTo;

    public void reserveUnit(HttpServletRequest request) {
        // Try to connect to the database.  
        try {
            con = dbConnection.databaseConnection();
        } catch (Exception e) {
            Logger.getLogger(AddUser.class.getName()).log(Level.SEVERE, null, e);
            System.err.println("The connection to the database failed.");
        }

        // Try to generate the query.
        try {
            user = (LoginForm) request.getSession().getAttribute("user");
            reserveUnit = (ReserveUnitForm) request.getAttribute("reserveUnitForm");
            dateFrom = dateFormat.format(calendar.getTime());
            dateTo = reserveUnit.getDateTo();

            // The query to send.
            sql = "INSERT INTO `customer_unit`(`unit_id`, `cus_id`) VALUES (?,?)";
            // Added security for the fields being sent to the database.
            psAuthenticate = con.prepareStatement(sql);
            psAuthenticate.setInt(1, reserveUnit.getUnitId());
            psAuthenticate.setInt(2, user.getCustomerId());
            // Run the query.
            psAuthenticate.executeUpdate();
            
            // The query to send.
            sql = "UPDATE `unit` SET `unit_avalibility`= ?,`unit_date_from`= ?,`unit_date_to`= ? WHERE `unit_id` = ?";
            // Added security for the fields being sent to the database.
            psAuthenticate = con.prepareStatement(sql);
            psAuthenticate.setInt(1, 0);
            psAuthenticate.setString(2, dateFrom);
            psAuthenticate.setString(3, dateTo);
            psAuthenticate.setInt(4, reserveUnit.getUnitId());
            // Run the query.
            psAuthenticate.executeUpdate();
    
        } catch (Exception e) {
            Logger.getLogger(AddUser.class.getName()).log(Level.SEVERE, null, e);
            System.err.println("There was an issue with the query.");
        } finally {
            // Close psAuthenicate,  and the connection objects.
            DbUtils.close(psAuthenticate, con);
        }
        setUnitDate();
        SortUnits.compare(LoadStorageUnits.getStorageUnits());
    }

    public void setUnitDate() {
        for (StorageUnitForm unit : LoadStorageUnits.getStorageUnits()) {
            if (unit.getUnitId() == reserveUnit.getUnitId()) {
                unit.setCustomerId(user.getCustomerId());
                unit.setUnitDateFrom(dateFrom);
                unit.setUnitDateTo(dateTo);
            }
        }
    }
}

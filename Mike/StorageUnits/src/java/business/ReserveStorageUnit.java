package business;

import forms.StorageUnitForm;
import forms.LoginForm;
import forms.ReserveStorageUnitForm;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import util.DatabaseConnection;
import util.DbUtils;
import util.SortStorageUnits;

/**
 *
 * @author Michael
 * @since Jun 13, 2014
 */
public class ReserveStorageUnit {

    // The object used for each new connection.
    private DatabaseConnection dbConnection = new DatabaseConnection();
    // Used to allow for more security when sending data to a database.
    private PreparedStatement psAuthenticate;
    private String sql;
    // The connection object.
    private Connection con;
    private LoginForm user;
    private ReserveStorageUnitForm reserveUnit;
    private DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
    private Calendar calendar = Calendar.getInstance();
    private String dateFrom;
    private String dateTo;
    private ArrayList<StorageUnitForm> storageUnits;
    
    public void reserveUnit(HttpServletRequest request) {
        // Try to connect to the database.  
        try {
            con = dbConnection.databaseConnection();
        } catch (Exception e) {
            Logger.getLogger(AddCustomer.class.getName()).log(Level.SEVERE, null, e);
            System.err.println("The connection to the database failed.");
        }

        // Try to generate the query.
        try {
            user = (LoginForm) request.getSession().getAttribute("customer");
            reserveUnit = (ReserveStorageUnitForm) request.getAttribute("reserveStorageUnitForm");
            dateFrom = dateFormat.format(calendar.getTime());
            dateTo = reserveUnit.getDateTo();
            // The query to send.
            sql = "INSERT INTO `customer_storage_unit`(`storage_unit_id`, `cus_id`) VALUES (?,?)";
            // Added security for the fields being sent to the database.
            psAuthenticate = con.prepareStatement(sql);
            psAuthenticate.setInt(1, reserveUnit.getUnitId());
            psAuthenticate.setInt(2, user.getCustomerId());
            // Run the query.
            psAuthenticate.executeUpdate();

            // The query to send.
            sql = "UPDATE `storage_unit` SET `storage_unit_availability`= ?,`storage_unit_date_from`= ?,`storage_unit_date_to`= ? WHERE `storage_unit_id` = ?";
            // Added security for the fields being sent to the database.
            psAuthenticate = con.prepareStatement(sql);
            psAuthenticate.setInt(1, 0);
            psAuthenticate.setString(2, dateFrom);
            psAuthenticate.setString(3, dateTo);
            psAuthenticate.setInt(4, reserveUnit.getUnitId());
            // Run the query.
            psAuthenticate.executeUpdate();
            
        } catch (Exception e) {
            Logger.getLogger(AddCustomer.class.getName()).log(Level.SEVERE, null, e);
            System.err.println("There was an issue with the query.");
        } finally {
            // Close psAuthenicate,  and the connection objects.
            DbUtils.close(psAuthenticate, con);
        }
        storageUnits = (ArrayList<StorageUnitForm>) request.getSession().getAttribute("storageUnits");
        setUnit(storageUnits);
        SortStorageUnits.sortDefault(request, storageUnits);
    }
    
    public void extendUnit(HttpServletRequest request) {
        // Try to connect to the database.  
        try {
            con = dbConnection.databaseConnection();
        } catch (Exception e) {
            Logger.getLogger(AddCustomer.class.getName()).log(Level.SEVERE, null, e);
            System.err.println("The connection to the database failed.");
        }

        // Try to generate the query.
        try {
            user = (LoginForm) request.getSession().getAttribute("customer");
            reserveUnit = (ReserveStorageUnitForm) request.getAttribute("reserveStorageUnitForm");
            dateFrom = dateFormat.format(calendar.getTime());
            dateTo = reserveUnit.getDateTo();

            // The query to send.
            sql = "UPDATE `storage_unit` SET `storage_unit_date_to`= ? WHERE `storage_unit_id` = ?";
            // Added security for the fields being sent to the database.
            psAuthenticate = con.prepareStatement(sql);
            psAuthenticate.setString(1, dateTo);
            psAuthenticate.setInt(2, reserveUnit.getUnitId());
            // Run the query.
            psAuthenticate.executeUpdate();
            
        } catch (Exception e) {
            Logger.getLogger(AddCustomer.class.getName()).log(Level.SEVERE, null, e);
            System.err.println("There was an issue with the query.");
        } finally {
            // Close psAuthenicate,  and the connection objects.
            DbUtils.close(psAuthenticate, con);
        }
        storageUnits = (ArrayList<StorageUnitForm>) request.getSession().getAttribute("storageUnits");
        setUnit(storageUnits);
        SortStorageUnits.sortDefault(request, storageUnits);
    }
    
    public void setUnit(ArrayList<StorageUnitForm> storageUnits) {
        for (StorageUnitForm storageUnit : storageUnits) {
            if (storageUnit.getUnitId() == reserveUnit.getUnitId()) {
                storageUnit.setCustomerId(user.getCustomerId());
                storageUnit.setUnitDateFrom(dateFrom);
                storageUnit.setUnitDateTo(dateTo);
            }
        }
    }
}

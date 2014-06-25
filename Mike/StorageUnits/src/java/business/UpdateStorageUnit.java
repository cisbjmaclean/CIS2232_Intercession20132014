package business;

import forms.LoginForm;
import forms.ReserveStorageUnitForm;
import forms.StorageUnitForm;
import forms.StorageUnitInUseToggleForm;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import util.DatabaseConnection;
import util.DbUtils;


/**
 *
 * @author Michael
 * @since Jun 21, 2014
 */
public class UpdateStorageUnit {

    // The object used for each new connection.
    private DatabaseConnection dbConnection = new DatabaseConnection();
    // Used to allow for more security when sending data to a database.
    private PreparedStatement psAuthenticate;
    private String sql;
    // The connection object.
    private Connection con;
    private LoginForm user;
    private ReserveStorageUnitForm extendUnit;
    private StorageUnitInUseToggleForm storageUnitToggle;
    private DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
    private Calendar calendar = Calendar.getInstance();
    private String dateFrom;
    private String dateTo;
    private int storageUnitToggleValue;
    private ArrayList<StorageUnitForm> storageUnits;

    public void extendUnit(HttpServletRequest request) throws Exception {
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
            extendUnit = (ReserveStorageUnitForm) request.getAttribute("reserveStorageUnitForm");
            dateFrom = dateFormat.format(calendar.getTime());
            dateTo = extendUnit.getDateTo();

            // The query to send.
            sql = "UPDATE `storage_unit` SET `storage_unit_date_to`= ? WHERE `storage_unit_id` = ?";
            // Added security for the fields being sent to the database.
            psAuthenticate = con.prepareStatement(sql);
            psAuthenticate.setString(1, dateTo);
            psAuthenticate.setInt(2, extendUnit.getUnitId());
            // Run the query.
            psAuthenticate.executeUpdate();

        } catch (Exception e) {
            Logger.getLogger(AddCustomer.class.getName()).log(Level.SEVERE, null, e);
            throw new Exception();
        } finally {
            // Close psAuthenicate,  and the connection objects.
            DbUtils.close(psAuthenticate, con);
        }
        storageUnits = (ArrayList<StorageUnitForm>) request.getSession().getAttribute("storageUnits");
        setUnitExtend();
       // SortStorageUnits.sortDefault(request, storageUnits);
    }

    public void setStorageUnitInUse(HttpServletRequest request) throws Exception {
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
            storageUnitToggle = (StorageUnitInUseToggleForm) request.getAttribute("storageUnitInUseToggleForm");
            
            if (storageUnitToggle.getStorageUnitToggle() == 0) {
                storageUnitToggleValue = 1;
            } else {
                storageUnitToggleValue = 0;
            }

            // The query to send.
            sql = "UPDATE `storage_unit` SET `storage_unit_in_use`= ? WHERE `storage_unit_id` = ?";
            // Added security for the fields being sent to the database.
            psAuthenticate = con.prepareStatement(sql);
            psAuthenticate.setInt(1, storageUnitToggleValue);
            psAuthenticate.setInt(2, storageUnitToggle.getUnitId());
            // Run the query.
            psAuthenticate.executeUpdate();

        } catch (Exception e) {
            Logger.getLogger(AddCustomer.class.getName()).log(Level.SEVERE, null, e);
            throw new Exception();        
        } finally {
            // Close psAuthenicate,  and the connection objects.
            DbUtils.close(psAuthenticate, con);
        }
        storageUnits = (ArrayList<StorageUnitForm>) request.getSession().getAttribute("storageUnits");
        setUnitUseToggle();
       // SortStorageUnits.sortDefault(request, storageUnits);
    }

    public void setUnitExtend() {
        for (StorageUnitForm storageUnit : storageUnits) {
            if (storageUnit.getUnitId() == extendUnit.getUnitId()) {
                storageUnit.setCustomerId(user.getCustomerId());
                storageUnit.setUnitDateFrom(dateFrom);
                storageUnit.setUnitDateTo(dateTo);
            }
        }
    }
    
    public void setUnitUseToggle() {
        for (StorageUnitForm storageUnit : storageUnits) {
            if (storageUnit.getUnitId() == storageUnitToggle.getUnitId()) {
                 storageUnit.setUnitInUse(storageUnitToggleValue);
            }
        }
    }
}

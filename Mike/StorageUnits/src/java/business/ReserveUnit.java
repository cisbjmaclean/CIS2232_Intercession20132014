/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import forms.LoginForm;
import forms.ReserveUnitForm;
import forms.StorageUnitForm;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.swing.JOptionPane;
import util.DatabaseConnection;
import util.DbUtils;

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
    private ArrayList<StorageUnitForm> units;
    private LoginForm user;
    private DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    private Calendar calander = Calendar.getInstance();

    public void releaseUnit(ReserveUnitForm reserve, HttpServletRequest request) {
        // Try to connect to the database.  
        try {
            con = dbConnection.databaseConnection();
        } catch (Exception e) {
            Logger.getLogger(AddUser.class.getName()).log(Level.SEVERE, null, e);
            System.err.println("The connection to the database failed.");
        }

        // Try to generate the query.
        try {
            units = (ArrayList<StorageUnitForm>) request.getSession().getAttribute("storageUnit");
            user = (LoginForm) request.getSession().getAttribute("user");
            // The query to send.
            sql = "INSERT INTO `customer_unit`(`unit_id`, `cus_id`) VALUES ?,?";
            // Added security for the fields being sent to the database.
            psAuthenticate = con.prepareStatement(sql);
            psAuthenticate.setInt(1, reserve.getUnitId());
            psAuthenticate.setInt(2, user.getCustomerId());
            // Run the query.
            psAuthenticate.executeUpdate();
        } catch (Exception e) {
            Logger.getLogger(AddUser.class.getName()).log(Level.SEVERE, null, e);
            System.err.println("There was an issue with the query.");
        } finally {
            // Close psAuthenicate,  and the connection objects.
            DbUtils.close(psAuthenticate, con);
        }
        String unitToDate = getUnitFromToDate();

        for (StorageUnitForm unit : units) {
            if (unit.getUnitId() == reserve.getUnitId()) {
                unit.setCustomerId(user.getCustomerId());
                unit.setUnitDateFrom(dateFormat.format(calander.getTime()));
            }
        }
    }

    public String getUnitFromToDate() {      
        int month = Integer.parseInt(JOptionPane.showInputDialog("Please enter the month you would like to book the unit to."
                + "\n Please enter digits ie. 11 for"));
        int day = Integer.parseInt(JOptionPane.showInputDialog(this));
        int year = Integer.parseInt(JOptionPane.showInputDialog(this));
        return null;
    }
}

package util;

import java.sql.Connection;
import java.sql.DriverManager;
import org.apache.struts.util.MessageResources;

/**
 *
 * @author Michael Fesser
 * @since 5/30/2014
 *
 * This class establishes the connection to the database.
 */
public class DatabaseConnection {

    private MessageResources messages = MessageResources.getMessageResources("util.DatabaseResources");
    // Fields store the database information.
    private final String USER_NAME = messages.getMessage("db.user");
    private final String PASSWORD = messages.getMessage("db.password");
    private final String DATABASE = messages.getMessage("db.name");
    private final String HOST = messages.getMessage("db.host");
    private String URL = null;
    private final String DRIVER = "com.mysql.jdbc.Driver";
    // The connection object.
    private Connection con = null;

    /**
     * This method established the connection to the database.
     *
     * @return
     */
    public Connection databaseConnection() {
        try {
            // Mystical Java syntax that I can use but don't really understand.
            Class.forName(DRIVER).newInstance();
            // Overly complicated way of connecting to the localhost.
            URL = "jdbc:mysql://" + HOST + ":3306/" + DATABASE;
            // Inform user the connection is taking place.
            System.out.println("Connecting to the database " + DATABASE + " on the host " + HOST + ".");
            // Send details to make connection to the database.
            con = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
        } catch (Exception e) {
            System.err.println("Could not establish a connection to the database " + DATABASE + " on the host " + HOST + ".");
        }
        return con;
    }
}

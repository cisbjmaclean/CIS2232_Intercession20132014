package business;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.struts.validator.ValidatorForm;
import util.ConnectionUtils;
import util.DbUtils;

/**
 * @author Ian Mori
 * @since June 9, 2014
 *
 * The SupportSessionView class, this class has functionality for gathering a
 * user's support sessions.
 */
public class SupportSessionView extends ValidatorForm {

    private ArrayList<SupportSessionView> supportSessions = new ArrayList();
    private int supportSessionId;
    private String supportSessionDate;

    public ArrayList<SupportSessionView> getSupportSessions() {
        return supportSessions;
    }

    public void setSupportSessions(ArrayList<SupportSessionView> supportSessions) {
        this.supportSessions = supportSessions;
    }

    public int getSupportSessionId() {
        return supportSessionId;
    }

    public void setSupportSessionId(int supportSessionId) {
        this.supportSessionId = supportSessionId;
    }

    public String getSupportSessionDate() {
        return supportSessionDate;
    }

    public void setSupportSessionDate(String supportSessionDate) {
        this.supportSessionDate = supportSessionDate;
    }

    /**
     * This method will create gather a user's support sessions from the
     * database or return an error.
     */
    public boolean retrieveSupportSessions(int userId) {
        //Setting up initial variables, connection, and sql statement.
        boolean wereSupportSessionsRetrievedSuccessfully = false;
        Connection conn = null;
        try {
            conn = ConnectionUtils.getConnection();
        } catch (Exception ex) {
            Logger.getLogger(Account.class.getName()).log(Level.SEVERE, null, ex);
        }
        PreparedStatement psNewSupportSessionRetrieval = null;
        String sqlNewSupportSessionRetrieval = "SELECT support_session_id, support_session_date "
                + "FROM support_session_tb WHERE customer_id = " + userId;
        try {
            psNewSupportSessionRetrieval = conn.prepareStatement(sqlNewSupportSessionRetrieval);
            ResultSet rs = psNewSupportSessionRetrieval.executeQuery();

            //Clear the arraylist so incorrect information isn't showing.
            supportSessions.clear();

            while (rs.next()) {
                //While there are results, create an onject, set the variables for the object, and add the object
                //to the arraylist.
                SupportSessionView supportSession = new SupportSessionView();
                supportSession.setSupportSessionId(rs.getInt(1));
                supportSession.setSupportSessionDate(rs.getString(2));
                supportSessions.add(supportSession);
            }
            wereSupportSessionsRetrievedSuccessfully = true;
        } catch (Exception e) {
            String errorMessage = e.getMessage();
            e.printStackTrace();
            wereSupportSessionsRetrievedSuccessfully = false;
        } finally {
            DbUtils.close(psNewSupportSessionRetrieval, conn);
        }
        return wereSupportSessionsRetrievedSuccessfully;
    }
}

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
 *
 * @author prog
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

    public boolean retrieveSupportSessions(int userId) {

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
            supportSessions.clear();

            while (rs.next()) {
                SupportSessionView supportSession = new SupportSessionView();
                supportSession.setSupportSessionId(rs.getInt(1)); //this is needed only once
                supportSession.setSupportSessionDate(rs.getString(2)); //this is needed only once
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

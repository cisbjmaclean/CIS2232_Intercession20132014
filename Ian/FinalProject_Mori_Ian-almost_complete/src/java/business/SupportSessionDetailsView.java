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
public class SupportSessionDetailsView extends ValidatorForm {

    private ArrayList<SupportSessionDetailsView> supportSessionDetails = new ArrayList();

    private String firstName;
    private String email;
    private int supportSession_Id;
    private String supportSessionDate;
    private String supportSessionDescription;

    public ArrayList<SupportSessionDetailsView> getSupportSessionDetails() {
        return supportSessionDetails;
    }

    public void setSupportSessionDetails(ArrayList<SupportSessionDetailsView> supportSessionDetails) {
        this.supportSessionDetails = supportSessionDetails;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getSupportSession_Id() {
        return supportSession_Id;
    }

    public void setSupportSession_Id(int supportSession_Id) {
        this.supportSession_Id = supportSession_Id;
    }

    public String getSupportSessionDate() {
        return supportSessionDate;
    }

    public void setSupportSessionDate(String supportSessionDate) {
        this.supportSessionDate = supportSessionDate;
    }

    public String getSupportSessionDescription() {
        return supportSessionDescription;
    }

    public void setSupportSessionDescription(String supportSessionDescription) {
        this.supportSessionDescription = supportSessionDescription;
    }

    public boolean retrieveSupportSessionDetails() {

        boolean wereSupportSessionDetailsRetrievedSuccessfully = false;
        Connection conn = null;
        try {
            conn = ConnectionUtils.getConnection();
        } catch (Exception ex) {
            Logger.getLogger(Account.class.getName()).log(Level.SEVERE, null, ex);
        }
        PreparedStatement psNewSupportSessionRetrieval = null;
        String sqlNewSupportSessionRetrieval = "SELECT first_name, email, "
                + "support_session_date, support_session_description "
                + "FROM support_session_tb WHERE support_session_id = " + getSupportSession_Id();
        try {
            psNewSupportSessionRetrieval = conn.prepareStatement(sqlNewSupportSessionRetrieval);
            ResultSet rs = psNewSupportSessionRetrieval.executeQuery();

            if (rs.next()) {
                SupportSessionDetailsView supportSessionDetailsView = new SupportSessionDetailsView();
                supportSessionDetailsView.setFirstName(rs.getString(1)); //this is needed only once
                supportSessionDetailsView.setEmail(rs.getString(2)); //this is needed only once
                supportSessionDetailsView.setSupportSessionDate(rs.getString(3)); //this is needed only once
                supportSessionDetailsView.setSupportSessionDescription(rs.getString(4)); //this is needed only once
                supportSessionDetails.add(supportSessionDetailsView);
                wereSupportSessionDetailsRetrievedSuccessfully = true;
            }
        } catch (Exception e) {
            String errorMessage = e.getMessage();
            e.printStackTrace();
            wereSupportSessionDetailsRetrievedSuccessfully = false;
        } finally {
            DbUtils.close(psNewSupportSessionRetrieval, conn);
        }
        return wereSupportSessionDetailsRetrievedSuccessfully;
    }
}

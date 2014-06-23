package actions;

import forms.LoginForm;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.CREATE;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import util.ConnectionUtils;

/**
 * @author Ryan
 * 
 * purpose:
 * This class uses the login object and checks to see if it is a match on an 
 * external sheet. depending on the result the user is sent to a designated page.
 */
public class CheckLogin extends Action{
    private static ArrayList<LoginForm> users = new ArrayList();
    
    public ActionForward execute(
            ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response)
            throws Exception {

        
        //Get the option chosen from the user. IMPORTANT
        LoginForm login = (LoginForm) request.getAttribute("loginForm");
        // for debugging purposes, check to see if it worked.
        System.out.println(login.getUserName());
        System.out.println(login.getUserID());
        System.out.println(login.getPassword());
        
        loadFromDatabase(login);
        
        ActionForward findForward = mapping.findForward("success");
        
        for(int i = 0; i < users.size(); i++){
            if(login.getUserName().equals(users.get(i).getUserName())){
                if(login.getPassword().equals(users.get(i).getPassword())){
                    request.getSession().setAttribute("loginForm", users.get(i));
                    writeToFile(true, login);
                    return findForward;
                }
            }
        }
        writeToFile(false, login);
        ActionForward findForwardFail = mapping.findForward("loginFail");
        return findForwardFail;

    }
    
    public static void loadFromDatabase(LoginForm login) {
        
        PreparedStatement psAuthenticate = null;
        String sql = null;
        Connection conn=null;
        try {
            conn = ConnectionUtils.getConnection();
        } catch (Exception ex) {
            System.out.println("There was a connection error");
        }
        
        try {
            sql = "SELECT * FROM `user` ORDER BY `NAME`";
            System.out.println("#############################################RIGHT HERE LOOOOOOOKKKK");
            psAuthenticate = conn.prepareStatement(sql);
//            psAuthenticate.setString(1, bookingDate);
            ResultSet rs = psAuthenticate.executeQuery();
            while (rs.next()) {
                //Add fall the users to an arraylist so that they may be compared
                LoginForm tempUser = new LoginForm();
                
                tempUser.setUserName(rs.getString("NAME"));
                tempUser.setUserID(rs.getInt("USER_ID"));
                tempUser.setPassword(rs.getString("PASSWORD"));
                
                users.add(tempUser);
               
            }
        } catch (Exception e) {
            String errorMessage = e.getMessage();
            e.printStackTrace();
        }

    }

    private void writeToFile(boolean b, LoginForm user) {
        String determine= "";
        if(b){
            determine = "Successful login: ";
        }else{
            determine = "Login has failed using: ";
        }
        
        String timeStamp = new SimpleDateFormat("yyyy, MM, dd : HH:mm:ss").format(Calendar.getInstance().getTime());
        
        String line =  determine + user.getUserName() + ", " + user.getPassword() + "Time Stamp: " + timeStamp + System.getProperty("line.separator");
        //used for writing to the file when logging in.
        Path path = Paths.get("c:\\cis2232\\loginInformation.txt");
        File f = new File("c:\\cis2232\\loginInformation.txt");
        byte[] data = line.getBytes();
        OutputStream output = null;
        try{
            output = new BufferedOutputStream(Files.newOutputStream(path, CREATE, APPEND));
            output.write(data);
            
            output.flush();
            output.close();
        }catch(Exception e){
            System.err.println("There was an error writing to the file: " + e);
        }
    }
}

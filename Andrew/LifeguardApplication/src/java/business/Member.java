/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package business;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.CREATE;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author areid31891
 */
public class Member {
    private String username;
    private int memberId, memberType;
    
    public Member(){
        
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public int getMemberType() {
        return memberType;
    }

    public void setMemberType(int memberType) {
        this.memberType = memberType;
    }
    //this method writes each successful login to a file. The username and timestamp at the login time are saved
    public static void userLoginLog(String username){
        Path path = Paths.get("c:\\cis2232\\lifeguard_login_log.txt");
        OutputStream output;
        BufferedWriter writer = null;
        
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy h:mm:ss a");
        String formattedDate = sdf.format(date);

        String toWrite = username+" logged in at "+formattedDate;
        
        try {
            output = new BufferedOutputStream(Files.newOutputStream(path, CREATE, APPEND));
            writer = new BufferedWriter(new OutputStreamWriter(output));
            
            writer.write(toWrite);
            writer.newLine();
            writer.flush();
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(Member.class.getName()).log(Level.SEVERE, null, ex);
        }
        
            
    }
    
    
}

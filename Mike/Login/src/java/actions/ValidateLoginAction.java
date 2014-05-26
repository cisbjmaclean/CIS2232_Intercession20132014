package actions;

import forms.ValidateLogin;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author Michael Fesser
 * @since 5/25/2014
 * 
 * The purpose of this class is to load and validate the password file.  
 */
public class ValidateLoginAction extends Action {
    
    // Set path.
    private Path filepath = Paths.get("C:\\test\\access.txt");
    // Hashmap to store the file.
    private HashMap<String, String> validate = new HashMap();
    // Flag for login access.
    private boolean access = false;

    /**
     * This method gets the fields from the login page and calls the functions that 
     * validate them vs the password file.
     * 
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception 
     */
     public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        // Create the object that holds the fields from the login page.
        ValidateLogin validateLogin = (ValidateLogin) form;
        // Used to define the page to be forwarded to.
        ActionForward findForward = mapping.findForward("welcome");
        loadFile();
        compare(validateLogin);
        // Empty the HashMap.
        validate.clear();
        // If login credentials are valid continue otherwise return to the login page.
        if (access) {
            findForward = mapping.findForward("loggedIn");
        } else {
            findForward = mapping.findForward("login");
        }         
        return findForward;
    }
     
     /**
      *  This loads the file that holds the valid login credentials.
      */
     public void loadFile() {
        // Used as a delimiter.
        String delimiter = "\\*";
        String records = "";
        // Initialize the array used to temporarily store the records.
        String[] recordsArray = new String[2];
        // Try to load the data from the file.
        try {
            // Initialize the objects that will read from the file.
            InputStream inputFile = new BufferedInputStream(Files.newInputStream(filepath));
            BufferedReader readFile = new BufferedReader(new InputStreamReader(inputFile));
            System.out.println();
            records = readFile.readLine();

            // Read the file while there are records.
            while (records != null) {
                recordsArray = records.split(delimiter);
                validate.put(recordsArray[0], recordsArray[1]);
                records = readFile.readLine();
            }
          // Catch any IO errors and exit program.
        } catch (IOException io) {
            System.err.println("There was an error retrieving the file at " + filepath.toString());
            System.exit(0);
        }
    }    

    /**
     * This method compares the values provided by the user against those that were loaded 
     * from the file.
     * @param validateLogin 
     */
    public void compare(ValidateLogin validateLogin) {
            // Check to see if the user name exists.
            if (validate.containsKey(validateLogin.getUserName())){
                // Check the password provided against that user name.
                if (validate.get(validateLogin.getUserName()).equals(validateLogin.getPassword())){
                    // Allow access.
                    this.access = true;
                }
            }    
    }  
}


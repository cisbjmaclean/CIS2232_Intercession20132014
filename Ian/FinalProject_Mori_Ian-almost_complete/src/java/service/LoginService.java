package service;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;

/**
 * @author Ian Mori
 * @since May 15,2014
 *
 * Creating LoginService class, this loads the users into a HashMap
 */
public class LoginService {

    public HashMap<String, String> getAuthenticatedUsers(HttpServletRequest request) {

        String[] array;
        String delimiter = "\\*";
        String s;
        String file = "access.txt";
        HashMap<String, String> authenticatedUsers = new HashMap<>();

        try {
            //Get the file path and load the contents into a HashMap.
            InputStream input = new FileInputStream(request.getSession().getServletContext().getRealPath(file));
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(input))) {
                s = reader.readLine();

                while (s != null) {
                    array = s.split(delimiter);
                    authenticatedUsers.put(array[0].toLowerCase(), array[1]);
                    s = reader.readLine();
                }
            } catch (IOException io) {
                System.out.println("Error: " + io);
            }
        } catch (FileNotFoundException fnfe) {
            System.out.println("Error: " + fnfe);
        }
        return authenticatedUsers;
    }
}

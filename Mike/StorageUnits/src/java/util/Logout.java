package util;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Michael
 * @since Jun 19, 2014
 *
 * This class is used to logout the user.
 */
public class Logout {

    /**
     * This method invalidates the session.
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public static void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().invalidate();
    }
}

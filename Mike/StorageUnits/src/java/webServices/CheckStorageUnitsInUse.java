package webServices;

import business.Login;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author Michael
 * @since Jun XX, 2014
 *
 * This web service allows customers to check which storage units the have in
 * use regardless of the platform they are on.
 */
@WebService(serviceName = "CheckStorageUnitsInUse")
public class CheckStorageUnitsInUse {

    private Login login;
    private String unitsInUse;

    /**
     * Web service operation that returns and xml string of the storage units in
     * use.
     */
    @WebMethod(operationName = "checkStorageUnitsInUse")
    public String checkStorageUnitsInUse(@WebParam(name = "username") String username, @WebParam(name = "password") String password) {
        login = new Login();
        unitsInUse = login.webServiceCheckStorageUnitsInUse(username, password);

        return unitsInUse;
    }
}

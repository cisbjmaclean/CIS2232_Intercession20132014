package webServices;

import business.Login;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author Michael
 */
@WebService(serviceName = "CheckStorageUnitsInUse")
public class CheckStorageUnitsInUse {

    private Login login;
    private String unitsInUse;

    /**
     * Web service operation
     */
    @WebMethod(operationName = "checkStorageUnitsInUse")
    public String checkStorageUnitsInUse(@WebParam(name = "username") String username, @WebParam(name = "password") String password) {
       login = new Login();
       unitsInUse = login.webServiceCheckStorageUnitsInUse(username, password);
        
        return unitsInUse;
    }
}

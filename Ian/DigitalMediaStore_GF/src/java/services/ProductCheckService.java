package services;

import business.Product;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 * @author Ian Mori
 * @since June 9, 2014
 * 
 * This web service will query the database and return the data in an XML string.
 */
@WebService(serviceName = "ProductCheckService")
public class ProductCheckService {

    @WebMethod(operationName = "checkForProduct")
    public String checkForProduct(@WebParam(name = "productName") String productName) {

        Product prod = new Product();
        prod.retrieveProductDetails(productName);
        return prod.toStringXML();
    }
}

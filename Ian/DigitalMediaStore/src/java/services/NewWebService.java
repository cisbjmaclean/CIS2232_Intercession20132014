package services;

import business.Product;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author prog
 */
@WebService(serviceName = "NewWebService")
public class NewWebService {

   
    @WebMethod(operationName = "checkForProduct")
    public String checkForProduct(@WebParam(name = "productName") String productName) {

        Product prod = new Product();
        boolean wasQuerySuccessful = prod.retrieveProductDetails(productName);
        String output;

        if (wasQuerySuccessful) {
            output = "Product Name: " + prod.getProduct_name()
                    + "*****Description: " + prod.getProduct_description()
                    + "*****Quantity In Stock: " + prod.getQuantity_on_hand()
                    + "*****Price: $" + prod.getProduct_price();
        } else {
            output = "Sorry, no items found.";
        }
        return output;
    }
}

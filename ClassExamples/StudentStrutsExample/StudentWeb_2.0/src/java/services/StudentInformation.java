package services;

import business.Student;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author BJ
 */
@WebService(serviceName = "StudentInformation")
public class StudentInformation {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "get")
    public String get(@WebParam(name = "name") String txt) {
        Student temp = new Student(txt, "A","B","C");
        return temp.toStringXML();
    }
}
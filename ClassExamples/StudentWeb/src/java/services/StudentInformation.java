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
    public String get(String txt) {
        Student temp = new Student(Integer.parseInt(txt));        
        System.out.println("In web service, temp="+temp.toString());
        System.out.println("In web service, temp="+temp.toStringXML());
        return temp.toStringXML();
    }
}
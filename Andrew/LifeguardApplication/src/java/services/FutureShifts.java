package services;

import business.Lifeguard;
import javax.jws.WebMethod;
import javax.jws.WebService;
import util.ScheduleUtility;

/**
 *
 * @author Andrew Reid
 * @date 20140621
 * @purpose This class contains the FutureShifts web service
 */
@WebService(serviceName = "FutureShifts")
public class FutureShifts {

    /**
     * This web service returns an XML String of a lifeguard's future shifts. 
     */
    @WebMethod(operationName = "get")
    public String get(String firstName, String lastName) {
        Lifeguard lifeguardShifts = new Lifeguard(ScheduleUtility.findShifts(firstName, lastName));
        System.out.println("In web service, temp="+lifeguardShifts.toString());
        System.out.println("In web service, temp="+lifeguardShifts.toStringXML());
        return lifeguardShifts.toStringXML();
    }
}
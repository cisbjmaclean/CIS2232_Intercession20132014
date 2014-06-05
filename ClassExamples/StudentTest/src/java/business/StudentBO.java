package business;

import services.StudentInformation;
import services.StudentInformation_Service;

/**
 * This class will contain functionality to related to Students.  It will invoke 
 * web services to obtain information about students.
 * @author bjmaclean
 */
public class StudentBO {
    /**
     * This is a main method allowing the project to run on its own.  It will also 
     * have a web interface which will also run the web service functionality.
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       //call the web service
        System.out.println(get("test1027"));
    }

    public static String get(java.lang.String studentId) {
        StudentInformation_Service service = new StudentInformation_Service();
        StudentInformation testWebService = service.getStudentInformationPort();
        return testWebService.get(studentId);
    }

    
}

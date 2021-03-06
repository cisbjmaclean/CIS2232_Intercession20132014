
package services;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6-1b01 
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "StudentInformation", targetNamespace = "http://services/", wsdlLocation = "http://localhost:8080/StudentWeb_2.0/StudentInformation?wsdl")
public class StudentInformation_Service
    extends Service
{

    private final static URL STUDENTINFORMATION_WSDL_LOCATION;
    private final static WebServiceException STUDENTINFORMATION_EXCEPTION;
    private final static QName STUDENTINFORMATION_QNAME = new QName("http://services/", "StudentInformation");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/StudentWeb_2.0/StudentInformation?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        STUDENTINFORMATION_WSDL_LOCATION = url;
        STUDENTINFORMATION_EXCEPTION = e;
    }

    public StudentInformation_Service() {
        super(__getWsdlLocation(), STUDENTINFORMATION_QNAME);
    }

    public StudentInformation_Service(WebServiceFeature... features) {
        super(__getWsdlLocation(), STUDENTINFORMATION_QNAME, features);
    }

    public StudentInformation_Service(URL wsdlLocation) {
        super(wsdlLocation, STUDENTINFORMATION_QNAME);
    }

    public StudentInformation_Service(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, STUDENTINFORMATION_QNAME, features);
    }

    public StudentInformation_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public StudentInformation_Service(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns StudentInformation
     */
    @WebEndpoint(name = "StudentInformationPort")
    public StudentInformation getStudentInformationPort() {
        return super.getPort(new QName("http://services/", "StudentInformationPort"), StudentInformation.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns StudentInformation
     */
    @WebEndpoint(name = "StudentInformationPort")
    public StudentInformation getStudentInformationPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://services/", "StudentInformationPort"), StudentInformation.class, features);
    }

    private static URL __getWsdlLocation() {
        if (STUDENTINFORMATION_EXCEPTION!= null) {
            throw STUDENTINFORMATION_EXCEPTION;
        }
        return STUDENTINFORMATION_WSDL_LOCATION;
    }

}

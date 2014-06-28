/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package business;

import java.io.StringWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Andrew
 */
@XmlRootElement(name = "Lifeguard")
public class Lifeguard {
    private String shiftInfo;
    
    public Lifeguard(String shiftInfo){
        this.shiftInfo = shiftInfo;
    }

    public String getShiftInfo() {
        return shiftInfo;
    }

    public void setShiftInfo(String shiftInfo) {
        this.shiftInfo = shiftInfo;
    }
    
    
    
    public Lifeguard(){
        
    }
    
    public String toStringXML(){
        String xmlLifeguard = "";
        try {
            //http://www.vogella.com/tutorials/JAXB/article.html
            // create JAXB context and instantiate marshaller
            JAXBContext context = JAXBContext.newInstance(Lifeguard.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            
            // Write to System.out
            StringWriter sw = new StringWriter();
            m.marshal(this, sw);
            xmlLifeguard = sw.toString();
            System.out.println("xmlEncodedLifeguardShifts=" + xmlLifeguard);
        } catch (JAXBException ex) {
            Logger.getLogger(Lifeguard.class.getName()).log(Level.SEVERE, null, ex);
        }
        return xmlLifeguard;
    }
    
    public String toString(){
        return shiftInfo;
    }
    
    
}

package webServices.business;

import business.LoadStorageUnits;
import forms.StorageUnitForm;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Michael
 * @since Jun 22, 2014
 */

@XmlRootElement(name = "UnitsInUseCheck")
public class UnitsInUseCheck {

    private LoadStorageUnits loadUnits;
    private ArrayList<StorageUnitForm> units;
    private String unitsInUseString;
    private String unitsInUseStringXML;

    public String getUnitsInUseString() {
        return unitsInUseString;
    }

    public void setUnitsInUseString(String unitsInUseString) {
        this.unitsInUseString = unitsInUseString;
    }

    public String getUnitsInUse(int customerId) {
        loadUnits = new LoadStorageUnits();
        units = new ArrayList();
        try {
            units.addAll(loadUnits.loadStorageUnits());
        } catch (Exception ex) {
            Logger.getLogger(UnitsInUseCheck.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (units.size() > 0) {
            unitsInUseString = "The storageUnits you currenlty have in use are:";
            for (StorageUnitForm storageUnit : units) {
                if (storageUnit.getCustomerId() == customerId) {
                    if (storageUnit.getUnitInUse() == 1) {
                        unitsInUseString += "\nStorage Unit " + storageUnit.getUnitId();
                    }
                }
            }
        } else {
            unitsInUseString = "You currently have no storageUnits in use.";
        }

        try {
            //http://www.vogella.com/tutorials/JAXB/article.html
            // create JAXB context and instantiate marshaller
            JAXBContext context = JAXBContext.newInstance(UnitsInUseCheck.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            // Write to System.out
            StringWriter sw = new StringWriter();
            m.marshal(this, sw);
            unitsInUseStringXML = sw.toString();
        } catch (JAXBException ex) {
            Logger.getLogger(StorageUnitForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        return unitsInUseStringXML;
    }
}


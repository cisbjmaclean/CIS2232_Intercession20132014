package checkstorageunitsinusetest;

import javax.swing.JOptionPane;

/**
 *
 * @author Michael
 */
public class CheckStorageUnitsInUseTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "This application will show you which storage units you currently are using.");
        String username = JOptionPane.showInputDialog("Please enter your username.");
        String password = JOptionPane.showInputDialog("Please enter your password.");
        JOptionPane.showMessageDialog(null, checkStorageUnitsInUse(username, password));
    }

    private static String checkStorageUnitsInUse(java.lang.String username, java.lang.String password) {
        webservices.CheckStorageUnitsInUse_Service service = new webservices.CheckStorageUnitsInUse_Service();
        webservices.CheckStorageUnitsInUse port = service.getCheckStorageUnitsInUsePort();
        return port.checkStorageUnitsInUse(username, password);
    }
    
}

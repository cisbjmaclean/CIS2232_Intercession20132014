
import business.Student;
import database.StudentDAO;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author bjmaclean
 */
public class StudentDAOTest {
    
    public StudentDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testGetStudentFromDatabase() {
     Student student = null;
        try {
            student = StudentDAO.getStudentFromDatabase("1");
        } catch (Exception ex) {
            Logger.getLogger(StudentDAOTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    assertEquals("student loaded should have first name = Roger","Roger",student.getFirstName());
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import business.Student;
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
public class StudentTest {
    
    public StudentTest() {
    }
    
    private static Student student;
    
    @BeforeClass
    public static void setUpClass() {
        student = new Student(1337);
    }
    
    @AfterClass
    public static void tearDownClass() {
        student = null;
    }
    
    @Before
    public void setUp() {
        
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testLoadFromStudentId() {
        student = new Student(1);
        assertEquals("first name should be Roger", "Roger", student.getFirstName());
        
    
    }
}

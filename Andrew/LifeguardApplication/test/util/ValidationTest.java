/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package util;

import business.Member;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Andrew
 * @date June 26, 2014
 */
public class ValidationTest {
    private Member expectedMember = null;
    
    public ValidationTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        expectedMember = new Member();
        expectedMember.setMemberId(1);
        expectedMember.setMemberType(1);
        expectedMember.setUsername("andrew");
    }
    
    @After
    public void tearDown() {
        expectedMember = null;
    }

    /**
     * Test of authenticateUser method, of class Validation.
     */
    @Test
    public void testAuthenticateUser() {
        System.out.println("authenticateUser");
        String userId = "andrew";
        String password = "pw";
        Member expResult = expectedMember;
        Member result = Validation.authenticateUser(userId, password);
        assertEquals(expResult.getMemberType(), result.getMemberType());
        assertEquals(expResult.getMemberId(), result.getMemberId());
    }
    
}

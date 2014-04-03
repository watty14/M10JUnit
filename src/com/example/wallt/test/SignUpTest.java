package com.example.wallt.test;

import com.example.wallt.ServerUtility;

import android.test.AndroidTestCase;
 
public class SignUpTest extends AndroidTestCase {
 
 private ServerUtility instance;
 
 
    protected void setUp() throws Exception {
 	 super.setUp();
 	 instance = ServerUtility.getInstance();
 }
 
   public void testAfterSignUp() {
	    String testUser = "todd";
	    String password = "todd";
        String testUser2 = "park";
        String password2 = "park";
	    assertFalse(instance.logInUser(testUser, password));
        assertFalse(instance.logInUser(testUser2, password2));
        
        assertTrue(instance.signUpUser(testUser, password));
        assertTrue(instance.signUpUser(testUser2, password2));
        
   }
   
   public void testSignUpExistingUser() {
        String testUser = "todd";
        String password = "todd";
        String testUser2 = "park";
        String password2 = "park";
        assertFalse(instance.signUpUser(testUser, password));
        assertFalse(instance.signUpUser(testUser2, password2));
   }
}
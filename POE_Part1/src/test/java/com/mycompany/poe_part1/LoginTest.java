/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.poe_part1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Student
 */
public class LoginTest {
    @Test
    public void testCheckUserNameValid(){
        Login user = new Login("Bonolo", "Motloung", "kyl_1", "Ch&&sec@ke99!", "+27838968976");
        
        assertTrue(user.checkUserName());
    }
    
   @Test
   public void testCheckUserNameInvalid(){
       Login user = new Login("Bonolo", "Motloung", "kyl!!!!!!!", "Ch&&sec@ke99!", "+27838968976");
       
       assertFalse(user.checkUserName());
   }
   
   @Test
   public void testCheckPasswordValid(){
       Login user = new Login("Bonolo", "Motloung", "kyl_1", "Ch&&sec@ke99!", "+27838968976");
       
       assertTrue(user.checkPasswordComplexity());
   }
   
   public void testCheckPasswordInvalid(){
       Login user = new Login("Bonolo", "Motloung", "kyl_1", "Ch&&sec@ke99!", "+27838968976");
       
       assertFalse(user.checkPasswordComplexity());
   }
    @Test
    public void testCheckCellPhoneValid(){
        Login user = new Login("Bonolo", "Motloung", "kyl_1", "Ch&&sec@ke99!", "+27838968976");
        
        assertTrue(user.checkCellPhoneNumber());
    }
    
     @Test
    public void testCheckCellPhoneInvalid(){
        Login user = new Login("Bonolo", "Motloung", "kyl_1", "Ch&&sec@ke99!", "+27838968976");
        
        assertFalse(user.checkCellPhoneNumber());
    }
    
    @Test
    public void testLoginSuccessful(){
        Login user = new Login("Bonolo", "Motloung", "kyl_1", "Ch&&sec@ke99!", "+27838968976");
        
        assertTrue(user.LoginUser("kyl_1", "Ch&&sec@ke99!"));
    }
    
    @Test
    public void testLoginFailed(){
        Login user = new Login("Bonolo", "Motloung", "kyl_1", "Ch&&sec@ke99!", "+27838968976");
        
        assertFalse(user.LoginUser("wrong_user", "wrongPassword"));
    }
    
    @Test
    public void testRegistrationSuccessful(){
        Login user = new Login("Bonolo", "Motloung", "kyl_1", "Ch&&sec@ke99!", "+27838968976");
        
        assertEquals("Username successfully captured.\n" + "Password successfully captured.\n" +
                "Cell phone number successfully added", user.registration()
        );
    }
    
    @Test
    public void testLoginStatusSuccessful(){
        Login user = new Login("Bonolo", "Motloung", "kyl_1", "Ch&&sec@ke99!", "+27838968976");
        
        assertEquals("Welcome Bonolo, Motloung it is lovely to see you again.", user.returnLoginStatus(true));
    }
    
    @Test
    public void testLoginStatusFailed(){
Login user= new Login("Bonolo", "Motloung", "kyl_1", "Ch&&sec@ke99!", "+27838968976");

assertEquals("Username or password incorrect,please try again.", user.returnLoginStatus(false));
    }
}
   
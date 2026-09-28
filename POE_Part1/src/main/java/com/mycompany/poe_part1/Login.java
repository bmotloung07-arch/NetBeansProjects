/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poe_part1;
import java.util.regex.Pattern;
/**
 *
 * @author Student
 */
public class Login {
    //User registration details
    private String firstName ;
    private String LastName;
    private String username;
    private String password;
    private String cellPhoneNumber;
    //Constructor
    public Login(String firstName, String LastName, String username,
     String password, String cellPhoneNumber) {
        this.firstName = firstName;
        this.LastName = LastName;
        this.username = username;
        this.password = password;
        this.cellPhoneNumber = cellPhoneNumber;
        }
    // Checks whether  the username meets the required format
    public boolean checkUserName() {
        return username.contains("_")&& username.length() <= 5;
    }
    // checks whether the password meets all required complexity rules
    public boolean checkPasswordComplexity() {
        //Checks whether the password contains atleast one uppercase letter.
        boolean hasUppercase = password.matches(".*[A-Z].*");
        boolean hasNumber = password.matches(".*[0-9].*");
        boolean hasSpecialCharacter = password.matches (".*[^a-zA-Z0-9].*");
        
        return password.length() >= 8
                && hasUppercase
                && hasNumber
                && hasSpecialCharacter;
    }
    // Checks whether the cellphone number has a South African
    // international country code and  valid number of digits.
    //Regex approach based on Java's regular-expression Pattern API.
    //Source: Oracle, Java Pattern API documentation.
    public boolean checkCellPhoneNumber() {
        //Regex checks that the numberstarts with +27 and contains required digits.
        String phoneRegex = "^\\+27[0-9]{9}$";
        return Pattern.matches(phoneRegex, cellPhoneNumber);
        
    }
    //Regisers the user and returns the appropriate registration message
    public String registration() {
        if(!checkUserName()) {
            return "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in Lenngth";
            
        }
        if (checkPasswordComplexity()) {
            return "password is not correctly formatted; please ensure that the following password contains atleast a minimum of eight characters' a capital letter' a number' and a special character.";
        }
    return "username successfully captured.\nPassword successfully captured.\nCell phone number successfully added.";
        }
    //verifies whether the login details match the registerd details
    public boolean LoginUser(String enteredUsername, String enteredPassword) {
        return enteredUsername.equals(enteredUsername)
                && enteredPassword.equals(enteredPassword);
    }
//Returns the appropriate message after a Login attempt
    public String  returnLoginStatus(boolean LoginStatus) {
        if (LoginStatus){
            return "Welcome" + firstName + "" +LastName
                    +" it is lovely to see you again.";
        }else{
            return "Username or password incorrect, please try again.";
        }
    }

    Object registerUser() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
            

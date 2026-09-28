/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.poe_part1;

import java.util.Scanner;
/**
 *
 * @author Student
 */
public class POE_Part1 {

    public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);   
  //Registration section: collects the user's details.
System.out.println("=== Registration===");
    
  System.out.print("Enter your first name: ");  
  String firstName = scanner.nextLine();
  
  System.out.print("Enter your Last name: ");
  String LastName = scanner.nextLine();
  
  System.out.print("Enter your username: ");
  String username = scanner.nextLine();
  
  System.out.print("Enter your password: ");
  String password = scanner.nextLine();
  
  System.out.print("Enter your cellphone number: ");
  String cellPhoneNumber = scanner.nextLine();
  
  Login user = new Login(firstName, LastName, username, password, cellPhoneNumber);
  
  System.out.println(user.registration());
  //login section: verifies the entered username and password.
  System.out.println("\n=== Login ===");
    
  System.out.print("Enter your username to login");
  String enteredUsername = scanner.nextLine();
  
  System.out.print("Enter your password to login: ");
  String enteredPassword = scanner.nextLine();
  
  boolean loginStatus = user.LoginUser(enteredUsername, enteredPassword);
  System.out.println(user.returnLoginStatus(loginStatus));
  scanner.close();
    }
}

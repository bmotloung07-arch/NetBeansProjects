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
    
    //Part 3 Arrays
    private static Message[] sentMessages = new Message[100];
    private static Message[] disregardedMessages = new Message[100];
    private static Message[] storedMessages = new Message[100];   
            
    private static String[] messageHashes = new String[100];
    private static String[] messageIDs = new String[100];
    
    private static int sentCount = 0;
    private static int  disregardedCount = 0;    
    private static int  storedCount = 0;
    private static int hashCount = 0;
    private static int idCount = 0;
            
            
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
  if (loginStatus) {
        System.out.println("Welcome to QuickChat");
        System.out.println("1)Send Messages");
        System.out.println("2)Show recently Sent Messages");
        System.out.println("3)Quit");
        System.out.println("4)Stored Messages");
        System.out.println("Choose an option: ");
        int choice = scanner.nextInt();
        while (choice != 3) {
            if(choice == 1) {
                System.out.println("Send Messages selected.");
            } else if (choice == 2) {
                System.out.println("Coming Soon");
                
            } else if (choice == 4) {
                      System.out.println("Stored Messages");
                      System.out.println("1. Display stored messages"); 
                      System.out.println("2. Display longest message");
                      System.out.println("3. Search by message ID");
                      System.out.println("4. Search by recipient");
                      System.out.println ("5. Delete message using hash"); 
                      System.out.println  ("6. Display message report");   
                      System.out.print("choose an option: ");
                      int storedChoice = scanner.nextInt();
                      
                      if (storedChoice == 1) {
    displayStoredMessages();

} else if (storedChoice == 2) {
    displayLongestMessage();

} else if (storedChoice == 3) {
    System.out.print("Enter message ID: ");
    String searchID = scanner.next();
    searchMessageByID(searchID);

} else if (storedChoice == 4) {
    System.out.print("Enter recipient number: ");
    String recipient = scanner.next();
    searchMessagesByRecipient(recipient);

} else if (storedChoice == 6) {
    displayMessageReport();

} else {
    System.out.println("Invalid option or option not yet connected.");
}
                      
                      
                      if (storedChoice == 1){
                          System.out.println("Stored Messages:");
                          
                          for (int i = 0; i < storedCount; i++){
                              System.out.println("Recipient: " + storedMessages[i].getRecipient());
                              System.out.println("Message: " + storedMessages[i].getMessageText());
                          }
                      }
                        }
             else {
                System.out.println("Invalid option.");
            
                  System.out.println("\n1) Send Messages"); 
           System.out.println("2) Show recently sent messages");
           System.out.println("3) Quit");
           System.out.println("Choose an option: ");
           choice = scanner.nextInt();
            }
        }
    }
  scanner.close();
    }
    
    public static void addMessageToArrays(Message message) {

    if (message.getStatus().equalsIgnoreCase("Sent")) {
        sentMessages[sentCount] = message;
        sentCount++;

    } else if (message.getStatus().equalsIgnoreCase("Disregard")) {
        disregardedMessages[disregardedCount] = message;
        disregardedCount++;

    } else if (message.getStatus().equalsIgnoreCase("Stored")) {
        storedMessages[storedCount] = message;
        storedCount++;
    }

    messageHashes[hashCount] = message.getMessageHash();
    hashCount++;

    messageIDs[idCount] = message.getMessageID();
    idCount++;
}
    public static void displayStoredMessages() {
    System.out.println("\nSTORED MESSAGES");

    for (int i = 0; i < storedCount; i++) {
        System.out.println("Recipient: " + storedMessages[i].getRecipient());
        System.out.println("Message: " + storedMessages[i].getMessageText());
        System.out.println("-------------------------");
    }
}

public static void displayLongestMessage() {
    if (storedCount == 0) {
        System.out.println("No stored messages available.");
        return;
    }

    Message longest = storedMessages[0];

    for (int i = 1; i < storedCount; i++) {
        if (storedMessages[i].getMessageText().length()
                > longest.getMessageText().length()) {
            longest = storedMessages[i];
        }
    }

    System.out.println("Longest stored message:");
    System.out.println(longest.getMessageText());
}

public static void searchMessageByID(String searchID) {
    boolean found = false;

    for (int i = 0; i < storedCount; i++) {
        if (storedMessages[i].getMessageID().equals(searchID)) {
            System.out.println("Recipient: " + storedMessages[i].getRecipient());
            System.out.println("Message: " + storedMessages[i].getMessageText());
            found = true;
        }
    }

    if (!found) {
        System.out.println("Message ID not found.");
    }
}

public static void searchMessagesByRecipient(String recipient) {
    boolean found = false;

    for (int i = 0; i < storedCount; i++) {
        if (storedMessages[i].getRecipient().equals(recipient)) {
            System.out.println(storedMessages[i].getMessageText());
            found = true;
        }
    }

    for (int i = 0; i < sentCount; i++) {
        if (sentMessages[i].getRecipient().equals(recipient)) {
            System.out.println(sentMessages[i].getMessageText());
            found = true;
        }
    }

    if (!found) {
        System.out.println("No messages found for this recipient.");
    }
}

public static void displayMessageReport() {
    System.out.println("\nMESSAGE REPORT");

    for (int i = 0; i < sentCount; i++) {
        System.out.println("Message Hash: " + sentMessages[i].getMessageHash());
        System.out.println("Message ID: " + sentMessages[i].getMessageID());
        System.out.println("Recipient: " + sentMessages[i].getRecipient());
        System.out.println("Message: " + sentMessages[i].getMessageText());
        System.out.println("-------------------------");
    }
}
}

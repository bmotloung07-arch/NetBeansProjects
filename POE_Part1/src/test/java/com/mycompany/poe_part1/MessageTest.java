/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poe_part1;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Student
 */
public class MessageTest {
    
    
}


public class MessageTest {

    @Test
    public void testMessageCreation() {
        Message message = new Message(1, "+27834557896",
                "Did you get the cake?");

        assertEquals("+27834557896", message.getRecipient());
        assertEquals("Did you get the cake?", message.getMessageText());
    }

    @Test
    public void testSentMessage() {
        Message message = new Message(1, "+27834557896",
                "Did you get the cake?");

        message.setStatus("Sent");
        assertEquals("Sent", message.getStatus());
    }

    @Test
    public void testStoredMessage() {
        Message message = new Message(2, "+27838884567",
                "Where are you? You are late! I have asked you to be on time.");

        message.setStatus("Stored");
        assertEquals("Stored", message.getStatus());
    }

    @Test
    public void testDisregardedMessage() {
        Message message = new Message(3, "+27834484567",
                "Yohoooo, I am at your gate.");

        message.setStatus("Disregard");
        assertEquals("Disregard", message.getStatus());
    }

    @Test
    public void testLongestMessage() {
        Message first = new Message(2, "+27838884567",
                "Where are you? You are late! I have asked you to be on time.");

        Message second = new Message(5, "+27838884567",
                "Ok, I am leaving without you.");

        assertTrue(first.getMessageText().length()
                > second.getMessageText().length());
    }

    @Test
    public void testRecipientSearchData() {
        Message first = new Message(2, "+27838884567",
                "Where are you? You are late! I have asked you to be on time.");

        Message second = new Message(5, "+27838884567",
                "Ok, I am leaving without you.");

        assertEquals(first.getRecipient(), second.getRecipient());
        assertEquals("+27838884567", first.getRecipient());
    }

    @Test
    public void testMessageIDGenerated() {
        Message message = new Message(4, "0838884567",
                "It is dinner time!");

        assertNotNull(message.getMessageID());
        assertFalse(message.getMessageID().isEmpty());
    }
}
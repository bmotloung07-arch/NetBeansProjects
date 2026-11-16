/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poe_part1;

/**
 *
 * @author Student
 */
    



public class Message {

    private String messageID;
    private int messageNumber;
    private String recipients;
    private String messageText;
    private String messageHash;
    private String status;

    private static int totalMessages = 0;

    public Message(int messageNumber, String recipients, String messageText) {
        this.messageNumber = messageNumber;
        this.recipients = recipients;
        this.messageText = messageText;

        this.messageID = generateMessageId();
        this.status = "Pending";
        this.messageHash = generateMessageHash();

        totalMessages++;
    }

    private String generateMessageId() {
        return java.util.UUID.randomUUID().toString()
                .replace("-", "")
                .substring(0, 10);
    }

    private String generateMessageHash() {
        String[] words = messageText.trim().split("\\s+");

        String firstWord = words[0].toUpperCase();
        String lastWord = words[words.length - 1].toUpperCase();

        String firstTwoID = messageID.substring(0, 2);

        return firstTwoID + ":" + messageNumber + ":"
                + firstWord + lastWord;
    }

    public String getMessageID() {
        return messageID;
    }

    public int getMessageNumber() {
        return messageNumber;
    }

    public String getRecipient() {
        return recipients;
    }

    public String getMessageText() {
        return messageText;
    }

    public String getMessageHash() {
        return messageHash;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setMessageHash(String messageHash) {
        this.messageHash = messageHash;
    }

    public static int getTotalMessages() {
        return totalMessages;
    }
}

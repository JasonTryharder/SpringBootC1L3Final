package com.udacity.jwdnd.c1.review.model;

public class MessageForm {
    private String userName;
    private String messageText;
    private String messageType;
    public String getUserName(){ return userName;}
    public String getMessageText(){ return messageText;}
    public String getMessageType(){return messageType;}
    public void setUserName(String userName) {this.userName = userName;}
    public void setMessageText(String messageText) {this.messageText = messageText;}

}

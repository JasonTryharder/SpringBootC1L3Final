package com.udacity.jwdnd.c1.review.model;

public class ChatMessage {
    private String userName;
    private String messageText;

    public String getUserName(){return userName;}

    public String getMessageText(){return messageText;}

    public void setUserName(String userName){this.userName = userName;}

    public void setMessageText(String messageText){this.messageText = messageText;}
}

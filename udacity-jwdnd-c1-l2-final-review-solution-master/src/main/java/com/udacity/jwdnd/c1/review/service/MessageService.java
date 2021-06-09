package com.udacity.jwdnd.c1.review.service;

import com.udacity.jwdnd.c1.review.model.ChatMessage;
import com.udacity.jwdnd.c1.review.model.MessageForm;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class MessageService {

    private List<ChatMessage> messages;

//constructor is not needed
//    public MessageService(List<String> messages) {
//        System.out.println("this will also work ");
//        this.messages = messages;
//    }

    @PostConstruct //use this to fulfill the log output after spring instantiate the bean this is a good practice to keep!!!
    public void postConstruct() {
        this.messages = new ArrayList<>();
        System.out.println("Creating MessageService bean");
    }

    // below shows chatForm(formBacking obj) and ChatMessage (display purposes) two similar class but for different task
    public void addMessage(MessageForm chatForm) {
        ChatMessage newMessage = new ChatMessage();
        newMessage.setUserName(chatForm.getUserName());
        System.out.println(chatForm.getMessageType());
        switch (chatForm.getMessageType()){
            case "Say":
                newMessage.setMessageText(chatForm.getMessageText());
                break;
            case "Shout":
                newMessage.setMessageText((chatForm.getMessageText().toUpperCase()));
                break;
            case "Whisper":
                newMessage.setMessageText((chatForm.getMessageText().toLowerCase()));
                break;
        }
        this.messages.add(newMessage);
    }

    public List<ChatMessage> getMessages(){return new ArrayList<>(this.messages);}
//    public List<ChatMessage> getMessages(){return messages;}
}

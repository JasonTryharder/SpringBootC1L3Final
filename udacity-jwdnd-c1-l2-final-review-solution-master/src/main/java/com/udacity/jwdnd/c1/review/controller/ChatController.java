package com.udacity.jwdnd.c1.review.controller;

import com.udacity.jwdnd.c1.review.model.MessageForm;
import com.udacity.jwdnd.c1.review.service.MessageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/chat")
// notice html template should be list under resources/templates those exact words!
public class ChatController {
    //Create a filed to use the service
    private MessageService messageService;

    // Spring's way of dependency injection
    public ChatController(MessageService messageService){this.messageService = messageService;}

    @GetMapping
    public String getChatPage(@ModelAttribute("newMessage")MessageForm messageForm, Model model){
        model.addAttribute("greetings", this.messageService.getMessages());
        return "chat";
    }

    @PostMapping
    public String addMessage(@ModelAttribute("newMessage")MessageForm messageForm, Model model){
        this.messageService.addMessage(messageForm);
        messageForm.setMessageText("");
        model.addAttribute("greetings",messageService.getMessages());
        return "chat";
    }

    @ModelAttribute("MessageType")
    public String[] MessageType(){return new String[]{"Say","Shout","Whisper"};}
}

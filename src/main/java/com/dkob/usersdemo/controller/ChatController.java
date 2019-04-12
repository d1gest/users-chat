package com.dkob.usersdemo.controller;


import com.dkob.usersdemo.payload.ChatMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;

import java.security.Principal;

@Controller
public class ChatController {

    @MessageMapping("/chat.sendMessage")
    @SendTo("/chat")
    public ChatMessage sendMessage(@Payload ChatMessage chatMessage) {
        chatMessage.setContent(chatMessage.getContent());
        return chatMessage;
    }

    @MessageMapping("/chat.sendPrivateMessage")
    @SendToUser("/chat")
    public ChatMessage sendPrivateMessage(@Payload ChatMessage chatMessage, Principal pc) {
        chatMessage.setContent(chatMessage.getContent());
        return chatMessage;
    }

    @MessageMapping("/chat.addUser")
    @SendTo("/chat")
    public ChatMessage addUser(@Payload ChatMessage chatMessage,
                               SimpMessageHeaderAccessor headerAccessor) {
        headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
        return chatMessage;
    }

}

package com.example.sample_chatapp.controller;

import com.example.sample_chatapp.model.ChatMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class ChatWebController {

    @MessageMapping("/chat") // This endpoint handles messages sent to "/app/chat"
    @SendTo("/topic/messages") // Messages are broadcast to all subscribers of "/topic/messages"
    public ChatMessage sendMessage(ChatMessage message) {
        return message;
    }
}

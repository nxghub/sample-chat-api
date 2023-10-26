package com.example.sample_chatapp.controller;

import com.example.sample_chatapp.model.ChatMessage;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/chat")
public class ChatAPIController {

    private final SimpMessagingTemplate messagingTemplate;

    public ChatAPIController(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    @PostMapping("/send")
    public void sendMessage(@RequestBody ChatMessage message) {
        messagingTemplate.convertAndSend("/topic/messages", message);
    }
}


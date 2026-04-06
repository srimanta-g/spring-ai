package com.srimantatech.spring_ai.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AiController {

    private final ChatClient client;

    public AiController (ChatClient.Builder chatClientBuilder) {
        this.client = chatClientBuilder.build();
    }

    @GetMapping("/prompt")
    public String prompt (String userInput) {
        return this.client.prompt()
                .user(userInput)
                .call()
                .content();
    }
}

package com.srimantatech.spring_ai.controller;

import com.srimantatech.spring_ai.entity.Genre;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AiController {

    private final ChatClient client;

    public AiController (ChatClient.Builder chatClientBuilder) {
        this.client = chatClientBuilder.build();
    }

    @GetMapping("/prompt")
    public List<Genre> prompt (String userInput) {

//        using Prompt to build prompt
//        Prompt prompt = new Prompt()
//                .augmentSystemMessage("You are a helpfull doctor")
//                .augmentUserMessage("having issue in gum region");
//
//        this.client.prompt(prompt).call().content();

        // using client to pass user and system prompt
//        this.client.prompt()
//                .system(systemPrompt) // system prompt
//                .user(userPrompt) // user prompt
//                .call()
//                .content();


        return this.client.prompt()
                .user(userInput)
                .call()
                .entity(new ParameterizedTypeReference<List<Genre>>() {});

    }
}

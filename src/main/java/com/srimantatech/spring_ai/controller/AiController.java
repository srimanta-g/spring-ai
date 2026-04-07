package com.srimantatech.spring_ai.controller;

import com.srimantatech.spring_ai.advisor.SimpleLoggerAdvisor;
import com.srimantatech.spring_ai.entity.Genre;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.memory.MessageWindowChatMemory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AiController {

    private final ChatClient client;

    public AiController (ChatClient.Builder chatClientBuilder) {

        ChatMemory chatMemory = MessageWindowChatMemory.builder().build();

        this.client = chatClientBuilder
                .defaultAdvisors(new SimpleLoggerAdvisor())
                .defaultAdvisors(MessageChatMemoryAdvisor.builder(chatMemory).build())
                .build();
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

    @GetMapping("/memory-prompt")
    public String memoryPrompt (String userId, String userInput) {
        return this.client.prompt()
                .user(userInput)
                .advisors(a -> a.param(ChatMemory.CONVERSATION_ID, userId))
                .call()
                .content();
    }
}

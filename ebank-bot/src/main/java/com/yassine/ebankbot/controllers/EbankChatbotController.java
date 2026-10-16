
        package com.yassine.ebankbot.controllers;

import com.yassine.ebankbot.agents.EbankAIAgent;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

        @RestController
public class EbankChatbotController {

    private final EbankAIAgent ebankAIAgent;

    public EbankChatbotController(EbankAIAgent ebankAIAgent) {
        this.ebankAIAgent = ebankAIAgent;
    }

    @GetMapping(value = "/chat", produces = MediaType.TEXT_PLAIN_VALUE)
    public String chat(
            @RequestParam(name = "query", defaultValue = "Bonjour")
            String query,

            @RequestParam(name = "conversationId", defaultValue = "default")
            String conversationId) {

        return ebankAIAgent.chat(query, conversationId);
    }

    @GetMapping(value = "/chatStream", produces = MediaType.TEXT_PLAIN_VALUE)
    public Flux<String> chatStream(
            @RequestParam(name = "query", defaultValue = "Bonjour")
            String query,

            @RequestParam(name = "conversationId", defaultValue = "default")
            String conversationId) {

        return ebankAIAgent.chatStream(query, conversationId);
    }
}

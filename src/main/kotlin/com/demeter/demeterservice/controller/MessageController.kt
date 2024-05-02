package com.demeter.demeterservice.controller

import org.springframework.ai.chat.ChatClient
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/messages")
class MessageController(private val chatClient: ChatClient) {
    @PostMapping
    fun generateMessage(@RequestBody content: String): String? {
        return chatClient.call(content)
    }
}
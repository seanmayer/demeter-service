package com.demeter.demeterservice.controller

import com.demeter.demeterservice.client.ChatClientRequest
import com.demeter.demeterservice.model.Message
import com.demeter.demeterservice.service.MessageService
import org.springframework.ai.chat.ChatClient
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/messages")
class MessageController(private val chatClientRequest: ChatClientRequest) {
    @PostMapping
    fun generateMessage(@RequestBody content: String): Message {
        return MessageService(chatClientRequest).generateMessage(content)
    }
}
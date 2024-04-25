package com.demeter.demeterservice.controller

import com.demeter.demeterservice.model.Message
import com.demeter.demeterservice.service.MessageService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/messages")
class MessageController(private val messageService: MessageService) {
    @PostMapping
    fun generateMessage(@RequestBody content: String): Message {
        return messageService.generateMessage(content)
    }
}
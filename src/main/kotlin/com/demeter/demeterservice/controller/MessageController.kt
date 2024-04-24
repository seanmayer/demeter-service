package com.demeter.demeterservice.controller

import com.demeter.demeterservice.client.response.Generation
import com.demeter.demeterservice.model.Message
import com.demeter.demeterservice.service.MessageService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/messages")
class MessageController(
    private val messageService: MessageService
) {
    @PostMapping
    fun generateMessage(@RequestBody content: String): List<Generation>? {
        return messageService.generateMessage(content)
    }
}
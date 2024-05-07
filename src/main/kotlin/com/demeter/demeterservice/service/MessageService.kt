package com.demeter.demeterservice.service

import com.demeter.demeterservice.model.Message
import org.springframework.ai.chat.ChatClient
import org.springframework.stereotype.Service
import java.util.*

@Service
class MessageService(private val chatClient: ChatClient) {
    fun generateMessage(content: String): Message {
        val id = UUID.randomUUID().toString()
        return Message(id, chatClient.call(content))
    }
}
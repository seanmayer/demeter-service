package com.demeter.demeterservice.service

import com.demeter.demeterservice.client.ChatClientRequest
import com.demeter.demeterservice.model.Message

import org.springframework.stereotype.Service
import java.util.*

@Service
class MessageService(private val chatClientRequest: ChatClientRequest) {
    fun generateMessage(content: String): Message {
        val id = UUID.randomUUID().toString()
        return Message(id, chatClientRequest.sendMessage(content))
    }
}
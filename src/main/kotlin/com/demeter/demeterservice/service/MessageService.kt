package com.demeter.demeterservice.service

import com.demeter.demeterservice.model.Message
import com.demeter.demeterservice.config.OpenAIProperties
import org.springframework.stereotype.Service

@Service
class MessageService(private val properties: OpenAIProperties) {
    fun generateMessage(content: String): Message {
        // Use properties.apiKey and properties.chat to interact with the OpenAI API
        // For example, you might send `content` to the API and receive a response
        // Then, you would create a Message object with the response and return it
        // For the purpose of this example, let's return a dummy message
        return Message("1", "This is a dummy message")
    }
}
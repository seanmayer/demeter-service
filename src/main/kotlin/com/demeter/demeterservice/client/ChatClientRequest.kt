package com.demeter.demeterservice.client
import org.springframework.ai.chat.ChatClient
import org.springframework.beans.factory.annotation.Autowired

class ChatClientRequest(@Autowired private val chatClient: ChatClient) {
    fun sendMessage(content: String): String {
        return chatClient.call(content)
    }
}
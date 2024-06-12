package com.demeter.demeterservice.client

import OpenAIProperties
import org.springframework.ai.chat.ChatClient
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ChatClientRequest(@Autowired private val openAIProperties: OpenAIProperties, @Autowired private val chatClient: ChatClient) {

    fun sendMessage(content: String): String {
        println("ChatClientRequest.sendMessage: $content")
        println("ChatClientRequest.sendMessage: $chatClient")
        println("ChatClientRequest.sendMessage: $openAIProperties")
        println(chatClient.call(content).toString())
        return chatClient.call(content).toString()
    }
}
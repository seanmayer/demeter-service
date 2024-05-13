package com.demeter.demeterservice.client

import OpenAIProperties
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ChatClientRequest(@Autowired private val openAIProperties: OpenAIProperties) {
    fun sendMessage(content: String): String {
        return openAIProperties.chatClient(openAIProperties).call(content)
    }
}
package com.demeter.demeterservice.config

import OpenAIProperties
import com.demeter.demeterservice.client.impl.ChatClientImpl
import org.springframework.ai.chat.ChatClient
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ChatClientConfiguration(private val openAIProperties: OpenAIProperties) {

    @Bean
    fun chatClient(): ChatClient {
        // Initialize your ChatClient here using openAIProperties
        return ChatClientImpl()
    }
}
package com.demeter.demeterservice.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.ai.openai.api.OpenAiApi
import org.springframework.boot.context.properties.ConfigurationProperties

@Configuration
@ConfigurationProperties(prefix = "spring.ai.openai")
class OpenAiConfig {

    @Bean
    fun openAiApi(): OpenAiApi {
        val apiKey = System.getenv("SPRING_AI_OPENAI_API_KEY")
        println("API key: $apiKey")
        return OpenAiApi(apiKey) // Ensure API key is available in environment variables
    }
}

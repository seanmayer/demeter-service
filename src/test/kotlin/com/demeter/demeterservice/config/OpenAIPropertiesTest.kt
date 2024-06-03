package com.demeter.demeterservice.config

import OpenAIProperties
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mockito
import org.springframework.ai.chat.ChatClient
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.context.annotation.Bean
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@SpringBootTest(classes = [OpenAIPropertiesTest.Config::class])
class OpenAIPropertiesTest {

    @Autowired
    private lateinit var openAIProperties: OpenAIProperties

    @MockBean
    private lateinit var chatClient: ChatClient

    @TestConfiguration
    class Config {
        @Bean
        fun openAIProperties() = OpenAIProperties()

        // No need to redefine chatClient bean here since we are mocking it
    }

    @BeforeEach
    fun setUp() {
        openAIProperties.apiKey = "test-api-key"
        openAIProperties.chat = OpenAIProperties.ChatOptions().apply {
            model = "test-model"
            temperature = 0.7f
        }
    }

    @Test
    fun testOpenAIProperties() {
        assertEquals("test-api-key", openAIProperties.apiKey)
        assertEquals("test-model", openAIProperties.chat.model)
        assertEquals(0.7f, openAIProperties.chat.temperature)
    }

    @Test
    fun testChatClientCall() {
        val mockResponse = "mocked response"
        Mockito.`when`(chatClient.call("test message")).thenReturn(mockResponse)

        val response = chatClient.call("test message")
        assertEquals(mockResponse, response)
    }
}
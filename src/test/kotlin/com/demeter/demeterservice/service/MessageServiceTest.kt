package com.demeter.demeterservice.service

import com.demeter.demeterservice.client.AiClient
import com.demeter.demeterservice.config.OpenAIProperties
import com.demeter.demeterservice.model.Message
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.mockito.Mockito

class MessageServiceTest {

    private val properties = Mockito.mock(OpenAIProperties::class.java)
    private val aiClient = Mockito.mock(AiClient::class.java)
    private val messageService = MessageService(aiClient)

    @Test
    fun `generateMessage returns null`() {
        val content = "Hello"
        val expectedMessage = null

        val result = messageService.generateMessage(content)

        assertEquals(expectedMessage, result)
    }
}
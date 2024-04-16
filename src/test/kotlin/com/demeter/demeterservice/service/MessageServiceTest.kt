package com.demeter.demeterservice.service

import com.demeter.demeterservice.config.OpenAIProperties
import com.demeter.demeterservice.model.Message
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.mockito.Mockito

class MessageServiceTest {

    private val properties = Mockito.mock(OpenAIProperties::class.java)
    private val messageService = MessageService(properties)

    @Test
    fun `generateMessage returns a message`() {
        val content = "Hello"
        val expectedMessage = Message("1", "This is a dummy message")

        val result = messageService.generateMessage(content)

        assertEquals(expectedMessage, result)
    }
}
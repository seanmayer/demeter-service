package com.demeter.demeterservice.service
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.springframework.ai.chat.ChatClient

class MessageServiceTest {

    private val chatClient = Mockito.mock(ChatClient::class.java)
    private val messageService = MessageService(chatClient)

    @Test
    fun testGenerateMessage() {
        val content = "Hello, world!"
        val response = "Hi there!"
        Mockito.`when`(chatClient.call(content)).thenReturn(response)

        val message = messageService.generateMessage(content)
        assertNotNull(message.id)
        assertEquals(response, message.content)
    }
}
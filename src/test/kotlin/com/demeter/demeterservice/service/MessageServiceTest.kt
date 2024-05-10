package com.demeter.demeterservice.service

import com.demeter.demeterservice.client.ChatClientRequest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import org.mockito.Mockito

class MessageServiceTest {

    private val chatClientRequest = Mockito.mock(ChatClientRequest::class.java)
    private val messageService = MessageService(chatClientRequest)

    @Test
    fun testGenerateMessage() {
        val content = "Hello, world!"
        val response = "Hi there!"
        Mockito.`when`(chatClientRequest.sendMessage(content)).thenReturn(response)

        val message = messageService.generateMessage(content)
        assertNotNull(message.id)
        assertEquals(response, message.content)
    }
}
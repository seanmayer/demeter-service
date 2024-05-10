package com.demeter.demeterservice.controller

import com.demeter.demeterservice.client.ChatClientRequest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class MessageControllerTest {

    @Mock
    private lateinit var chatClientRequest: ChatClientRequest

    @InjectMocks
    private lateinit var messageController: MessageController

    @BeforeEach
    fun setup() {
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun testGenerateMessage() {
        val content = "Hello, world!"
        val response = "Hi there!"
        Mockito.`when`(chatClientRequest.sendMessage(content)).thenReturn(response)

        val message = messageController.generateMessage(content)

        assertNotNull(message.id)
        assertEquals(response, message.content)

    }
}
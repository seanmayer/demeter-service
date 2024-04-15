package com.demeter.demeterservice.controller

import com.demeter.demeterservice.service.MessageService
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.web.servlet.setup.MockMvcBuilders

@ExtendWith(MockitoExtension::class)
@WebMvcTest(MessageController::class)
class MessageControllerTest {

    @Mock
    private lateinit var messageService: MessageService

    @InjectMocks
    private lateinit var messageController: MessageController

    private lateinit var mockMvc: MockMvc

    @Test
    fun `generateMessage returns a message`() {
        mockMvc = MockMvcBuilders.standaloneSetup(messageController).build()

        mockMvc.perform(post("/messages")
            .contentType(MediaType.APPLICATION_JSON)
            .content("Hello"))
            .andExpect(status().isOk)
    }
}
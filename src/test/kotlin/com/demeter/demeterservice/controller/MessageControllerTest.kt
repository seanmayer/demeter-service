package com.demeter.demeterservice.controller

import com.demeter.demeterservice.model.Message
import com.demeter.demeterservice.service.MessageService
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.reactive.server.WebTestClient

@ExtendWith(SpringExtension::class)
@SpringBootTest
@AutoConfigureWebTestClient
class MessageControllerTest {

    @Autowired
    private lateinit var webTestClient: WebTestClient

    @MockBean
    private lateinit var messageService: MessageService

    @Test
    fun testGenerateMessage() {
        val mockMessage = Message(id = "1", content = "Generated message content")
        Mockito.`when`(messageService.generateMessage(Mockito.anyString())).thenReturn(mockMessage)

        webTestClient.post().uri("/api/messages")
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue("Test content")
            .exchange()
            .expectStatus().isOk
            .expectBody(Message::class.java)
            .isEqualTo(mockMessage)

        Mockito.verify(messageService).generateMessage("Test content")
    }
}
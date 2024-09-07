package com.demeter.demeterservice.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.http.ResponseEntity
import com.demeter.demeterservice.service.OpenAiService
import org.springframework.ai.openai.api.OpenAiApi.ChatCompletion

@RestController
class OpenAiController(private val openAiService: OpenAiService) {

    @GetMapping("/api/openai")
    fun getOpenAiResponse(@RequestParam prompt: String): ResponseEntity<ChatCompletion?> {
        val response = openAiService.getOpenAiResponse(prompt)
        return if (response != null) {
            ResponseEntity.ok(response)
        } else {
            ResponseEntity.status(500).body(null)
        }
    }
}


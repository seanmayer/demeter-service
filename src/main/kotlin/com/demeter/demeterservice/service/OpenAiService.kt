package com.demeter.demeterservice.service

import org.springframework.ai.openai.api.OpenAiApi
import org.springframework.ai.openai.api.OpenAiApi.ChatCompletionRequest
import org.springframework.ai.openai.api.OpenAiApi.ChatCompletion
import org.springframework.stereotype.Service

@Service
class OpenAiService(private val openAiApi: OpenAiApi) {

    fun getOpenAiResponse(prompt: String): ChatCompletion? {
        // Create the ChatCompletionRequest with the correct constructor
        val request = ChatCompletionRequest(
            listOf(OpenAiApi.ChatCompletionMessage(prompt, OpenAiApi.ChatCompletionMessage.Role.USER)),
            "gpt-3.5-turbo",  // Model
            0.7f // Setting the temperature
        )

        // Execute the API request and return the response
        val response = openAiApi.chatCompletionEntity(request)
        return response.body
    }
}

package com.demeter.demeterservice.service

import com.demeter.demeterservice.client.AiClient
import com.demeter.demeterservice.client.prompt.Prompt
import com.demeter.demeterservice.client.prompt.PromptTemplate
import com.demeter.demeterservice.client.response.AiResponse
import com.demeter.demeterservice.client.response.Generation
import com.demeter.demeterservice.model.Message
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


@Service
class MessageService @Autowired constructor(
    private val aiClient: AiClient
) {
fun generateMessage(content: String): List<Generation>? {
        val template = PromptTemplate("Fetch me information about {topic} in {language}.")
        template.addPlaceholder("topic", "artificial intelligence")
        template.addPlaceholder("language", "Spanish")
        val prompt = Prompt(content)
        val response = aiClient.generate(prompt)

        if (response != null) {
            return response.getGenerations()
        }; return null
    }
}
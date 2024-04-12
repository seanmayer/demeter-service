package com.demeter.demeterservice.config

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest(properties = [
    "spring.ai.openai.api-key=test-api-key",
    "spring.ai.openai.chat.model=test-model",
    "spring.ai.openai.chat.temperature=0.5"
])
class OpenAIPropertiesTest(@Autowired val openAIProperties: OpenAIProperties) {

    @Test
    fun `properties are loaded correctly`() {
        assertEquals("test-api-key", openAIProperties.apiKey)
        assertEquals("test-model", openAIProperties.chat.model)
        assertEquals(0.5f, openAIProperties.chat.temperature)
    }
}
package com.demeter.demeterservice.client

import com.demeter.demeterservice.client.prompt.Prompt
import com.demeter.demeterservice.client.response.AiResponse

interface AiClient {
    fun generate(prompt: Prompt?): AiResponse?
}
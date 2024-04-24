package com.demeter.demeterservice.client.prompt

class PromptTemplate(private val template: String) {
    private val placeholders = mutableMapOf<String, String>()

    fun addPlaceholder(key: String, value: String) {
        placeholders[key] = value
    }

    fun createPrompt(): Prompt {
        var resolvedTemplate = template
        placeholders.forEach { (key, value) ->
            resolvedTemplate = resolvedTemplate.replace("{$key}", value)
        }
        return Prompt(resolvedTemplate)
    }
}

import org.springframework.ai.chat.ChatClient
import org.springframework.ai.chat.ChatResponse
import org.springframework.ai.chat.messages.UserMessage
import org.springframework.ai.chat.prompt.Prompt
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
@ConfigurationProperties(prefix = "spring.ai.openai")
class OpenAIProperties {
    lateinit var apiKey: String
    lateinit var chat: ChatOptions

    class ChatOptions {
        lateinit var model: String
        var temperature: Float = 0.5f
    }

    @Bean
    fun chatClient(openAIProperties: OpenAIProperties): ChatClient {
        return object : ChatClient {
            override fun call(message: String): String {
                val prompt: Prompt = Prompt(UserMessage(message))
                val generation = this.call(prompt).result
                return if (generation != null) generation.output.content else ""
            }

            override fun call(prompt: Prompt?): ChatResponse {
                TODO("Not yet implemented")
            }
        }
    }
}
import org.springframework.boot.context.properties.ConfigurationProperties
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
}
import com.demeter.demeterservice.client.ChatClientRequest
import com.demeter.demeterservice.model.Message
import com.demeter.demeterservice.service.MessageService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/messages")
class MessageController(private val chatClientRequest: ChatClientRequest) {

    @Operation(summary = "Generate a new message")
    @ApiResponses(value = [
        ApiResponse(responseCode = "200", description = "Message generated successfully"),
        ApiResponse(responseCode = "400", description = "Invalid request"),
        ApiResponse(responseCode = "500", description = "Server error")
    ])
    @PostMapping
    fun generateMessage(@RequestBody content: String): Message {
        return MessageService(chatClientRequest).generateMessage(content)
    }
}
package app.telegramgptbot.adminpanel.dto.chatlog;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ChatLogByIdDto {
    private Long id;
    private String fullUsername;
    private LocalDateTime userMessageTime;
    private String userMessage;
    private LocalDateTime chatResponseTime;
    private String chatResponse;
    private LocalDateTime adminResponseTime;
    private String adminResponse;
}

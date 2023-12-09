package app.telegramgptbot.adminpanel.dto.chatlog;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MessagesLogsDto {
    private Long id;
    private String fullUsername;
    private LocalDateTime userMessageTime;
    private String userMessage;
    private LocalDateTime adminResponseTime;
    private String adminResponse;
}

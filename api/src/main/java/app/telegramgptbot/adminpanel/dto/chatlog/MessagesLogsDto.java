package app.telegramgptbot.adminpanel.dto.chatlog;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

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

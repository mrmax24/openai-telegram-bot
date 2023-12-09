package app.telegramgptbot.adminpanel.dto.chatlog;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChatLogResponseDto {
    private Long id;
    private Long chatId;
    private String tgUsername;
    private String fullUsername;
    private String userMessage;
    private String chatResponse;
    private String adminResponse;
    private LocalDateTime userMessageTime;
    private LocalDateTime chatResponseTime;
    private LocalDateTime adminResponseTime;
}

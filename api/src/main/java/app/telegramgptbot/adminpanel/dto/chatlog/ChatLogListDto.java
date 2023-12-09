package app.telegramgptbot.adminpanel.dto.chatlog;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ChatLogListDto {
    private Long chatId;
    private String tgUsername;
    private String userMessage;
    private Number userMessageCount;
    private Number chatResponseCount;
    private Number adminResponseCount;
    private LocalDateTime maxUserMessageTime;
}


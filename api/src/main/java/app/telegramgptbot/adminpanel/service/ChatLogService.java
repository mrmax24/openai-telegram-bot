package app.telegramgptbot.adminpanel.service;

import app.telegramgptbot.adminpanel.dto.chatlog.*;

import java.util.List;

public interface ChatLogService {
    ChatLogResponseDto save(ChatLogRequestDto chatLogRequestDto);

    ChatLogResponseDto getChatLogById(Long id);

    List<ChatLogListDto> getChatList();

    List<MessagesLogsDto> getMessageList();

    List<ChatLogByIdDto> getLogsByChatId(Long chatId);
}

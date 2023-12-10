package app.telegramgptbot.adminpanel.service.impl;

import app.telegramgptbot.adminpanel.dto.admin.AdminMessageResponseDto;
import app.telegramgptbot.adminpanel.dto.chatlog.ChatLogResponseDto;
import app.telegramgptbot.adminpanel.service.AdminResponseHandler;
import app.telegramgptbot.adminpanel.service.ChatLogService;
import app.telegramgptbot.telegrambot.TelegramBot;
import java.sql.Timestamp;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminResponseHandlerImpl implements AdminResponseHandler {
    private final ChatLogService chatLogService;
    private final TelegramBot telegramBot;

    public AdminMessageResponseDto handleAdminResponse(
            ChatLogResponseDto chatLogResponseDto, String message) {
        long adminResponseTime = System.currentTimeMillis();
        chatLogResponseDto.setAdminResponse(message);
        chatLogResponseDto.setAdminResponseTime(new Timestamp(adminResponseTime).toLocalDateTime());
        chatLogService.update(chatLogResponseDto);
        telegramBot.sendMessage(chatLogResponseDto.getChatId(), message);
        AdminMessageResponseDto responseDto = new AdminMessageResponseDto();
        responseDto.setMessage("Message was sent successfully");
        return responseDto;
    }
}

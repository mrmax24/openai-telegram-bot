package app.telegramgptbot.adminpanel.controller;

import app.telegramgptbot.adminpanel.dto.admin.AdminMessageRequestDto;
import app.telegramgptbot.adminpanel.dto.admin.AdminMessageResponseDto;
import app.telegramgptbot.adminpanel.dto.admin.AdminResponseDto;
import app.telegramgptbot.adminpanel.dto.chatlog.ChatLogByIdDto;
import app.telegramgptbot.adminpanel.dto.chatlog.ChatLogListDto;
import app.telegramgptbot.adminpanel.dto.chatlog.ChatLogResponseDto;
import app.telegramgptbot.adminpanel.dto.chatlog.MessagesLogsDto;
import app.telegramgptbot.adminpanel.mapper.AdminMapper;
import app.telegramgptbot.adminpanel.mapper.AdminMessageMapper;
import app.telegramgptbot.adminpanel.service.AdminResponseHandler;
import app.telegramgptbot.adminpanel.service.AdminService;
import app.telegramgptbot.adminpanel.service.ChatLogService;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class AdminPanelController {
    private final AdminService adminService;
    private final ChatLogService chatLogService;
    private final AdminMessageMapper adminMessageMapper;
    private final AdminMapper adminMapper;
    private final AdminResponseHandler adminResponseHandler;

    @GetMapping("/admin")
    public AdminResponseDto getAdmin() {
        return adminMapper.mapToDto(adminService.getAdmin());
    }

    @GetMapping
    public List<ChatLogListDto> getChatList() {
        return chatLogService.getChatList();
    }

    @GetMapping("/{id}")
    public List<ChatLogByIdDto> getLogsByChatId(@PathVariable Long id) {
        return chatLogService.getLogsByChatId(id);
    }

    @GetMapping("/messages")
    public List<MessagesLogsDto> getLogsByChatIdForMessagesPage() {
        return chatLogService.getMessageList();
    }

    @PostMapping("/reply/{id}")
    public AdminMessageResponseDto respondToUser(@PathVariable Long id, @Valid @RequestBody
                                                 AdminMessageRequestDto requestDto) {
        ChatLogResponseDto chatLogResponseDto = chatLogService.getChatLogById(id);
        String adminResponse = adminMessageMapper.mapToModel(requestDto).getAdminResponse();
        return adminResponseHandler.handleAdminResponse(chatLogResponseDto, adminResponse);
    }
}

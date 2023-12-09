package app.telegramgptbot.adminpanel.service.impl;

import app.telegramgptbot.adminpanel.dto.chatlog.ChatLogByIdDto;
import app.telegramgptbot.adminpanel.dto.chatlog.ChatLogListDto;
import app.telegramgptbot.adminpanel.dto.chatlog.ChatLogRequestDto;
import app.telegramgptbot.adminpanel.dto.chatlog.ChatLogResponseDto;
import app.telegramgptbot.adminpanel.dto.chatlog.MessagesLogsDto;
import app.telegramgptbot.adminpanel.exception.EntityNotFoundException;
import app.telegramgptbot.adminpanel.mapper.ChatLogMapper;
import app.telegramgptbot.adminpanel.model.ChatLog;
import app.telegramgptbot.adminpanel.repository.ChatLogRepository;
import app.telegramgptbot.adminpanel.service.ChatLogService;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class ChatLogServiceImpl implements ChatLogService {
    private final ChatLogRepository chatLogRepository;
    private final ChatLogMapper chatLogMapper;

    @Override
    public ChatLogResponseDto save(ChatLogRequestDto chatLogRequestDto) {
        ChatLog chatLog = chatLogMapper.mapToModel(chatLogRequestDto);
        return chatLogMapper.mapToDto(chatLogRepository.save(chatLog));
    }

    @Override
    @Transactional
    public ChatLogResponseDto update(ChatLogResponseDto chatLogResponseDto) {
        Long chatId = chatLogResponseDto.getId();
        Optional<ChatLog> existingChatLogOptional = chatLogRepository.findById(chatId);

        if (existingChatLogOptional.isPresent()) {
            ChatLog existingChatLog = existingChatLogOptional.get();
            existingChatLog.setAdminResponse(chatLogResponseDto.getAdminResponse());
            existingChatLog.setAdminResponseTime(chatLogResponseDto.getAdminResponseTime());

            return chatLogMapper.mapToDto(chatLogRepository.save(existingChatLog));
        } else {
            throw new EntityNotFoundException("ChatLog not found with ID: " + chatId);
        }
    }

    @Override
    public ChatLogResponseDto getChatLogById(Long id) {
        return chatLogMapper.mapToDto(chatLogRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Couldn't find chat logs by id: " + id)));
    }

    @Override
    public List<ChatLogListDto> getChatList() {
        return chatLogRepository.getChatList();
    }

    @Override
    public List<MessagesLogsDto> getMessageList() {
        return chatLogRepository.getMessagesList();
    }

    @Override
    public List<ChatLogByIdDto> getLogsByChatId(Long chatId) {
        return chatLogRepository.getLogsByChatId(chatId);
    }
}

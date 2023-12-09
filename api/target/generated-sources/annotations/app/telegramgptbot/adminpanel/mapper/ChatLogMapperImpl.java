package app.telegramgptbot.adminpanel.mapper;

import app.telegramgptbot.adminpanel.dto.chatlog.ChatLogRequestDto;
import app.telegramgptbot.adminpanel.dto.chatlog.ChatLogResponseDto;
import app.telegramgptbot.adminpanel.model.ChatLog;
import java.time.LocalDateTime;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-12-08T17:58:39+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.8 (Oracle Corporation)"
)
@Component
public class ChatLogMapperImpl implements ChatLogMapper {

    @Override
    public ChatLogResponseDto mapToDto(ChatLog chatLog) {
        if ( chatLog == null ) {
            return null;
        }

        ChatLogResponseDto chatLogResponseDto = new ChatLogResponseDto();

        if ( chatLog.getId() != null ) {
            chatLogResponseDto.setId( chatLog.getId() );
        }
        if ( chatLog.getChatId() != null ) {
            chatLogResponseDto.setChatId( chatLog.getChatId() );
        }
        if ( chatLog.getTgUsername() != null ) {
            chatLogResponseDto.setTgUsername( chatLog.getTgUsername() );
        }
        if ( chatLog.getFullUsername() != null ) {
            chatLogResponseDto.setFullUsername( chatLog.getFullUsername() );
        }
        if ( chatLog.getUserMessage() != null ) {
            chatLogResponseDto.setUserMessage( chatLog.getUserMessage() );
        }
        if ( chatLog.getChatResponse() != null ) {
            chatLogResponseDto.setChatResponse( chatLog.getChatResponse() );
        }
        if ( chatLog.getAdminResponse() != null ) {
            chatLogResponseDto.setAdminResponse( chatLog.getAdminResponse() );
        }
        if ( chatLog.getUserMessageTime() != null ) {
            chatLogResponseDto.setUserMessageTime( chatLog.getUserMessageTime() );
        }
        if ( chatLog.getChatResponseTime() != null ) {
            chatLogResponseDto.setChatResponseTime( chatLog.getChatResponseTime() );
        }
        if ( chatLog.getAdminResponseTime() != null ) {
            chatLogResponseDto.setAdminResponseTime( chatLog.getAdminResponseTime() );
        }

        return chatLogResponseDto;
    }

    @Override
    public ChatLog mapToModel(ChatLogRequestDto chatLogRequestDto) {
        if ( chatLogRequestDto == null ) {
            return null;
        }

        ChatLog chatLog = new ChatLog();

        if ( chatLogRequestDto.getChatId() != null ) {
            chatLog.setChatId( chatLogRequestDto.getChatId() );
        }
        if ( chatLogRequestDto.getTgUsername() != null ) {
            chatLog.setTgUsername( chatLogRequestDto.getTgUsername() );
        }
        if ( chatLogRequestDto.getFullUsername() != null ) {
            chatLog.setFullUsername( chatLogRequestDto.getFullUsername() );
        }
        if ( chatLogRequestDto.getUserMessage() != null ) {
            chatLog.setUserMessage( chatLogRequestDto.getUserMessage() );
        }
        if ( chatLogRequestDto.getChatResponse() != null ) {
            chatLog.setChatResponse( chatLogRequestDto.getChatResponse() );
        }
        if ( chatLogRequestDto.getAdminResponse() != null ) {
            chatLog.setAdminResponse( chatLogRequestDto.getAdminResponse() );
        }
        if ( chatLogRequestDto.getUserMessageTime() != null ) {
            chatLog.setUserMessageTime( chatLogRequestDto.getUserMessageTime() );
        }
        if ( chatLogRequestDto.getChatResponseTime() != null ) {
            chatLog.setChatResponseTime( chatLogRequestDto.getChatResponseTime() );
        }
        if ( chatLogRequestDto.getAdminResponseTime() != null ) {
            chatLog.setAdminResponseTime( chatLogRequestDto.getAdminResponseTime() );
        }

        return chatLog;
    }

    @Override
    public ChatLogRequestDto mapToRequestDto(ChatLogResponseDto chatLogResponseDto) {
        if ( chatLogResponseDto == null ) {
            return null;
        }

        Long chatId = null;
        String tgUsername = null;
        String fullUsername = null;
        String userMessage = null;
        String chatResponse = null;
        LocalDateTime userMessageTime = null;
        LocalDateTime chatResponseTime = null;

        if ( chatLogResponseDto.getChatId() != null ) {
            chatId = chatLogResponseDto.getChatId();
        }
        if ( chatLogResponseDto.getTgUsername() != null ) {
            tgUsername = chatLogResponseDto.getTgUsername();
        }
        if ( chatLogResponseDto.getFullUsername() != null ) {
            fullUsername = chatLogResponseDto.getFullUsername();
        }
        if ( chatLogResponseDto.getUserMessage() != null ) {
            userMessage = chatLogResponseDto.getUserMessage();
        }
        if ( chatLogResponseDto.getChatResponse() != null ) {
            chatResponse = chatLogResponseDto.getChatResponse();
        }
        if ( chatLogResponseDto.getUserMessageTime() != null ) {
            userMessageTime = chatLogResponseDto.getUserMessageTime();
        }
        if ( chatLogResponseDto.getChatResponseTime() != null ) {
            chatResponseTime = chatLogResponseDto.getChatResponseTime();
        }

        ChatLogRequestDto chatLogRequestDto = new ChatLogRequestDto( chatId, tgUsername, fullUsername, userMessage, chatResponse, userMessageTime, chatResponseTime );

        if ( chatLogResponseDto.getAdminResponse() != null ) {
            chatLogRequestDto.setAdminResponse( chatLogResponseDto.getAdminResponse() );
        }
        if ( chatLogResponseDto.getAdminResponseTime() != null ) {
            chatLogRequestDto.setAdminResponseTime( chatLogResponseDto.getAdminResponseTime() );
        }

        return chatLogRequestDto;
    }
}

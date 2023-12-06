package app.telegramgptbot.adminpanel.mapper;

import app.telegramgptbot.adminpanel.dto.admin.AdminMessageRequestDto;
import app.telegramgptbot.adminpanel.dto.admin.AdminMessageResponseDto;
import app.telegramgptbot.adminpanel.model.ChatLog;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-12-06T18:30:34+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.8 (Oracle Corporation)"
)
@Component
public class AdminMessageMapperImpl implements AdminMessageMapper {

    @Override
    public ChatLog mapToModel(AdminMessageRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        ChatLog chatLog = new ChatLog();

        if ( dto.getAdminResponse() != null ) {
            chatLog.setAdminResponse( dto.getAdminResponse() );
        }

        return chatLog;
    }

    @Override
    public AdminMessageResponseDto mapToDto(ChatLog chatLog) {
        if ( chatLog == null ) {
            return null;
        }

        AdminMessageResponseDto adminMessageResponseDto = new AdminMessageResponseDto();

        return adminMessageResponseDto;
    }
}

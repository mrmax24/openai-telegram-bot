package app.telegramgptbot.adminpanel.mapper;

import app.telegramgptbot.adminpanel.dto.admin.AdminResponseDto;
import app.telegramgptbot.adminpanel.model.Admin;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-12-10T01:58:28+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.8 (Oracle Corporation)"
)
@Component
public class AdminMapperImpl implements AdminMapper {

    @Override
    public AdminResponseDto mapToDto(Admin admin) {
        if ( admin == null ) {
            return null;
        }

        AdminResponseDto adminResponseDto = new AdminResponseDto();

        if ( admin.getEmail() != null ) {
            adminResponseDto.setEmail( admin.getEmail() );
        }

        return adminResponseDto;
    }
}

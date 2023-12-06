package app.telegramgptbot.adminpanel.mapper;

import app.telegramgptbot.adminpanel.dto.admin.AdminLoginRequestDto;
import app.telegramgptbot.adminpanel.dto.admin.AdminLoginResponseDto;
import app.telegramgptbot.adminpanel.model.Admin;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-12-06T18:30:34+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.8 (Oracle Corporation)"
)
@Component
public class LoginMapperImpl implements LoginMapper {

    @Override
    public Admin mapToModel(AdminLoginRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        Admin admin = new Admin();

        if ( dto.getEmail() != null ) {
            admin.setEmail( dto.getEmail() );
        }
        if ( dto.getPassword() != null ) {
            admin.setPassword( dto.getPassword() );
        }

        return admin;
    }

    @Override
    public AdminLoginResponseDto mapToDto(Admin admin) {
        if ( admin == null ) {
            return null;
        }

        String token = null;

        AdminLoginResponseDto adminLoginResponseDto = new AdminLoginResponseDto( token );

        return adminLoginResponseDto;
    }
}

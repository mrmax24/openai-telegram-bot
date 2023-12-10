package app.telegramgptbot.adminpanel.mapper;

import app.telegramgptbot.adminpanel.dto.admin.AdminRegisterRequestDto;
import app.telegramgptbot.adminpanel.dto.admin.AdminRegisterResponseDto;
import app.telegramgptbot.adminpanel.model.Admin;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-12-10T01:58:28+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.8 (Oracle Corporation)"
)
@Component
public class RegisterMapperImpl implements RegisterMapper {

    @Override
    public Admin mapToModel(AdminRegisterRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        Admin admin = new Admin();

        if ( dto.getLogin() != null ) {
            admin.setLogin( dto.getLogin() );
        }
        if ( dto.getEmail() != null ) {
            admin.setEmail( dto.getEmail() );
        }
        if ( dto.getPassword() != null ) {
            admin.setPassword( dto.getPassword() );
        }

        return admin;
    }

    @Override
    public AdminRegisterResponseDto mapToDto(Admin admin) {
        if ( admin == null ) {
            return null;
        }

        AdminRegisterResponseDto adminRegisterResponseDto = new AdminRegisterResponseDto();

        if ( admin.getId() != null ) {
            adminRegisterResponseDto.setId( admin.getId() );
        }
        if ( admin.getEmail() != null ) {
            adminRegisterResponseDto.setEmail( admin.getEmail() );
        }

        return adminRegisterResponseDto;
    }
}

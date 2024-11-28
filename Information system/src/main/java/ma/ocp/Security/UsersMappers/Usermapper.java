package ma.ocp.Security.UsersMappers;

import ma.ocp.Dtos.User_DTO;
import ma.ocp.Security.entities.appUser;
import org.mapstruct.Mapper;


@Mapper(componentModel="spring")
public interface Usermapper {
    User_DTO toUserDto(appUser user);
}

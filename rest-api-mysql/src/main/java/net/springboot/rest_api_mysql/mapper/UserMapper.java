package net.springboot.rest_api_mysql.mapper;

import net.springboot.rest_api_mysql.dto.UserDto;
import net.springboot.rest_api_mysql.entity.User;

public class UserMapper {
    //corvert user JPA Entity into userDto
    public static UserDto mapToUserDto(User user) {
        UserDto userDto = new UserDto(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail()
        );
        return userDto;
    }
    //corvert user JPA Entity into userDto
    public static User mapToUser(UserDto userDto) {
        User user = new User(
                userDto.getId(),
                userDto.getFirstName(),
                userDto.getLastName(),
                userDto.getEmail()
        );
        return user;
    }
}



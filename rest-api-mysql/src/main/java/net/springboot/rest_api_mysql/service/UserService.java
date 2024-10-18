package net.springboot.rest_api_mysql.service;
import net.springboot.rest_api_mysql.dto.UserDto;
import net.springboot.rest_api_mysql.entity.User;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto user);

    UserDto getUserById(Long userId);

    List<UserDto> getAllUsers();

    UserDto updateUser(UserDto user);

    void deleteUser(Long userId);
}



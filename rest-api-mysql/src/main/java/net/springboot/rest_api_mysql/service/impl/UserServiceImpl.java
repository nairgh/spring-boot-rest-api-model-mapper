package net.springboot.rest_api_mysql.service.impl;
import lombok.AllArgsConstructor;
import net.springboot.rest_api_mysql.dto.UserDto;
import net.springboot.rest_api_mysql.entity.User;
import net.springboot.rest_api_mysql.mapper.UserMapper;
import net.springboot.rest_api_mysql.repository.UserRepository;
import net.springboot.rest_api_mysql.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private ModelMapper modelMapper;

    // create
    @Override
    public UserDto createUser(UserDto userDto) {
        //convert userDto into user JPA entity
        //User user = UserMapper.mapToUser(userDto);
        User user = modelMapper.map(userDto, User.class);
        User savedUser = userRepository.save(user);

        //convert user jpa entity to userDto
        //UserDto savedUserDto = UserMapper.mapToUserDto(user);
        UserDto savedUserDto = modelMapper.map(savedUser,UserDto.class);
       return savedUserDto;
    };

    @Override
    public UserDto getUserById(Long userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        User user =optionalUser.get();
        //return UserMapper.mapToUserDto(user);
        return modelMapper.map(user,UserDto.class);
    }
    @Override
    public List<UserDto> getAllUsers() {
       List<User> users = userRepository.findAll();
//       return users.stream().map(UserMapper::mapToUserDto)
//               .collect(Collectors.toList());
        return users.stream().map((user)->modelMapper.map(user, UserDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public UserDto updateUser(UserDto user) {
        User existingUser = userRepository.findById(user.getId()).get();
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());
        User updatedUser = userRepository.save(existingUser);
        //return UserMapper.mapToUserDto(updatedUser);
        return modelMapper.map(updatedUser,UserDto.class);
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}

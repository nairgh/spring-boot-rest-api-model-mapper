package net.springboot.rest_api_mysql.controller;

import lombok.AllArgsConstructor;
import net.springboot.rest_api_mysql.dto.UserDto;
import net.springboot.rest_api_mysql.entity.User;
import net.springboot.rest_api_mysql.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/users")
public class UserController {

    private UserService userService;
    //create REST API
    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto user){
       UserDto savedUser = userService.createUser(user);
       return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }
   // get user by id REST API
    @GetMapping("{id}")
    public ResponseEntity<UserDto>getUserById(@PathVariable("id") Long userID){
        UserDto user = userService.getUserById(userID);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }
    // get all users REST API

    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers(){
        List<UserDto> users = userService.getAllUsers();
        return new ResponseEntity<>(users,HttpStatus.OK);
    }

    //update user REST API
    @PutMapping("{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable("id")Long userId, @RequestBody UserDto user){
        user.setId(userId);
        UserDto updatedUser = userService.updateUser(user);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }
    // delete user
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long userId){
        userService.deleteUser(userId);
        return new ResponseEntity<>("User successfully deleted", HttpStatus.OK);
    }

}

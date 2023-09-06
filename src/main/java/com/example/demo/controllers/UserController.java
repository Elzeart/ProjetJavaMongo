package com.example.demo.controllers;

import com.example.demo.Mapper.UserMapper;
import com.example.demo.dto.UserDTO;
import com.example.demo.entities.User;
import com.example.demo.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1")
public class UserController {
    private final UserService userService;
    private final UserMapper userMapper = UserMapper.INSTANCE;

    @PostMapping("/users")
    public ResponseEntity<User> registerUser(@RequestBody UserDTO userDTO) throws URISyntaxException {
        User userResult = this.userService.save(userMapper.userToUserDTO(userDTO));
        return ResponseEntity.ok(userResult);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") String userId, @RequestBody UserDTO user) throws URISyntaxException {
        User userResult = this.userService.update(userId, user);
        return ResponseEntity.ok(userResult);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") String userId) {
        this.userService.delete(userId);
        return new ResponseEntity(HttpStatusCode.valueOf(204));
    }

}

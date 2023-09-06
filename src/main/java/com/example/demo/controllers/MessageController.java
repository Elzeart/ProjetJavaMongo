package com.example.demo.controllers;

import com.example.demo.dto.MessageDTO;
import com.example.demo.entities.Message;
import com.example.demo.entities.User;
import com.example.demo.services.MessageService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.services.UserService;

import java.net.URISyntaxException;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1")
public class MessageController {
    private final UserService userService;
    private final MessageService messageService;

    @PostMapping("/users/{id}/messages")
    public ResponseEntity<Message> createMessage(@PathVariable("id") String userId, @RequestBody MessageDTO message) throws URISyntaxException {
        User user = this.userService.findbyId(userId);
        Message messageResult = messageService.save(message);
        user.addMessage(messageResult);
        userService.save(user);
        return ResponseEntity.ok(messageResult);
    }
}

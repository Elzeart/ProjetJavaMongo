package com.example.demo.Mapper;

import com.example.demo.dto.MessageDTO;
import com.example.demo.entities.Message;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
public class MessageMapping {
    public Message mapMessageFromMessageDto(MessageDTO messageDTO) {
        Message message = new Message();
        message.setContent(messageDTO.getContent());
        message.setDateCreation(LocalDateTime.now());
        return message;
    }
}

package com.example.demo.services;

import com.example.demo.Mapper.MessageMapping;
import com.example.demo.dto.MessageDTO;
import com.example.demo.entities.Message;
import com.example.demo.repositories.MessageRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class MessageService {
    private final MessageRepository messageRepository;
    private final MessageMapping messageMapping;
    public Message save(MessageDTO messageDTO){
        Message message = messageMapping.mapMessageFromMessageDto(messageDTO);
        return this.messageRepository.save(message);
    }

}

package com.example.demo.Mapper;

import com.example.demo.dto.UserDTO;
import com.example.demo.entities.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapping {
    public User mapUserFromUserDto(User user, UserDTO userDTO){
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setDateCreation(userDTO.getDateCreation());
        return user;
    }
}

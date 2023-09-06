package com.example.demo.services;

import com.example.demo.Mapper.UserMapping;
import com.example.demo.dto.UserDTO;
import com.example.demo.entities.User;
import com.example.demo.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserMapping userMapping;
    private final PasswordEncoder encoder;
    public UserService(UserRepository userRepository, UserMapping userMapping, PasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.userMapping = userMapping;
        this.encoder = encoder;
    }

    public User save(User user){
        user.setPassword(encoder.encode(user.getPassword()));
       return this.userRepository.save(user);
    }

    public User update(String userId, UserDTO userDTO) {
        User userFind = this.userRepository.findById(userId).orElse(null);
        if(userFind != null) {
            return this.userRepository.save(userMapping.mapUserFromUserDto(userFind, userDTO));
        }
        return userFind;
    }

    public void delete(String userId){
        this.userRepository.deleteById(userId);
    }

    public User findbyId (String userId){
        User userFind = this.userRepository.findById(userId).orElse(null);
        return userFind;
    }
}

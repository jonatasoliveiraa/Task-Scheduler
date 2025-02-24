package com.taskscheduler.User.business;

import com.taskscheduler.User.business.converter.UserConverter;
import com.taskscheduler.User.business.dto.UserDTO;
import com.taskscheduler.User.infrastructure.entity.User;
import com.taskscheduler.User.infrastructure.exception.ConflictException;
import com.taskscheduler.User.infrastructure.exception.ResourceNotFoundException;
import com.taskscheduler.User.infrastructure.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserConverter userConverter;
    private final PasswordEncoder passwordEncoder;

    public UserDTO createUser(UserDTO userDTO) {
        try {
            emailExist(userDTO.getEmail());
            User user = userConverter.toUser(userDTO);
            user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
            user = userRepository.save(user);
            return userConverter.toUserDTO(user);
        } catch (ConflictException e) {
            throw new ConflictException("Email already registered " + e.getCause());
        }
    }

    public void emailExist(String email) {
        try {
            boolean emailExist = verifyEmail(email);
            if (emailExist) {
                throw new ConflictException("Email already registered");
            }
        } catch (ConflictException e) {
            throw new ConflictException("Email already registered " + e.getCause());
        }
    }

    public boolean verifyEmail(String email) {
        return userRepository.existsByEmail(email);
    }


    public User findByEmail(String email){
        return userRepository.findUserByEmail(email).orElseThrow(
                () -> new ResourceNotFoundException("Email is not found")
        );
    }
//
    public void deleteByEmail(String email){
        userRepository.deleteByEmail(email);
    }

}

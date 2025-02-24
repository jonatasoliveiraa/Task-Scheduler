package com.taskscheduler.User.business;

import com.taskscheduler.User.business.converter.UserConverter;
import com.taskscheduler.User.business.dto.UserDTO;
import com.taskscheduler.User.infrastructure.entity.User;
import com.taskscheduler.User.infrastructure.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserConverter userConverter;

    public UserDTO createUser(UserDTO userDTO){
        User user = userConverter.toUser(userDTO);
        user = userRepository.save(user);
        return userConverter.toUserDTO(user);
    }


}

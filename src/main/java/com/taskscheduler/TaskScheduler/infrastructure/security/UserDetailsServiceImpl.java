package com.taskscheduler.TaskScheduler.infrastructure.security;

import com.taskscheduler.TaskScheduler.business.dto.UserDto;
import com.taskscheduler.TaskScheduler.infrastructure.client.UserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl {

    @Autowired
    private UserClient client;

    public UserDetails loadUserByUsername(String email, String token){

        UserDto userDTO = client.findByEmail(email, token);

        return User
                .withUsername(userDTO.getEmail())
                .password(userDTO.getPassword())
                .build();
    }

}

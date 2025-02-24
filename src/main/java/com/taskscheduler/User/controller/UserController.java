package com.taskscheduler.User.controller;

import com.taskscheduler.User.business.UserService;
import com.taskscheduler.User.business.dto.UserDTO;
import com.taskscheduler.User.infrastructure.entity.User;
import com.taskscheduler.User.infrastructure.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO){
        return ResponseEntity.ok(userService.createUser(userDTO));
    }
}

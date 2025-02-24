package com.taskscheduler.User.controller;

import com.taskscheduler.User.business.UserService;
import com.taskscheduler.User.business.dto.UserDTO;
import com.taskscheduler.User.infrastructure.entity.User;
import com.taskscheduler.User.infrastructure.repository.UserRepository;
import com.taskscheduler.User.infrastructure.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO){
        return ResponseEntity.ok(userService.createUser(userDTO));
    }

    @PostMapping("/login")
    public String login(@RequestBody UserDTO userDTO){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(userDTO.getEmail(),userDTO.getPassword()));
        return "Bearer " + jwtUtil.generateToken(authentication.getName());
    }

    @GetMapping
    public ResponseEntity<User> findByEmail(@RequestParam("email") String email){
        return ResponseEntity.ok(userService.findByEmail(email));
    }
//
    @DeleteMapping("/{email}")
    public ResponseEntity<Void> deleteByEmail(@PathVariable String email){
        userService.deleteByEmail(email);
        return ResponseEntity.ok().build();
    }
}

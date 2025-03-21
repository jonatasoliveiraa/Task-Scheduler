package com.taskscheduler.TaskScheduler.infrastructure.client;

import com.taskscheduler.TaskScheduler.business.dto.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "user", url = "${user.url}")
public interface UserClient {

    @GetMapping("/user")
    UserDTO findByEmail(@RequestParam("email") String email,
                        @RequestHeader("Authorization") String token);
}

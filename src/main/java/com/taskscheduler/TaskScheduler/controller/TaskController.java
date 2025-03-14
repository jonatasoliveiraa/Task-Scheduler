package com.taskscheduler.TaskScheduler.controller;

import com.taskscheduler.TaskScheduler.business.dto.TaskDTO;
import com.taskscheduler.TaskScheduler.business.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @PostMapping
    public ResponseEntity<TaskDTO> createTask(@RequestBody TaskDTO taskDTO,
                                              @RequestHeader("Authorization") String token){
        return ResponseEntity.ok(taskService.createTask(taskDTO, token));
    }

    @GetMapping("/events")
    public ResponseEntity<List<TaskDTO>> findTasksByEventDate(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime initialDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime finalDate){
        return ResponseEntity.ok(taskService.findByEventDate(initialDate,finalDate));
    }

    @GetMapping
    public ResponseEntity<List<TaskDTO>> findTasksByEmail(@RequestHeader("Authorization") String token){
        return ResponseEntity.ok(taskService.findByEmail(token));
    }
}

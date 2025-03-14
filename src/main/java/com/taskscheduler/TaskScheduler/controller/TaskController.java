package com.taskscheduler.TaskScheduler.controller;

import com.taskscheduler.TaskScheduler.business.dto.TaskDTO;
import com.taskscheduler.TaskScheduler.business.service.TaskService;
import com.taskscheduler.TaskScheduler.infrastructure.enums.TaskStatusEnum;
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

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTaskById(@PathVariable String id){
        taskService.deleteTaskById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<TaskDTO> updateTask(@RequestBody TaskDTO taskDTO,
                                              @RequestParam("id") String id){
        return ResponseEntity.ok(taskService.updateTask(taskDTO,id));
    }

    @PatchMapping
    public ResponseEntity<TaskDTO> updateStatus(@RequestParam("status") TaskStatusEnum status,
                                                @RequestParam("id") String id){
        return ResponseEntity.ok(taskService.updateStatus(status,id));
    }
}

package com.taskscheduler.TaskScheduler.business.service;

import com.taskscheduler.TaskScheduler.business.dto.TaskDTO;
import com.taskscheduler.TaskScheduler.business.mapper.TaskConverter;
import com.taskscheduler.TaskScheduler.infrastructure.entity.TaskEntity;
import com.taskscheduler.TaskScheduler.infrastructure.enums.TaskStatusEnum;
import com.taskscheduler.TaskScheduler.infrastructure.repository.TaskRepository;
import com.taskscheduler.TaskScheduler.infrastructure.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;
    private final TaskConverter taskConverter;
    private final JwtUtil jwtUtil;

    public TaskDTO createTask(TaskDTO taskDTO, String token){

        String email = jwtUtil.extractUsername(token.substring(7));

        taskDTO.setCreationDate(LocalDateTime.now());
        taskDTO.setUserEmail(email);
        taskDTO.setStatus(TaskStatusEnum.PENDING);
        TaskEntity entity = taskConverter.toTaskEntity(taskDTO);

        return taskConverter.toTaskDTO(taskRepository.save(entity));
    }
}

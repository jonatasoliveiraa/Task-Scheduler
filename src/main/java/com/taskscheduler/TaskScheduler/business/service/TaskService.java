package com.taskscheduler.TaskScheduler.business.service;

import com.taskscheduler.TaskScheduler.business.dto.TaskDTO;
import com.taskscheduler.TaskScheduler.business.mapper.TaskConverter;
import com.taskscheduler.TaskScheduler.business.mapper.TaskUpdateConverter;
import com.taskscheduler.TaskScheduler.infrastructure.entity.TaskEntity;
import com.taskscheduler.TaskScheduler.infrastructure.enums.TaskStatusEnum;
import com.taskscheduler.TaskScheduler.infrastructure.exception.ResourceNotFoundException;
import com.taskscheduler.TaskScheduler.infrastructure.repository.TaskRepository;
import com.taskscheduler.TaskScheduler.infrastructure.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;
    private final TaskConverter taskConverter;
    private final TaskUpdateConverter taskUpdateConverter;
    private final JwtUtil jwtUtil;

    public TaskDTO createTask(TaskDTO taskDTO, String token){

        String email = jwtUtil.extractUsername(token.substring(7));

        taskDTO.setCreationDate(LocalDateTime.now());
        taskDTO.setUserEmail(email);
        taskDTO.setStatus(TaskStatusEnum.PENDING);
        TaskEntity entity = taskConverter.toTaskEntity(taskDTO);

        return taskConverter.toTaskDTO(taskRepository.save(entity));
    }

    public List<TaskDTO> findByEventDate(LocalDateTime initialDate, LocalDateTime finalDate){
        return taskConverter.toListTaskDTO(taskRepository.findByEventDateBetween(initialDate,finalDate));
    }

    public List<TaskDTO> findByEmail(String token){

        String email = jwtUtil.extractUsername(token.substring(7));

        return taskConverter.toListTaskDTO(taskRepository.findByUserEmail(email));
    }

    public void deleteTaskById(String id){
        taskRepository.deleteById(id);
    }

    public TaskDTO updateTask(TaskDTO taskDTO,  String id){
        TaskEntity entity = taskRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Id not found"));
        entity.setChangeDate(LocalDateTime.now());

        taskUpdateConverter.updateTask(taskDTO,entity);

        return taskConverter.toTaskDTO(taskRepository.save(entity));
    }

    public TaskDTO updateStatus(TaskStatusEnum status, String id){

        TaskEntity entity = taskRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Id not found"));
        entity.setStatus(status);
        entity.setChangeDate(LocalDateTime.now());

        return taskConverter.toTaskDTO(taskRepository.save(entity));
    }
}

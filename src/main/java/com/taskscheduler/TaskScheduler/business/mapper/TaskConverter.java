package com.taskscheduler.TaskScheduler.business.mapper;

import com.taskscheduler.TaskScheduler.business.dto.TaskDTO;
import com.taskscheduler.TaskScheduler.infrastructure.entity.TaskEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.time.LocalDateTime;
import java.util.List;

@Mapper(componentModel = "spring")
public interface TaskConverter {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "eventDate", target = "eventDate")
    @Mapping(source = "creationDate", target = "creationDate")
    TaskEntity toTaskEntity(TaskDTO taskDTO);

    TaskDTO toTaskDTO(TaskEntity taskEntity);

    List<TaskEntity> toListTaskEntity(List<TaskDTO> taskDTO);

    List<TaskDTO> toListTaskDTO(List<TaskEntity> taskEntity);


}

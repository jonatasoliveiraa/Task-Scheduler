package com.taskscheduler.TaskScheduler.business.mapper;

import com.taskscheduler.TaskScheduler.business.dto.TaskDTO;
import com.taskscheduler.TaskScheduler.infrastructure.entity.TaskEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TaskConverter {

    @Mapping(source = "id", target = "id")
    TaskEntity toTaskEntity(TaskDTO taskDTO);

    TaskDTO toTaskDTO(TaskEntity taskEntity);
}

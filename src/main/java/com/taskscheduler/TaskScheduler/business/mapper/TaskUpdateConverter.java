package com.taskscheduler.TaskScheduler.business.mapper;

import com.taskscheduler.TaskScheduler.business.dto.TaskDTO;
import com.taskscheduler.TaskScheduler.infrastructure.entity.TaskEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface TaskUpdateConverter {

    void updateTask(TaskDTO taskDTO, @MappingTarget TaskEntity taskEntity);
}

package com.taskscheduler.TaskScheduler.infrastructure.repository;

import com.taskscheduler.TaskScheduler.infrastructure.entity.TaskEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TaskRepository extends MongoRepository<TaskEntity,String> {

    List<TaskEntity> findByEventDateBetween(LocalDateTime initialDate, LocalDateTime finalDate);

    List<TaskEntity> findByUserEmail(String email);

}

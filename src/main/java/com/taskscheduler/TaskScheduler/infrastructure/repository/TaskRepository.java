package com.taskscheduler.TaskScheduler.infrastructure.repository;

import com.taskscheduler.TaskScheduler.infrastructure.entity.TaskEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends MongoRepository<TaskEntity,String> {
}

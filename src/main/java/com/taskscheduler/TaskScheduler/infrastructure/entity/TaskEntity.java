package com.taskscheduler.TaskScheduler.infrastructure.entity;

import com.taskscheduler.TaskScheduler.infrastructure.enums.TaskStatusEnum;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document("task")
public class TaskEntity {

    @Id
    private String id;
    private String taskName;
    private String description;
    private LocalDateTime creationDate;
    private LocalDateTime eventDate;
    private String userEmail;
    private LocalDateTime changeDate;
    private TaskStatusEnum status;
}

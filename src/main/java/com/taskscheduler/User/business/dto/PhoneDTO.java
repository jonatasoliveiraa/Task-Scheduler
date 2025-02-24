package com.taskscheduler.User.business.dto;

import jakarta.persistence.Column;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PhoneDTO {

    private String phoneNumber;
    private String ddd;
}

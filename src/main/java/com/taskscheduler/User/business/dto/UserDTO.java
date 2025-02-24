package com.taskscheduler.User.business.dto;


import com.taskscheduler.User.infrastructure.entity.Address;
import com.taskscheduler.User.infrastructure.entity.Phone;
import com.taskscheduler.User.infrastructure.entity.User;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {

    private Long id;
    private String name;
    private String email;
    private String password;

    private List<AddressDTO> addressesDto;

    private List<PhoneDTO> phonesDto;
}

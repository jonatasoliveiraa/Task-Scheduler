package com.taskscheduler.User.infrastructure.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "address")
@Builder
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "street", length = 150)
    private String street;
    @Column(name = "number", length = 5)
    private Integer number;
    @Column(name = "complement", length = 10)
    private String complement;
    @Column(name = "neighborhood", length = 100)
    private String neighborhood;
    @Column(name = "city", length = 100)
    private String city;
    @Column(name = "state", length = 2)
    private String state;
    @Column(name = "zip_code", length = 10)
    private String zipCode;
}

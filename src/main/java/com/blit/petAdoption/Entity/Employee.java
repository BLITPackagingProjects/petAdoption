package com.blit.petAdoption.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Table(name="tbl_employee")
@Data
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Long employeeId;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false)
    private String Password;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="employee")
    private Set<Application> application;


}

package com.blit.petAdoption.Entity;

import jakarta.persistence.*;

import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.Date;

@Entity
@Table(name="tbl_application")
@Data
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long applicationId;

    @Column(nullable = false)
    private Date date;

    @Enumerated(EnumType.STRING)
    private ApplicationStatus status;

    @ManyToOne
    @JoinColumn(name="employee_id", nullable = false)
    private Employee employee;

    @ManyToOne
    @JoinColumn(name="pet_id", nullable = false)
    private Pets pets;

    @ManyToOne
    @JoinColumn(name="customer_id", nullable = false)
    private Customer customer;

}

package com.blit.petAdoption.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@Entity
@Table(name="tbl_application")
@Data
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long applicationId;

    @Column
    @Temporal(TemporalType.DATE)
    private Date date;

//    public LocalDate getDateAsLocalDate() {
//        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
//    }

    @Column(nullable = false)
    private String status;

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

package com.blit.petAdoption.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Table(name="tbl_pets")
@Data
public class Pets {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pet_id")
    private Long petId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int age;

    @Column(nullable = false)
    private String color;

    @Column(nullable = false)
    private String petType;

    @Column(nullable = false)
    private String breed;

    @Column(nullable = false)
    private char sex;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="pets")
    private Set<Application> application;

}



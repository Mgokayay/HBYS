package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "department",schema = "bizmed")
public class Department {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name",nullable = false)
    private String name;

    @OneToMany(mappedBy = "department",cascade = CascadeType.ALL)
    private List<Doctor> doctors=new ArrayList<>();

    @OneToMany(mappedBy = "department",cascade = CascadeType.ALL)
    private List<PatientVisit> patientVisits=new ArrayList<>();



}

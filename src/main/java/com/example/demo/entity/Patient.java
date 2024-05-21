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
@Table(name = "patient",schema = "bizmed")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_name",nullable = false)
    private String fullName;

    @Column(name = "date",nullable = false)
    private String date;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender",nullable = false)
    private Gender gender;

    @Column(name = "tckn",nullable = false,unique = true)
    private Long tckn;

    @OneToMany(cascade = {CascadeType.ALL},mappedBy = "patientvisit")
    private List<PatientVisit> patientVisits=new ArrayList<>();
}

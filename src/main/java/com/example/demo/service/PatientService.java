package com.example.demo.service;

import com.example.demo.dto.PatientResponse;
import com.example.demo.entity.Patient;

import java.util.List;

public interface PatientService {


    PatientResponse save(Patient patient);

    List<PatientResponse> findAll();

    PatientResponse findById(Long id);

    void delete(Long id);
}

package com.example.demo.service;

import com.example.demo.dto.PatientVisitResponse;
import com.example.demo.entity.PatientVisit;

import java.util.List;

public interface PatientVisitService {

    PatientVisitResponse save(PatientVisit patientVisit
    );

    List<PatientVisitResponse> findAll();

    PatientVisitResponse findById(Long id);

    void delete(Long id);
}

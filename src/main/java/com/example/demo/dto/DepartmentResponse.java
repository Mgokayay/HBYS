package com.example.demo.dto;

import java.util.List;

public record DepartmentResponse(Long id, String name, List<DoctorResponse> doctors,List<PatientVisitResponse> patientVisits) {
}

package com.example.demo.dto;

import java.util.List;

public record DoctorResponse(Long id, String name, Long departmentId, List<PatientVisitResponse> patientVisits) {
}

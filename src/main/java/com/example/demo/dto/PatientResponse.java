package com.example.demo.dto;

import java.util.List;

public record PatientResponse(Long id, String fullName, String date, Long tckn, List<PatientVisitResponse> patientVisits) {
}

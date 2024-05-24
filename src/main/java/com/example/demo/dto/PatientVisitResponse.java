package com.example.demo.dto;

public record PatientVisitResponse(Long id,String visitDate,String notes,String doctorName,
                                   String departmentName,String patientName) {
}

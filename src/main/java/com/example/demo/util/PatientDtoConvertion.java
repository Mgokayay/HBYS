package com.example.demo.util;

import com.example.demo.dto.PatientResponse;
import com.example.demo.entity.Patient;

import java.util.ArrayList;
import java.util.List;

public class PatientDtoConvertion {

    public static List<PatientResponse> convertPatientList(List<Patient> patients){
        List<PatientResponse> patientResponses=new ArrayList<>();
        patients.stream().forEach(patient -> patientResponses.add(new PatientResponse(patient.getId(),patient.getFullName(),
                patient.getGender().toString(),patient.getTckn())));
        return patientResponses;
    }

    public static PatientResponse convertPatient(Patient patient){
        return new PatientResponse(patient.getId(), patient.getFullName(), patient.getGender().toString(),patient.getTckn());
    }
}

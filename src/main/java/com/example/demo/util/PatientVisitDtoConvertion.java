package com.example.demo.util;


import com.example.demo.dto.PatientVisitResponse;
import com.example.demo.entity.PatientVisit;

import java.util.ArrayList;
import java.util.List;

public class PatientVisitDtoConvertion {

    public static List<PatientVisitResponse> convertPatientVisitList(List<PatientVisit> patientVisits){
        List<PatientVisitResponse> patientVisitResponses=new ArrayList<>();
        patientVisits.stream().forEach(patientVisit -> patientVisitResponses.add(new PatientVisitResponse(patientVisit.getId(),
                patientVisit.getVisitDate(),patientVisit.getNotes())));
        return patientVisitResponses;
    }

    public static PatientVisitResponse convertPatientVisit(PatientVisit patientVisit){
        return new PatientVisitResponse(patientVisit.getId(), patientVisit.getVisitDate(), patientVisit.getNotes());
    }

}

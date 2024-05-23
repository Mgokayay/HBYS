package com.example.demo.util;

import com.example.demo.dto.DoctorResponse;
import com.example.demo.entity.Doctor;

import java.util.ArrayList;
import java.util.List;

public class DoctorDtoConvertion {


    public static List<DoctorResponse> convertDoctorList(List<Doctor> doctors){
        List<DoctorResponse> doctorResponses=new ArrayList<>();

        doctors.stream().forEach(doctor -> doctorResponses.add(new DoctorResponse(doctor.getId(),
                doctor.getName(),doctor.getDepartment().getId()
                ,PatientVisitDtoConvertion.convertPatientVisitList(doctor.getPatientVisits()))));

        return doctorResponses;
    }

    public static DoctorResponse convertDoctor(Doctor doctor){
        return new DoctorResponse(doctor.getId(),
                doctor.getName(),doctor.getDepartment().getId()
                ,PatientVisitDtoConvertion.convertPatientVisitList(doctor.getPatientVisits()));
    }
}

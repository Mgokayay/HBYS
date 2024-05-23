package com.example.demo.util;

import com.example.demo.dto.DepartmentResponse;
import com.example.demo.entity.Department;

import java.util.ArrayList;
import java.util.List;

public class DepartmentDtoConvertion {

    public static List<DepartmentResponse> convertDepartmentList(List<Department> departments){
        List<DepartmentResponse> departmentResponses = new ArrayList<>();
        departments.stream().forEach(department -> departmentResponses.add(new DepartmentResponse(department.getId(),
                department.getName(),DoctorDtoConvertion.convertDoctorList(department.getDoctors()
        ), PatientVisitDtoConvertion.convertPatientVisitList(department.getPatientVisits()))));

        return departmentResponses;
    }

    public static DepartmentResponse convertDepartment(Department department){
        return new DepartmentResponse(department.getId(),department.getName()
                ,DoctorDtoConvertion.convertDoctorList(department.getDoctors()
        ), PatientVisitDtoConvertion.convertPatientVisitList(department.getPatientVisits()));
    }
}

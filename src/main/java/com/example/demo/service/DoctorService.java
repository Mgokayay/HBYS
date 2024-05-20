package com.example.demo.service;

import com.example.demo.dto.DoctorResponse;
import com.example.demo.entity.Doctor;

import java.util.List;

public interface DoctorService {


    DoctorResponse save(Doctor doctor);

    List<DoctorResponse> findAll();

    DoctorResponse findById(Long id);

    DoctorResponse delete(Long id);
}

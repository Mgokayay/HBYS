package com.example.demo.service;

import com.example.demo.dto.DoctorResponse;
import com.example.demo.entity.Department;
import com.example.demo.entity.Doctor;
import com.example.demo.exceptions.CommonException;
import com.example.demo.repository.DoctorRepository;
import com.example.demo.util.DoctorDtoConvertion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorServiceImpl implements DoctorService{

    private final DoctorRepository doctorRepository;
    private final DepartmentService departmentService;

    @Autowired
    public DoctorServiceImpl(DoctorRepository doctorRepository, DepartmentService departmentService) {
        this.doctorRepository = doctorRepository;
        this.departmentService = departmentService;
    }

    @Override
    public DoctorResponse save(Doctor doctor) {
        Department department=departmentService.findByDepartmentId(doctor.getDepartment().getId());
        doctor.setDepartment(department);
        department.getDoctors().add(doctor);


        doctorRepository.save(doctor);
        return DoctorDtoConvertion.convertDoctor(doctor);
    }

    @Override
    public List<DoctorResponse> findAll() {
        return DoctorDtoConvertion.convertDoctorList(doctorRepository.findAll());
    }

    @Override
    public DoctorResponse findById(Long id) {
        Optional<Doctor> doctorOptional = doctorRepository.findById(id);
        if(doctorOptional.isPresent()){
            return DoctorDtoConvertion.convertDoctor(doctorOptional.get());
        }
        throw new CommonException("Doctor not found with given id"+id,HttpStatus.NOT_FOUND);
    }

    @Override
    public void delete(Long id) {
        Optional<Doctor> doctorOptional=doctorRepository.findById(id);
        if(doctorOptional.isPresent()){
            Doctor doctor = doctorOptional.get();
            doctorRepository.delete(doctor);


        }
        throw new CommonException("Doctor not found with given id"+id, HttpStatus.NOT_FOUND);
    }

    @Override
    public Doctor findByDoctorId(Long doctorId) {
        Optional<Doctor> doctorOptional = doctorRepository.findById(doctorId);
        if(doctorOptional.isPresent()){
            return doctorOptional.get();
        }
        throw new CommonException("Doctor not found with given id"+doctorId,HttpStatus.NOT_FOUND);
    }
}

package com.example.demo.service;

import com.example.demo.dto.PatientResponse;
import com.example.demo.entity.Patient;
import com.example.demo.exceptions.CommonException;
import com.example.demo.repository.PatientRepository;
import com.example.demo.util.PatientDtoConvertion;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PatientServiceImpl implements PatientService{

    private final PatientRepository patientRepository;

    @Override
    public PatientResponse save(Patient patient) {
        return PatientDtoConvertion.convertPatient(patientRepository.save(patient));
    }

    @Override
    public List<PatientResponse> findAll() {
        return PatientDtoConvertion.convertPatientList(patientRepository.findAll());
    }

    @Override
    public PatientResponse findById(Long id) {
        Optional<Patient> patientOptional=patientRepository.findById(id);
        if(patientOptional.isPresent()){
            return PatientDtoConvertion.convertPatient(patientOptional.get());
        }
        throw new CommonException("Patient not found with given id"+id, HttpStatus.NOT_FOUND);
    }

    @Override
    public String delete(Long id) {
        Optional<Patient> patientOptional=patientRepository.findById(id);
        if(patientOptional.isPresent()){
            Patient patient=patientOptional.get();
            patientRepository.delete(patient);
            return "Delete process successed";
        }
        throw new CommonException("Patient not found with given id"+id, HttpStatus.NOT_FOUND);
    }

    @Override
    public Patient findByPatientId(Long patientId) {
        Optional<Patient> patientOptional=patientRepository.findById(patientId);
        if(patientOptional.isPresent()){
            return patientOptional.get();
        }
        throw new CommonException("Patient not found with given id"+patientId
                , HttpStatus.NOT_FOUND);
}}

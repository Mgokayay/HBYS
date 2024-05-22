package com.example.demo.service;

import com.example.demo.dto.PatientVisitResponse;
import com.example.demo.entity.PatientVisit;

import com.example.demo.exceptions.CommonException;
import com.example.demo.repository.PatientVisitRepository;
import com.example.demo.util.PatientVisitDtoConvertion;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PatientVisitServiceImpl implements PatientVisitService{

    private final PatientVisitRepository patientVisitRepository;

    @Override
    public PatientVisitResponse save(PatientVisit patientVisit) {

        return PatientVisitDtoConvertion.convertPatientVisit(patientVisitRepository.save(patientVisit));
    }

    @Override
    public List<PatientVisitResponse> findAll() {
        return PatientVisitDtoConvertion.convertPatientVisitList(patientVisitRepository.findAll());
    }

    @Override
    public PatientVisitResponse findById(Long id) {
        Optional<PatientVisit> patientVisitOptional=patientVisitRepository.findById(id);
        if(patientVisitOptional.isPresent()){

            return PatientVisitDtoConvertion.convertPatientVisit(patientVisitOptional.get());
        }
        throw new CommonException("Patientvisit not found with given id"+id, HttpStatus.NOT_FOUND);
    }

    @Override
    public void delete(Long id) {
        Optional<PatientVisit> patientVisitOptional=patientVisitRepository.findById(id);
        if(patientVisitOptional.isPresent()){
            PatientVisit patientVisit=patientVisitOptional.get();
            patientVisitRepository.delete(patientVisit);
        }
        throw new CommonException("Patientvisit not found with given id"+id, HttpStatus.NOT_FOUND);
    }
}

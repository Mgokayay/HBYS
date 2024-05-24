package com.example.demo.controller;

import com.example.demo.dto.PatientResponse;
import com.example.demo.entity.Patient;
import com.example.demo.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {

    private final PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @PostMapping
    public PatientResponse save(@RequestBody Patient patient){
        return patientService.save(patient);
    }

    @GetMapping
    public List<PatientResponse> findAll(){
        return patientService.findAll();
    }

    @GetMapping("/{id}")
    public PatientResponse findById(@PathVariable Long id){
        return patientService.findById(id);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id){
        return patientService.delete(id);

    }
}

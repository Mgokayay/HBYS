package com.example.demo.controller;

import com.example.demo.dto.PatientVisitResponse;
import com.example.demo.entity.PatientVisit;
import com.example.demo.service.PatientVisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patientvisit")
public class PatientVisitController {

    private final PatientVisitService patientVisitService;

    @Autowired
    public PatientVisitController(PatientVisitService patientVisitService) {
        this.patientVisitService = patientVisitService;
    }

    @PostMapping
    public PatientVisitResponse save(@RequestBody PatientVisit patientVisit
                                     ){
        return patientVisitService.save(patientVisit);
    }

    @GetMapping
    public List<PatientVisitResponse> findAll(){
        return patientVisitService.findAll();
    }

    @GetMapping("/{id}")
    public PatientVisitResponse findById(@PathVariable Long id){
        return patientVisitService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        patientVisitService.delete(id);
    }
}

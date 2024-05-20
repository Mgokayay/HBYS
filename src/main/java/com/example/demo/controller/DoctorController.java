package com.example.demo.controller;

import com.example.demo.dto.DoctorResponse;
import com.example.demo.entity.Doctor;
import com.example.demo.service.DoctorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(name = "doctor")
public class DoctorController {

    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @PostMapping
    public DoctorResponse save(@RequestBody Doctor doctor){
        return doctorService.save(doctor);
    }

    @RequestMapping
    public List<DoctorResponse> findAll(){
        return doctorService.findAll();
    }

    @RequestMapping("/{id}")
    public DoctorResponse findById(@PathVariable Long id){
        return doctorService.findById(id);
    }

    @DeleteMapping("/{id}")
    public DoctorResponse delete(@PathVariable Long id){
        return doctorService.delete(id);
    }
}

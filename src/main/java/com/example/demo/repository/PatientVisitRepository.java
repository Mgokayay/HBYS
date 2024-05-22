package com.example.demo.repository;

import com.example.demo.entity.PatientVisit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientVisitRepository extends JpaRepository<PatientVisit,Long> {
}

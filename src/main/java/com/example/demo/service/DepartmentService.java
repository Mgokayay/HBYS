package com.example.demo.service;

import com.example.demo.dto.DepartmentResponse;
import com.example.demo.entity.Department;

import java.util.List;

public interface DepartmentService {

    DepartmentResponse save(Department department);

    List<DepartmentResponse> findAll();

    void delete(Long id);

    DepartmentResponse findById(Long id);

    Department findByDepartmentId(Long departmentId);
}

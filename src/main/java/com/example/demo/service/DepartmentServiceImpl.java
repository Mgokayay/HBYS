package com.example.demo.service;

import com.example.demo.dto.DepartmentResponse;
import com.example.demo.entity.Department;
import com.example.demo.exceptions.CommonException;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.util.DepartmentDtoConvertion;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService{

    private final DepartmentRepository departmentRepository;

    @Override
    public DepartmentResponse save(Department department) {
        departmentRepository.save(department);
        return DepartmentDtoConvertion.convertDepartment(department);
    }

    @Override
    public List<DepartmentResponse> findAll() {

        return DepartmentDtoConvertion.convertDepartmentList(departmentRepository.findAll());
    }

    @Override
    public void delete(Long id) {
        Optional<Department> departmentOptional=departmentRepository.findById(id);
        if(departmentOptional.isPresent()){
          Department department = departmentOptional.get();
          departmentRepository.delete(department);


        }
        throw new CommonException("Department not found with given id"+id, HttpStatus.NOT_FOUND);
    }

    @Override
    public DepartmentResponse findById(Long id) {
        Optional<Department> departmentOptional=departmentRepository.findById(id);
        if(departmentOptional.isPresent()){

            return DepartmentDtoConvertion.convertDepartment(departmentOptional.get());
        }
        throw new CommonException("Department not found with given id"+id, HttpStatus.NOT_FOUND);
    }

    @Override
    public Department findByDepartmentId(Long departmentId) {
        Optional<Department> departmentOptional=departmentRepository.findById(departmentId);
        if(departmentOptional.isPresent()){

            return departmentOptional.get();
        }
        throw new CommonException("Department not found with given id"+departmentId, HttpStatus.NOT_FOUND);
    }
}

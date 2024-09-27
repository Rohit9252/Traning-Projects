package com.department.service;


import com.department.entity.Department;
import com.department.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DepartmentService {



    private final DepartmentRepository departmentRepository;



    public Department saveDepartment(Department department) {
//        department.setDepartmentCode(generateDepartmentCode(department.getDepartmentName()));
        System.out.println(department);
        return departmentRepository.save(department);

    }


    public Department findDepartmentById(String departmentId) {
        return departmentRepository.findById(departmentId).orElseThrow(() -> new RuntimeException("Department not found"));
    }









}

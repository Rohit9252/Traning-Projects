package com.department.controller;


import com.department.entity.Department;
import com.department.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/departments")
@Slf4j
public class DepartmentController {


    private final DepartmentService departmentService;


    @GetMapping
    public String hello() {
        return "Hello from DepartmentController";
    }



    @PostMapping
    public ResponseEntity<Department> saveDepartment(@RequestBody  Department department) {
        log.info("DepartmentController saveDepartment {}", department);
        log.info("Inside saveDepartment method of DepartmentController");

        return ResponseEntity.ok(departmentService.saveDepartment(department));
    }


    @GetMapping("/{id}")
    public ResponseEntity<Department> findDepartmentById(@PathVariable("id") String departmentId) {
        log.info("DepartmentController findDepartmentById {}", departmentId);

        return ResponseEntity.ok(departmentService.findDepartmentById(departmentId));
    }






}

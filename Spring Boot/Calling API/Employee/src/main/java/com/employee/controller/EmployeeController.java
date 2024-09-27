package com.employee.controller;


import com.employee.dto.EmployeeResponse;
import com.employee.entity.Employee;
import com.employee.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
@Slf4j
public class EmployeeController {




    private final EmployeeService employeeService;





    @GetMapping
    public String hello() {
        return "Hello from EmployeeController";
    }


    @PostMapping
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
        return ResponseEntity.ok(employeeService.saveEmployee(employee));
    }

     //Synchronous call
//    @GetMapping("/{id}")
//    public ResponseEntity<EmployeeResponse> findEmployeeById(@PathVariable("id") String employeeId) {
//        log.info("EmployeeController findEmployeeById {}", employeeId);
//        return ResponseEntity.ok(employeeService.findEmployeeById(employeeId));
//    }

    //Asynchronous call
    @GetMapping("/{id}")
    public Mono<ResponseEntity<EmployeeResponse>> findEmployeeById(@PathVariable("id") String employeeId) {
        log.info("EmployeeController findEmployeeById {}", employeeId);
      return employeeService.findEmployeeByIdAsync(employeeId)
              .map(ResponseEntity::ok).defaultIfEmpty(ResponseEntity.notFound().build());

    }

}

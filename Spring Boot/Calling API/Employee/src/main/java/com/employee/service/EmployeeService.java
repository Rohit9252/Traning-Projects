package com.employee.service;


import com.employee.dto.EmployeeResponse;
import com.employee.entity.Department;
import com.employee.entity.Employee;
import com.employee.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;



@Service
@RequiredArgsConstructor
@Slf4j
public class EmployeeService {


    private final EmployeeRepository employeeRepository;

    private  final WebClient webClient;



    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);

    }




    // Synchronous call
    public EmployeeResponse findEmployeeById(String employeeId) {

        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("Employee not found"));



        if(employee.getDepartmentId() == null){
            return  EmployeeResponse.builder()
                    .employeeId(employee.getEmployeeId())
                    .employeeName(employee.getEmployeeName())
                    .employeeCode(employee.getEmployeeCode())
                    .employeeAddress(employee.getEmployeeAddress())
                    .department(null)
                    .build();
        }

        log.info("Department id {}", employee.getDepartmentId());


        Department departmentJson = webClient.get()
                .uri("http://localhost:8081/departments/" + employee.getDepartmentId())
                .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                .retrieve()
                .bodyToMono(Department.class).block();
//                .block();


        System.out.println("departmentJson"+departmentJson);
        log.info("departmentJson {}", departmentJson);




        EmployeeResponse employeeResponse =   EmployeeResponse.builder()
                .employeeId(employee.getEmployeeId())
                .employeeName(employee.getEmployeeName())
                .employeeCode(employee.getEmployeeCode())
                .employeeAddress(employee.getEmployeeAddress())
                .department(departmentJson)
                .build();


        log.info("EmployeeResponse {}", employeeResponse);
        log.info("EmployeeResponseDepartment {}"+employeeResponse);
//        System.out.println("EmployeeResponse {}"+employeeResponse);
        return employeeResponse;





    }

    // Asynchronous call
    public Mono<EmployeeResponse> findEmployeeByIdAsync(String employeeId) {
        // Fetch the employee record asynchronously


        return Mono.fromCallable(() -> employeeRepository.findById(employeeId)
                        .orElseThrow(() -> new RuntimeException("Employee not found")))
                .flatMap(employee -> {
                    // If departmentId is null, return response without department info
                    if (employee.getDepartmentId() == null) {
                        return Mono.just(EmployeeResponse.builder()
                                .employeeId(employee.getEmployeeId())
                                .employeeName(employee.getEmployeeName())
                                .employeeCode(employee.getEmployeeCode())
                                .employeeAddress(employee.getEmployeeAddress())
                                .department(null)
                                .build());
                    }

                    // Fetch department info asynchronously if departmentId is not null
                    return webClient.get()
                            .uri("http://localhost:8081/departments/" + employee.getDepartmentId())
                            .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                            .retrieve()
                            .bodyToMono(Department.class)
                            .map(department -> EmployeeResponse.builder()
                                    .employeeId(employee.getEmployeeId())
                                    .employeeName(employee.getEmployeeName())
                                    .employeeCode(employee.getEmployeeCode())
                                    .employeeAddress(employee.getEmployeeAddress())
                                    .department(department)
                                    .build());
                });

    }



//    public Flux<EmployeeResponse> findAllEmployeesAsync() {
//        return employeeRepository.findAll()
//
//                .flatMap(employee -> {
//                    if (employee.getDepartmentId() == null) {
//                        return Mono.just(EmployeeResponse.builder()
//                                .employeeId(employee.getEmployeeId())
//                                .employeeName(employee.getEmployeeName())
//                                .employeeCode(employee.getEmployeeCode())
//                                .employeeAddress(employee.getEmployeeAddress())
//                                .department(null)
//                                .build());
//                    } else {
//                        return webClient.get()
//                                .uri("http://localhost:8081/departments/" + employee.getDepartmentId())
//                                .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
//                                .retrieve()
//                                .bodyToMono(Department.class)
//                                .map(department -> EmployeeResponse.builder()
//                                        .employeeId(employee.getEmployeeId())
//                                        .employeeName(employee.getEmployeeName())
//                                        .employeeCode(employee.getEmployeeCode())
//                                        .employeeAddress(employee.getEmployeeAddress())
//                                        .department(department)
//                                        .build());
//                    }
//                });
//    }



}

package com.employee.dto;


import com.employee.entity.Department;
import lombok.*;

@Builder
@RequiredArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class EmployeeResponse {


    private String employeeId;
    private String employeeName;
    private String employeeCode;
    private String employeeAddress;
    private Department department;


}

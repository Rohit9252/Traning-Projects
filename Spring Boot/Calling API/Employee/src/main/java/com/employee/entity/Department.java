package com.employee.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.data.mongodb.core.index.Indexed;

@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
@Getter
@Setter
public class Department {



    @JsonProperty("departmentId")  // Maps the 'departmentId' JSON field to 'departmentId' field
    private String departmentId;

    @JsonProperty("departmentName")
    private String departmentName;

    @JsonProperty("departmentCode")
    private String departmentCode;

    @JsonProperty("departmentAddress")
    private String departmentAddress;




}

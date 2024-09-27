package com.department.entity;



import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
@ToString
@Document(collection = "departments")
public class Department {

    @Id
    private String departmentId;
    private String departmentName;
    @Indexed(unique = true)
    private String departmentCode;
    private String departmentAddress;


}

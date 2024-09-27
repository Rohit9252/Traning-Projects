package com.spring.dtos;

import lombok.*;

import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentResponse {


    private String id;
    private String name;
    private String email;

    List<MarksResponse> marksList;


}

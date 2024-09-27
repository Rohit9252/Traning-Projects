package com.spring.service;

import com.spring.dtos.MarksDto;
import com.spring.dtos.StudentResponse;

public interface MarksService {


    public String addMarksToStudent(String id, MarksDto marksDto);

    public StudentResponse getStudentMarks(String id);



}

package com.spring.repository;

import com.spring.Model.Marks;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarksRepository extends CrudRepository<Marks, String> {


    public Marks findByStudentId(String id);


}

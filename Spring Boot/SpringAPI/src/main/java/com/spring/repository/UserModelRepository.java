package com.spring.repository;

import com.spring.Model.UserModel;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface UserModelRepository extends CrudRepository<UserModel, String> {

    public Optional<UserModel> findByEmail(String email );


   // find all the user where role name is student
    @Query("{'role.role': 'STUDENT'}")
     public List<UserModel> findByRole();
}

package com.spring.service;


import com.spring.Model.UserModel;
import com.spring.dtos.SignupDto;

import java.util.List;

public interface UserModelService {

    public String signup(SignupDto signupDto, boolean isAdmin);

    public UserModel addTeacher(SignupDto signupDto);

    public List<UserModel> getAllUsers();

    public String deleteUser(String id);

    public UserModel addStudent(SignupDto signupDto);

    public List<UserModel> getAllStudent();

    public List<UserModel> getAllTeacher();

    public String addMultiStudent(List<SignupDto> signupDtoList);

    public String modifyUser(String id, SignupDto signupDto);



}

package com.spring.controller;

import com.spring.Model.UserModel;
import com.spring.dtos.JwtResponse;
import com.spring.dtos.LoginDto;
import com.spring.dtos.StudentResponse;
import com.spring.service.LoginHandler;
import com.spring.service.UserModelServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/student")
@RequiredArgsConstructor
@PreAuthorize("hasRole('STUDENT')")
public class StudentController {

    private final UserModelServiceImpl userModelServiceImpl;

    private final PasswordEncoder passwordEncoder;

    private final LoginHandler loginHandler;


    @GetMapping("/login")
    @PreAuthorize("hasRole('STUDENT')")
    public ResponseEntity<JwtResponse> loginHandler(@RequestBody LoginDto loginDto) {
        return ResponseEntity.ok(loginHandler.login(loginDto));
    }

    @GetMapping("/getProfile")
    @PreAuthorize("hasRole('STUDENT')")
    public ResponseEntity<UserModel> getProfile(){
        return ResponseEntity.ok(loginHandler.getCurrentUser());
    }


    @GetMapping("/getStudentMarksDetail")
    @PreAuthorize("hasRole('STUDENT')")
    public ResponseEntity<StudentResponse> getCurrentStudentMarksDetail(){
        UserModel currentUser =   loginHandler.getCurrentUser();

        return ResponseEntity.ok(userModelServiceImpl.getStudentMarks(currentUser.getId()));
    }






}

package com.spring.controller;


import com.spring.Model.UserModel;
import com.spring.dtos.JwtResponse;
import com.spring.dtos.LoginDto;
import com.spring.dtos.SignupDto;
import com.spring.service.LoginHandler;
import com.spring.service.UserModelServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin")
@RequiredArgsConstructor
public class AdminController {

    private final UserModelServiceImpl userModelServiceImpl;


    private final PasswordEncoder passwordEncoder;

    private final LoginHandler loginHandler;


    @PostMapping("/signup")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> addAdmin(@RequestBody SignupDto signupDto){
        signupDto.setPassword(passwordEncoder.encode(signupDto.getPassword()));
            boolean isAdmin = true;
        return new ResponseEntity<>(userModelServiceImpl.signup(signupDto, isAdmin), HttpStatus.CREATED);
    }

    @GetMapping("/login")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<JwtResponse> loginHandler(@RequestBody LoginDto loginDto) {
        return ResponseEntity.ok(loginHandler.login(loginDto));
    }

    @GetMapping("/getAdminProfile")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<UserModel> getAdminProfile(){
        return ResponseEntity.ok(loginHandler.getCurrentUser());
    }

    @PostMapping("/addTeacher")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<UserModel> addTeacher(@RequestBody SignupDto signupDto){
        signupDto.setPassword(passwordEncoder.encode(signupDto.getPassword()));
        return new ResponseEntity<>(userModelServiceImpl.addTeacher(signupDto), HttpStatus.CREATED);
    }

    @GetMapping("/getAllUsers")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<UserModel>> getAllUsers(){
       return ResponseEntity.ok(userModelServiceImpl.getAllUsers());
    }

    @GetMapping("/getAllStudent")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<UserModel>> getAllStudent(){
        return ResponseEntity.ok(userModelServiceImpl.getAllStudent());
    }

    @GetMapping("/getAllTeacher")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<UserModel>> getAllTeacher(){
        return ResponseEntity.ok(userModelServiceImpl.getAllStudent());
    }


    @DeleteMapping("/deleteUser/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> deleteUser(@PathVariable String id){
        return ResponseEntity.ok(userModelServiceImpl.deleteUser(id));
    }


    @PutMapping("/modifyUser/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> modifyUser(@PathVariable String id, @RequestBody SignupDto signupDto){
        return ResponseEntity.ok(userModelServiceImpl.modifyUser(id, signupDto));
    }


}

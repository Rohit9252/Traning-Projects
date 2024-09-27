package com.security.controller;


import com.security.model.User;
import com.security.service.UserModelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class DemoController {


    private final UserModelService userModelService;



    @GetMapping("/demo")
    public ResponseEntity<String> sayHello(){
        return  ResponseEntity.ok("Hello from secure End Point");
    }


    @GetMapping("/current-user")
    public ResponseEntity<User> getCurrentUser(){
        System.out.println("Request in Controller: Get Current user");
        return ResponseEntity.ok(userModelService.getCurrentUser());
//        return null;
    }






}

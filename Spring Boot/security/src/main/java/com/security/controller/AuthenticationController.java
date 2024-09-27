package com.security.controller;


import com.security.model.User;
import com.security.request.LoginRequest;
import com.security.request.SignUpRequest;
import com.security.response.AuthenticationResponse;
import com.security.service.UserModelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {


    private final PasswordEncoder passwordEncoder;

    private final UserModelService userModelService;



    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register (
            @RequestBody SignUpRequest signUpRequest
            ){

            signUpRequest.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));

           return  ResponseEntity.ok( userModelService.signup(signUpRequest));
    }



    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody LoginRequest loginRequest
    ){

        System.out.println("Request in Controller"+loginRequest);
        return ResponseEntity.ok(userModelService.authenticate(loginRequest));
    }






}

package com.security.service;

import com.security.model.User;
import com.security.request.LoginRequest;
import com.security.request.SignUpRequest;
import com.security.response.AuthenticationResponse;

public interface UserModelService {


    public AuthenticationResponse signup(SignUpRequest signUpRequest);

    public AuthenticationResponse authenticate(LoginRequest loginRequest);

    public User getCurrentUser();

}

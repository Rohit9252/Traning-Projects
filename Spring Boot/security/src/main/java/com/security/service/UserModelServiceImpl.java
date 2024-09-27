package com.security.service;



import com.security.jwt.JwtService;
import com.security.model.Role;
import com.security.model.User;
import com.security.repository.UserRepository;
import com.security.request.LoginRequest;
import com.security.request.SignUpRequest;
import com.security.response.AuthenticationResponse;
import lombok.RequiredArgsConstructor;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserModelServiceImpl implements  UserModelService {



    private final UserRepository userRepository;


    private  final JwtService jwtService;

    private  final AuthenticationManager authenticationManager;





    @Override
    public AuthenticationResponse signup(SignUpRequest signUpRequest){


        User user = User.builder()
                .firstName(signUpRequest.getFirstName())
                .lastName(signUpRequest.getLastName())
                .email(signUpRequest.getEmail())
                .password(signUpRequest.getPassword())
                .role(Role.USER)
                .build();


            userRepository.save(user);

            var token = jwtService.generateToken(user);

            return AuthenticationResponse.builder().token(token).build();




    }

    @Override
    public AuthenticationResponse authenticate(LoginRequest loginRequest) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.email(),
                        loginRequest.password()
                )
        );

        var user  = userRepository.findByEmail(loginRequest.email())
                .orElseThrow(()-> new RuntimeException("User Not Found"));

        System.out.println("User in Service "+ user);

        var token = jwtService.generateToken(user);

        return AuthenticationResponse.builder().token(token).build();

    }

    @Override
    public User getCurrentUser() {
        return getCurrentUserFromSecurityContextHolder();
    }


    private User getCurrentUserFromSecurityContextHolder(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return (User) auth.getPrincipal();
    }



}

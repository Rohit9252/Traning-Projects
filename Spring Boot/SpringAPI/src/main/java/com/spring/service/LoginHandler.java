package com.spring.service;

import com.spring.Model.UserModel;
import com.spring.dtos.JwtResponse;
import com.spring.dtos.LoginDto;
import com.spring.jwt.JwtUtil;
import com.spring.repository.UserModelRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@Component
@RequiredArgsConstructor
@Slf4j
public class LoginHandler {



    private final AuthenticationManager authenticationManager;



    private final UserModelRepository userModelRepository;


    private final JwtUtil jwtUtil;


    /**
     * Performs user login with the provided credentials.
     *
     * @param loginDto the DTO containing login credentials (email and password)
     * @return the JWT response containing the token, type, email, and roles
     */
    public JwtResponse login(LoginDto loginDto){
        Authentication auth =   authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginDto.getEmail(), loginDto.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(auth);

        String jwt = jwtUtil.createtoken(auth);

         UserDetailsImpl userDetails  = (UserDetailsImpl) auth.getPrincipal();

        List<String> list =  userDetails.getAuthorities()
                .stream().map(i->i.getAuthority()).collect(Collectors.toList());
        JwtResponse jwtResponse = new JwtResponse();

        jwtResponse.setToken(jwt);
        jwtResponse.setEmail(userDetails.getUsername());
        jwtResponse.setRole(list);
        return jwtResponse;
    }


    /**
     * Retrieves the currently authenticated user.
     *
     * @return the UserModel of the current user
     * @throws ProjectException if the user is not found
     */
    public UserModel getCurrentUser(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        UserDetailsImpl userDetails  = (UserDetailsImpl) auth.getPrincipal();

        return userModelRepository
                .findByEmail(userDetails.getUsername()).orElseThrow(()->new RuntimeException("User not found"));

    }

}

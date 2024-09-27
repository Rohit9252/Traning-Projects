package com.security.controller;

import com.security.response.MessageResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/admin-controller")
public class AdminController {


    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin")
    public ResponseEntity<MessageResponseDTO> adminEndpoint(){
        return ResponseEntity.ok(MessageResponseDTO.builder().statusCode(200L).message("Admin Endpoint").build());
    }
}

package com.security.request;

import jakarta.persistence.Column;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SignUpRequest {
    private String firstName;
    private String lastName;
    private  String email;
    private String password;


}

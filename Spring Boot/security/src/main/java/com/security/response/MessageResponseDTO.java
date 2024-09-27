package com.security.response;


import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class MessageResponseDTO {


    private Long statusCode;
    private String message;


}

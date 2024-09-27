package com.security.request;

public record LoginRequest(
        String email,
        String password
) {
}

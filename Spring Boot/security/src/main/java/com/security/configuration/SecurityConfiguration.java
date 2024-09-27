package com.security.configuration;



import com.security.jwt.AuthEntryPointJwt;
import com.security.jwt.AuthTokenFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;


@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
//@EnableMethodSecurity
public class SecurityConfiguration {

    private final AuthTokenFilter authTokenFilter;
    private final AuthenticationProvider authenticationProvider;
    private final AuthEntryPointJwt authEntryPointJwt;


    private static final String[] WHITE_LIST_URL = {
            "/api/v1/auth/**",
            "/v2/api-docs",
            "/v3/api-docs",
            "/v3/api-docs/**",
            "/swagger-resources",
            "/swagger-resources/**",
            "/configuration/ui",
            "/configuration/security",
            "/swagger-ui/**",
            "/webjars/**",
            "/swagger-ui.html"
    };



    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {


        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(req -> req.requestMatchers("/api/v1/auth/**").permitAll()
                        .requestMatchers("/api/v1/admin-controller/**").hasAuthority("ADMIN")
                        .requestMatchers("/api/v1/user-controller/**").hasAuthority("USER")
                        .anyRequest().authenticated()
                ).sessionManagement(
                        session -> session.sessionCreationPolicy(STATELESS)
                ).authenticationProvider(authenticationProvider)
                .exceptionHandling(
                        exception -> exception.authenticationEntryPoint(authEntryPointJwt)
                )
                .headers(
                        headers -> headers
                                .frameOptions(frameOptions -> frameOptions.sameOrigin())
                )
                .addFilterBefore(authTokenFilter, UsernamePasswordAuthenticationFilter.class);

//        http.httpBasic(Customizer.withDefaults());


        return http.build();
    }





}

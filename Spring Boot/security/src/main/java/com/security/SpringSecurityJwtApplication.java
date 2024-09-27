package com.security;

import com.security.model.Role;
import com.security.model.User;
import com.security.repository.UserRepository;
import com.security.service.UserModelService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@RequiredArgsConstructor
public class SpringSecurityJwtApplication {


	private final PasswordEncoder passwordEncoder;
	private final UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityJwtApplication.class, args);
	}




	@Bean
	public CommandLineRunner run() throws Exception {
		return agrs ->{
			User  adminUser = User.builder()
					.email("admin@gmail.com")
					.password("admin")
					.role(Role.ADMIN)
					.build();
			userRepository.findByEmail(adminUser.getEmail())
					.orElseGet(()->{
						adminUser.setPassword(passwordEncoder.encode(adminUser.getPassword()));
						return userRepository.save(adminUser);
					});
		};




	}





}

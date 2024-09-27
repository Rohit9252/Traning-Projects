package com.spring;

import com.spring.Model.MyRole;
import com.spring.Model.Role;
import com.spring.Model.UserModel;
import com.spring.repository.RoleRepository;
import com.spring.repository.UserModelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;


@SpringBootApplication
@RequiredArgsConstructor
public class SpringAPIApplication {

	private  final RoleRepository roleRepository;
	private final UserModelRepository userModelRepository;

	private final PasswordEncoder passwordEncoder;


	public static void main(String[] args) {
		SpringApplication.run(SpringAPIApplication.class, args);
	}


	@Bean
	public CommandLineRunner run() throws Exception {
		return agrs ->{
			roleRepository.save(new Role("64f97a308321e169ab0b3155",  MyRole.ADMIN));
			roleRepository.save(new Role("64f97a318321e169ab0b3156",  MyRole.TEACHER));
			roleRepository.save(new Role("64f97a318321e169ab0b3157", MyRole.STUDENT));

			UserModel userModel = UserModel.builder()
							.id("64fabf0a4e2e18118cbb6e6e")
									.name("Admin")
											.password(passwordEncoder.encode("123456"))
													.email("admin@gmail.com")
															.isAdmin(true)
					.role(roleRepository.findByRole(MyRole.ADMIN))
					.build();
			userModelRepository.save(userModel);
		};
	}





}

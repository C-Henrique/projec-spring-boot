package com.estudos.projecspringboot.security;

import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SpringSecurityConfig {

	@Bean
	InMemoryUserDetailsManager createUserDetailsManager() {

		UserDetails userDetails = createNewUser("admin", "1234");
		UserDetails userDetails1 = createNewUser("teste", "1234");

		return new InMemoryUserDetailsManager(userDetails, userDetails1);
	}

	private UserDetails createNewUser(String username, String password) {
		Function<String, String> passwordEncoder = input -> passwordEncode().encode(input);
		UserDetails userDetails = User.builder().passwordEncoder(passwordEncoder).username(username).password(password)
				.roles("USER", "ADMIN").build();
		return userDetails;
	}

	@Bean
	PasswordEncoder passwordEncode() {
		return new BCryptPasswordEncoder();
	}

}

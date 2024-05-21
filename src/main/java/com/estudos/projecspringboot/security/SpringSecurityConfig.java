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

		Function<String, String> passwordEncoder = input -> passwordEncode().encode(input);

		UserDetails userDetails = User.builder().passwordEncoder(passwordEncoder).username("admin").password("1234")
				.roles("USER", "ADMIN").build();

		return new InMemoryUserDetailsManager(userDetails);
	}

	@Bean
	PasswordEncoder passwordEncode() {
		return new BCryptPasswordEncoder();
	}

}

package com.thrivepal.userservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.thrivepal.userservice.dto.AuthResponse;
import com.thrivepal.userservice.dto.LoginRequest;
import com.thrivepal.userservice.dto.RegisterRequest;
import com.thrivepal.userservice.model.UserData;
import com.thrivepal.userservice.repository.UserRepository;
import com.thrivepal.userservice.util.JwtUtil;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Service
public class AuthService {

    @Autowired
    UserRepository userRepo;
	@Autowired
	PasswordEncoder passwordEncoder;
	@Autowired
	JwtUtil jwtUtil;

	public AuthResponse register(RegisterRequest request) {
		if (userRepo.findByEmail(request.getEmail()).isPresent()) {
			throw new RuntimeException("Email already registered.");
		}

		UserData user = UserData.builder()
				.firstName(request.getFirstName())
				.lastName(request.getLastName())
				.gender(request.getGender())
				.age(request.getAge())
				.email(request.getEmail())
				.phone(request.getPhone())
				.password(passwordEncoder.encode(request.getPassword()))
				.build();

		userRepo.save(user);
		try {
			System.out.println("code generation started");
			String token = jwtUtil.generateToken(user.getEmail());
			System.out.println("code generation finished");

			return new AuthResponse(token, "User registered successfully");
		} catch (Exception e) {
			throw new RuntimeException("Failed to generate token: " + e.getMessage());
		}
	}

	public AuthResponse login(LoginRequest request) {
		UserData user = userRepo.findByEmail(request.getEmail())
				.orElseThrow(() -> new RuntimeException("Invalid credentials"));

		if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
			throw new RuntimeException("Invalid credentials");
		}

		try {
			String token = jwtUtil.generateToken(user.getEmail());
			return new AuthResponse(token, "User loggedin successfully");
		} catch (Exception e) {
			throw new RuntimeException("Failed to generate token: " + e.getMessage());
		}
	}
}


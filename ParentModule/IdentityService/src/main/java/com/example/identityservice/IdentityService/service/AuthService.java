package com.example.identityservice.IdentityService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.identityservice.IdentityService.Entity.UserCredential;
import com.example.identityservice.IdentityService.repository.UserCredentialsRepository;

@Service
public class AuthService {

	@Autowired
	private UserCredentialsRepository repository;
	
	//we are injecting here passwordencoder bean from AuthConfig to enocode the password
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	//here injecting jwtservice methods to auth service
	@Autowired
	private JwtService jwtService;
	
	public String saveuser(UserCredential credential) {
		//this below statement is used to encode the password which is taking from the user
		credential.setPassword(passwordEncoder.encode(credential.getPassword()));
		repository.save(credential);
		return "User added to system";
	}
	
	public String generateToken(String username) {
        return jwtService.generateToken(username);
    }

    public void validateToken(String token) {
        jwtService.validateToken(token);
    }

}

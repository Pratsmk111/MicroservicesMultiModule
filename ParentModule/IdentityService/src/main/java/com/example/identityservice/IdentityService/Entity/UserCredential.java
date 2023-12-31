package com.example.identityservice.IdentityService.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "userdata")
public class UserCredential {

	@Id
	private int id;
	private String name;
	private String email;
	private String password;
}

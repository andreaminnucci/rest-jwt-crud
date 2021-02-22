package com.company.demo.dto.security;

import lombok.Value;

@Value
public class UserLoginDTO {

	String firstName;
	String lastName;
	String email;
	String username;

}

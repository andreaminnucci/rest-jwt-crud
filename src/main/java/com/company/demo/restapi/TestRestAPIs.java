package com.company.demo.restapi;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.demo.config.AuthorizeConstants;

@RestController
@RequestMapping("/api/test")
public class TestRestAPIs {
	
	@GetMapping("/user")
	@PreAuthorize(AuthorizeConstants.HAS_ROLE_ADMIN_AND_USER)
	public String userAccess() {
		return ">>> User Contents!";
	}
	
	@GetMapping("/admin")
	@PreAuthorize(AuthorizeConstants.HAS_ROLE_ADMIN)
	public String adminAccess() {
		return ">>> Admin Contents";
	}
}

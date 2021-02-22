package com.company.demo.dto.security;

import lombok.Getter;

@Getter
public class JwtDTOResponse {
    private String token;
    private String type;
    
    public JwtDTOResponse(String accessToken) {
    	this.type = "Bearer";
        this.token = accessToken;
    }
}

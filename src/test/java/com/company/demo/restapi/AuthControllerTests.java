package com.company.demo.restapi;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
public class AuthControllerTests {

	@Autowired
	private WebApplicationContext webApplicationContext;
	
	private MockMvc mockMvc;
	
	@BeforeEach
	public void setUp() {
	    this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
	@Test
	public void authenticateUser() throws Exception {
		this.mockMvc.perform( MockMvcRequestBuilders
					.post("/api/auth/signin")  
					.contentType(MediaType.APPLICATION_JSON)
					.content("{\"username\":\"username\",\"password\":\"password\"}")
					.accept(MediaType.APPLICATION_JSON))
			      	.andDo(MockMvcResultHandlers.print())
			      	.andExpect(MockMvcResultMatchers.status().isOk());
		/*
			      .andExpect(MockMvcResultMatchers.jsonPath("$.anagrafica").exists())
			      .andExpect(MockMvcResultMatchers.jsonPath("$.anagrafica[*].nome").isNotEmpty());*/
	}
}

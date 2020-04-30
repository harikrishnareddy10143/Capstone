package com.cts.capstrone.FeedbackManagementSystem.jwt.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class AuthResponse implements Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String token;
	
	public AuthResponse(String token) {
		this.token=token;
		
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	
}
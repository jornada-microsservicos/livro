package com.jornada.microsservico.seguranca.security;

public class JWTToken {
	private String token;

	public JWTToken(String token) {
		super();
		this.token = token;
	}

	public String getToken() {
		return token;
	}
}

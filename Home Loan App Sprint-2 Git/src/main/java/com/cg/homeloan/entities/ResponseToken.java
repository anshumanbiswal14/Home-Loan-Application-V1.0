package com.cg.homeloan.entities;

public class ResponseToken {
	
	String token;

	
	
	public ResponseToken () {
		super();
	}

	public ResponseToken (String token) {
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public String toString() {
		return "ResponseToken  [token=" + token + "]";
	}	

}
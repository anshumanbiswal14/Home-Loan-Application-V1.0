package com.cg.homeloan.exceptions;

import java.time.LocalDate;

public class ErrorDetails {
	
	private String message;
	private LocalDate date;
	private String description;
	
	
	public ErrorDetails() {
		super();
	}

	public ErrorDetails(String message, LocalDate date, String description) {
		super();
		this.message = message;
		this.date = date;
		this.description = description;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}	

}

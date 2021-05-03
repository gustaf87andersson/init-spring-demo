package com.example.requests;

import javax.validation.constraints.NotBlank;

public class UpdateStudentRequest {

	@NotBlank(message = "Lastname is mandatory")
	private String lastName;

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}

package com.example.requests;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Add new Student request model")
public class AddStudentRequest {

	@ApiModelProperty(notes = "The FirstName of the Student")
	private String firstName;
	@ApiModelProperty(notes = "The LastName of the Student")
	private String lastName;
	
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
}

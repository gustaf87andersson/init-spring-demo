package com.example.entities;

import java.util.Date;
import java.util.UUID;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Add new Student request model")
public class Student {
		
	@ApiModelProperty(notes = "The unique identifier of an Student")
	private UUID id;
	@ApiModelProperty(notes = "The FirstName of the Student")
	private String firstName;
	@ApiModelProperty(notes = "The LastName of the Student")
	private String lastName;
	@ApiModelProperty(notes = "The date the student was created")
	private Date createdAt;
	@ApiModelProperty(notes = "The date the student was last updated")
	private Date updatedAt;
	

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

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
	
	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
}

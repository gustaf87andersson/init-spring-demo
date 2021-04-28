package com.example.entities;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(description = "Add new Student request model")
@Getter
@Setter
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

	// one.to.one
	private Address address;

	// many.to.one
	private List<Course> courses;

}

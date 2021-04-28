package com.example.requests;

import java.util.List;

import com.example.entities.Course;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(description = "Add new Student request model")
@Getter
@Setter
public class AddStudentRequest {

	@ApiModelProperty(notes = "The FirstName of the Student")
	private String firstName;
	@ApiModelProperty(notes = "The LastName of the Student")
	private String lastName;

	private String city;
	private String street;

	private List<Course> courses;

}

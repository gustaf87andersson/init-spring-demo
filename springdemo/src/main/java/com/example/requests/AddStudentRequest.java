package com.example.requests;

import javax.validation.constraints.NotBlank;

import java.util.List;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(description = "Add new Student request model")
@Getter
@Setter
public class AddStudentRequest {

	@ApiModelProperty(notes = "The FirstName of the Student")
	@NotBlank(message = "FirstName is mandatory")
	private String firstName;

	@ApiModelProperty(notes = "The LastName of the Student")
	@NotBlank(message = "LastName is mandatory")
	private String lastName;

	private String city;
	private String street;

	private List<AddCourseRequest> courses;

}

package com.example.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(description = "Add new Student request model")
@Getter
@Setter
@Entity
@Table(name = "Student")
public class Student {

	@ApiModelProperty(notes = "The unique identifier of an Student")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@ApiModelProperty(notes = "The FirstName of the Student")
	@Column(name = "first_name")
	private String firstName;

	@ApiModelProperty(notes = "The LastName of the Student")
	@Column(name = "last_name")
	private String lastName;

	@ApiModelProperty(notes = "The date the student was created")
	@Column(name = "created_at")
	private Date createdAt;

	@ApiModelProperty(notes = "The date the student was last updated")
	@Column(name = "updated_at")
	private Date updatedAt;

	// one.to.one
	// private Address address;

	// many.to.one
	// private List<Course> courses;

}

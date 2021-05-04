package com.example.requests;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class AddCourseRequest {

    @NotBlank(message = "Name is mandatory")
    private String name;
    
}

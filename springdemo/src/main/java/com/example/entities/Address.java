package com.example.entities;

import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Address {

    private UUID id;
    private String street;
    private String city;

}

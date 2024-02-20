package com.johndobie.springboot.versioning.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @NotNull
    private Integer id;

    @Size(min = 1, max = 15)
    private String firstName;

    @Size(min = 1, max = 60)
    private String lastName;

    @Size(min = 1, max = 150)
    @NotNull
    private Integer age;

    private Address address;

    private LoginDetails loginDetails;
}

package com.example.application.foundation.dtos;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Data
@Builder
public class CustomerDto {
    @NotEmpty(message="firstname cannot be empty")
    @NotBlank
    private String firstName;
    @NotBlank
    @NotEmpty(message="lastname cannot be empty")
    private String lastName;
    @Email
    @NotBlank
    @NotEmpty(message="email cannot be empty")
    private String email;
    @NotBlank
    private String company;


}

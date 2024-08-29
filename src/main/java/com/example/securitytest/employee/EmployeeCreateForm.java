package com.example.securitytest.employee;


import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeCreateForm {
    private String username;

    private String password1;

    private String password2;
}

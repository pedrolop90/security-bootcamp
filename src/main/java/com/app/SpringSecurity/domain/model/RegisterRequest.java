package com.app.SpringSecurity.domain.model;


import com.app.SpringSecurity.infraestructure.Adapters.PostgresqlConfig.Model.RoleEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterRequest {
    private Long id;
    private String name;
    private String lastName;
    private String password;
    private String email;
    private RoleEnum role;
    private String idDocument;
}
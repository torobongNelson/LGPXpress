package org.smartapplication.dtos.response.Auth;

import lombok.Getter;
import lombok.Setter;
import org.smartapplication.model.Enums.Roles;

@Getter
@Setter
public class LoginResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private Roles roles;
    private String message;
}

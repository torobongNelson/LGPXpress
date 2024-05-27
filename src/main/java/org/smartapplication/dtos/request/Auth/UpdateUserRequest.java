package org.smartapplication.dtos.request.Auth;

import lombok.Getter;
import lombok.Setter;
import org.smartapplication.model.Enums.Roles;

@Getter
@Setter
public class UpdateUserRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String password;
    private Roles roles;

}

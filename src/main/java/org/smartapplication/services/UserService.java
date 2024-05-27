package org.smartapplication.services;

import org.smartapplication.dtos.request.Auth.LoginRequest;
import org.smartapplication.dtos.request.Auth.RegistrationRequest;
import org.smartapplication.dtos.request.Auth.UpdateUserRequest;
import org.smartapplication.dtos.response.Auth.LoginResponse;
import org.smartapplication.dtos.response.Auth.RegistrationResponse;
import org.smartapplication.exceptions.UserNotFoundException;
import org.smartapplication.exceptions.VendorNotFoundException;
import org.smartapplication.model.User;

import java.util.List;

public interface UserService {
    RegistrationResponse create(RegistrationRequest request) throws VendorNotFoundException;
    List<User> users();
    User user(Long id);
    User  update(RegistrationRequest request);
    LoginResponse login(LoginRequest request) throws UserNotFoundException;

}

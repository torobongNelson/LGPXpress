package org.smartapplication.controller;

import org.smartapplication.dtos.request.Auth.LoginRequest;
import org.smartapplication.dtos.request.Auth.RegistrationRequest;
import org.smartapplication.dtos.response.Auth.LoginResponse;
import org.smartapplication.dtos.response.Auth.RegistrationResponse;
import org.smartapplication.exceptions.UserNotFoundException;
import org.smartapplication.exceptions.VendorNotFoundException;
import org.smartapplication.services.Implementations.UserServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*")
public class AuthController {
    private final UserServiceImpl userService;

    public AuthController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<RegistrationResponse> register(@RequestBody RegistrationRequest request) throws VendorNotFoundException {
      RegistrationResponse createdUser = userService.create(request);
      return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) throws UserNotFoundException {
        LoginResponse loginResponse = userService.login(request);
        return new ResponseEntity<>(loginResponse,HttpStatus.OK);
    }
}

package org.smartapplication.dtos.response.Customer;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CustomerResponse {
    private Long id;
    private String email;
    private String password;
    private String address;
    private String phoneNumber;
}

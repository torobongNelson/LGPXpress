package org.smartapplication.dtos.request.Customer;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateCustomerRequest {
    private  String email;
    private String address;
    private String phoneNumber;
}

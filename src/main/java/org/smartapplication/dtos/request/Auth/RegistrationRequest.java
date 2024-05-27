package org.smartapplication.dtos.request.Auth;

import lombok.Getter;
import lombok.Setter;
import org.smartapplication.dtos.request.Admin.AdminRegistrationRequest;
import org.smartapplication.dtos.request.Customer.CustomerRegistrationRequest;
import org.smartapplication.dtos.request.Vendor.VendorRegistrationRequest;
import org.smartapplication.model.Enums.Roles;

@Getter
@Setter
public class RegistrationRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String password;
    private Roles roles;


    private VendorRegistrationRequest vendorRegistrationRequest;
    private CustomerRegistrationRequest customerRegistrationRequest;
    private AdminRegistrationRequest adminRegistrationRequest;

}

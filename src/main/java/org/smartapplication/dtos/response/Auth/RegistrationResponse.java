package org.smartapplication.dtos.response.Auth;

import lombok.Getter;
import lombok.Setter;
import org.smartapplication.dtos.response.Admin.AdminRegistrationResponse;
import org.smartapplication.dtos.response.Customer.CustomerRegistrationResponse;
import org.smartapplication.dtos.response.Vendor.VendorRegistrationResponse;
import org.smartapplication.model.Enums.Roles;

@Getter
@Setter
public class RegistrationResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private Roles roles;

    private VendorRegistrationResponse vendorRegistrationResponse;
    private CustomerRegistrationResponse customerRegistrationResponse;
    private AdminRegistrationResponse adminRegistrationResponse;
}

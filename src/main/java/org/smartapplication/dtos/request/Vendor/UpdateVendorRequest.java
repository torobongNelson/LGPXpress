package org.smartapplication.dtos.request.Vendor;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateVendorRequest {

    private long id;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String email;
    private String phoneNumber;
    private String address;
    private String CompanyName;
}

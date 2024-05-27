package org.smartapplication.dtos.response.Vendor;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VendorResponse {
    private Long id;
    private String email;
    private String password;
    private String address;
    private String phoneNumber;
}

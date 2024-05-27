package org.smartapplication.dtos.response.Vendor;

import lombok.Getter;
import lombok.Setter;
import org.smartapplication.model.Enums.Location;

@Getter
@Setter
public class VendorRegistrationResponse {
    private Long id;
    private String companyName;
    private String companyAddress;
    private Location location;
    private String regNo;
}

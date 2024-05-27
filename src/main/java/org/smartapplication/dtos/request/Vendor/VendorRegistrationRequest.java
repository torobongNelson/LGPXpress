package org.smartapplication.dtos.request.Vendor;

import lombok.Getter;
import lombok.Setter;
import org.smartapplication.model.Enums.Location;

@Getter
@Setter
public class VendorRegistrationRequest {
    private String companyName;
    private String companyAddress;
    private Location location;
    private String  regNo;
}


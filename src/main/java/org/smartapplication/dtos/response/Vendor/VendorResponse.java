package org.smartapplication.dtos.response.Vendor;

import lombok.Getter;
import lombok.Setter;
// import org.smartapplication.model.Enums.Location;

@Getter
@Setter
public class VendorResponse {
    private Long id;
    private String companyName;
    private String companyAddress;
    private boolean registrationStatus;
    // private Location location;
    private String regNo;
}

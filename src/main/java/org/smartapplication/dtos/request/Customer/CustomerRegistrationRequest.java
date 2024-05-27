package org.smartapplication.dtos.request.Customer;

import lombok.Getter;
import lombok.Setter;
import org.smartapplication.model.Enums.Location;

@Getter
@Setter
public class CustomerRegistrationRequest {
    private String address;
    private Location location;
}

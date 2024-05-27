package org.smartapplication.dtos.response.Customer;

import lombok.Getter;
import lombok.Setter;
import org.smartapplication.model.Enums.Location;

@Getter
@Setter
public class CustomerRegistrationResponse {
    private String address;
    private Location location;

}

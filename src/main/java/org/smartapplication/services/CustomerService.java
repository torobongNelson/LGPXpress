package org.smartapplication.services;

import org.smartapplication.dtos.request.Customer.CustomerRegistrationRequest;
import org.smartapplication.dtos.response.Customer.CustomerRegistrationResponse;
import org.smartapplication.dtos.response.Customer.CustomerResponse;

public interface CustomerService {

    CustomerResponse getCustomerBy(Long id);

    CustomerRegistrationResponse registerCustomer(CustomerRegistrationRequest request);
}

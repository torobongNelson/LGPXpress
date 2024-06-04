package org.smartapplication.services.Implementations;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.smartapplication.dtos.request.Customer.CustomerRegistrationRequest;
import org.smartapplication.dtos.response.Customer.CustomerRegistrationResponse;
import org.smartapplication.dtos.response.Customer.CustomerResponse;
import org.smartapplication.repositories.CustomerRepository;
import org.smartapplication.services.CustomerService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;
    private ModelMapper mapper;

    @Override
    public CustomerResponse getCustomerBy(Long id) {
        return mapper.map(customerRepository.findById(id), CustomerResponse.class);
    }

    @Override
    public CustomerRegistrationResponse registerCustomer(CustomerRegistrationRequest request) {
        return null;
    }
}

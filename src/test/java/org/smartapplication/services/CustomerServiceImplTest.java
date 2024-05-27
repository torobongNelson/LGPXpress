package org.smartapplication.services;

import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Test;
import org.smartapplication.dtos.request.CustomerLoginRequest;
import org.smartapplication.dtos.request.CustomerRegistrationRequest;
import org.smartapplication.dtos.request.UpdateCustomerRequest;
import org.smartapplication.dtos.response.CustomerRegistrationResponse;
import org.smartapplication.dtos.response.CustomerResponse;
import org.smartapplication.dtos.response.UpdateCustomerResponse;
import org.smartapplication.exceptions.CustomerAlreadyExistException;
import org.smartapplication.exceptions.CustomerNotFoundException;
import org.smartapplication.exceptions.InvalidDetailsException;
import org.smartapplication.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest

class CustomerServiceImplTest {
    @Autowired
    private  CustomerService customerService;
    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void testThatCustomersCanRegister(){
        CustomerRegistrationRequest request = new CustomerRegistrationRequest();
        request.setId(1L);
        request.setFirstName("Smart");
        request.setLastName("Sinners");
        request.setEmail("smartsinners@gmail12.com");
        request.setPassword("password");
        request.setPhoneNumber("07034554344");
        CustomerRegistrationResponse customerRegistrationResponse = customerService.registerCustomer(request);
        assertNotNull(customerRegistrationResponse);
    }

    @Test
    public void testThatCustomerCannotLoginWithWrongDetails(){
        CustomerRegistrationRequest request = new CustomerRegistrationRequest();
//        request.setId(1L);
//        request.setFirstName("Smart");
//        request.setLastName("Sinners");
//        request.setEmail("smartsinners@gmail25.com");
//        request.setPassword("password");
//        request.setUsername("smartSin");
//        request.setPhoneNumber("07034554344");
//        customerService.registerCustomer(request);
        CustomerLoginRequest customerLoginRequest = new CustomerLoginRequest();
        customerLoginRequest.setEmail("smartsinners@gmail2.com");
        customerLoginRequest.setPassword("password");
        assertThrows(InvalidDetailsException.class, () -> customerService.login(customerLoginRequest));
    }
    @Test
    public void getCustomerTest() throws CustomerNotFoundException{
        Long id = 1L;
        CustomerResponse customerResponse = customerService.getCustomerBy(id);
        assertNotNull(customerResponse);
    }



}
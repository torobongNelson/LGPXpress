package org.smartapplication.services;

import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Test;
import org.smartapplication.dtos.request.VendorRegistrationRequest;
import org.smartapplication.dtos.response.VendorRegistrationResponse;
import org.smartapplication.repositories.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest

class VendorServiceImplTest {
    @Autowired
    private VendorService vendorService;

    @Autowired
    private VendorRepository vendorRepository;

    @Test
    public void registerVendor(){
        VendorRegistrationRequest request = new VendorRegistrationRequest();
        request.setId(1L);
        request.setFirstName("Ikedinaobi");
        request.setLastName("Iruatochi");
        request.setEmail("iruatochinaobi@Gmail1.com");
        request.setPassword("password");
        request.setPhoneNumber("08032435465");
        request.setAddress("44 Muyiwa street iyana-kpaja, Lagos");
        request.setCompanyName("iruatochi gas");
        VendorRegistrationResponse response = vendorService.registerVendor(request);
        assertNotNull(response);
        assertNotNull(response.getId());
    }


}
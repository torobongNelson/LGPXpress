package org.smartapplication.controller;

import org.smartapplication.model.Enums.Location;
import org.smartapplication.model.Enums.PaymentMethod;
import org.smartapplication.model.Enums.Roles;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api/data")
@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*")
public class StaticDataController {

    @GetMapping("/roles")
    public ResponseEntity<List<String>> getRoles() {
        List<String> roles = Arrays.stream(Roles.values())
                .map(Enum::name)
                .collect(Collectors.toList());
        return new ResponseEntity<>(roles, HttpStatus.OK);
    }

    @GetMapping("/locations")
    public ResponseEntity<List<String>> getLocations() {
        List<String> locations = Arrays.stream(Location.values())
                .map(Enum::name)
                .collect(Collectors.toList());
        return new ResponseEntity<>(locations, HttpStatus.OK);
    }

    @GetMapping("/product-categories")
    public ResponseEntity<List<String>> getProductCategories() {
        List<String> categories = Arrays.stream(ProductCategory.values())
                .map(Enum::name)
                .collect(Collectors.toList());
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @GetMapping("/payment-method")
    public ResponseEntity<List<String>> getPaymentMethod() {
        List<String> methods = Arrays.stream(PaymentMethod.values())
                .map(Enum::name)
                .collect(Collectors.toList());
        return new ResponseEntity<>(methods, HttpStatus.OK);
    }
}

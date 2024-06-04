package org.smartapplication.controller;

import org.smartapplication.services.Implementations.LocationService;
import org.smartapplication.dtos.request.LocationRequest;
import org.smartapplication.dtos.response.LocationResponse;

import com.maxmind.geoip2.exception.GeoIp2Exception;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/location")
@AllArgsConstructor
public class LocationController {

    private LocationService locationService;


    @PostMapping("/user")
    public ResponseEntity<?> getLocation(@RequestBody LocationRequest locationRequest){
        try {
            LocationResponse response = locationService.getLocation(locationRequest);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (IOException | GeoIp2Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}

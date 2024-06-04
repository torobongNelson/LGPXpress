package org.smartapplication.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LocationResponse {

    private String city;
    private String country;
    private String longitude;
    private String latitude;
}

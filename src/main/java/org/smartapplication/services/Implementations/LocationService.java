package org.smartapplication.services.Implementations;

import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.maxmind.geoip2.model.CityResponse;
import com.maxmind.geoip2.model.CountryResponse;
import org.smartapplication.dtos.request.LocationRequest;
import org.smartapplication.dtos.response.LocationResponse;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;

@Service
public class LocationService {
    public static String PATH_TO_GEO_LITE2_DB = "C:\\Users\\Daniel\\Downloads\\jar_files\\GeoLite2-ASN_20240528\\GeoLite2-ASN.mmdb";
    private static final DatabaseReader reader;

    static {
        try {
            File database = new File(PATH_TO_GEO_LITE2_DB);
            reader = new DatabaseReader.Builder(database).build();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public LocationResponse getLocation(LocationRequest locationRequest) throws IOException, GeoIp2Exception {
        InetAddress ipAddress = InetAddress.getByName(locationRequest.getIp());
        CityResponse cityResponse = reader.city(ipAddress);
        CountryResponse countryResponse = reader.country(ipAddress);

        return LocationResponse.builder()
                .city(cityResponse.getCity().getName())
                .country(countryResponse.getCountry().getName())
                .longitude(cityResponse.getLocation().getLongitude().toString())
                .latitude(cityResponse.getLocation().getLatitude().toString())
                .build();
    }
}

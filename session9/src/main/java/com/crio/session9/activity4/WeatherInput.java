package com.crio.session9.activity4;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class WeatherInput {
    private Double latitude;
    private Double longitude;
    private LocalDateTime tripStartsAt;
    private LocalDateTime tripEndsAt;
    private String apiVersion;
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    
    public WeatherInput(double latitude, double longitude, String tripStartsAt, String tripEndsAt,
            String apiVersion) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.tripStartsAt = LocalDateTime.parse(tripStartsAt,dateTimeFormatter);
        this.tripEndsAt = LocalDateTime.parse(tripEndsAt,dateTimeFormatter);
        this.apiVersion = apiVersion;
    }

    public Double getLatitude() {
        return latitude;
    }

   

    public Double getLongitude() {
        return longitude;
    }

   
    public LocalDateTime getTripStartsAt() {
        return tripStartsAt;
    }

  
    public LocalDateTime getTripEndsAt() {
        return tripEndsAt;
    }

   

    public String getApiVersion() {
        return apiVersion;
    }

   

    public DateTimeFormatter getDateTimeFormatter() {
        return dateTimeFormatter;
    }

    
    
}

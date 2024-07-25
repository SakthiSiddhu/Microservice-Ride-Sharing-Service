package com.ust.rideservice.dto;

import jakarta.persistence.Id;

public class RideResponseDto {

    @Id
    long rideid;
    String source;
    String dest;
    DriverDto driverDto;
    String status;
}

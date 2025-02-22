package com.ust.rideservice.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RideResponseDto {

    @Id
    long rideid;
    String source;
    String dest;
    double distance;
    private DriverDto driverDto;
    String status;
}

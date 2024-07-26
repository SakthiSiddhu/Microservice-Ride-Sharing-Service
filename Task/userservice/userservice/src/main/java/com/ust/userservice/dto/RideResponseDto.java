package com.ust.userservice.dto;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RideResponseDto {

    @Id
    long rideid;
    String source;
    String dest;
    double distance;
    Driver driverDto;
    String status;
}

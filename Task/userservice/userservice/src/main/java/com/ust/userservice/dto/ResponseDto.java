package com.ust.userservice.dto;

import lombok.Data;

import java.util.List;

@Data
public class ResponseDto {
    long id;
    String name;
    List<PaymentDto> payments;
    List<RideResponseDto> rides;
}

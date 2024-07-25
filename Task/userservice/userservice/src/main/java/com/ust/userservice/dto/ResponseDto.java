package com.ust.userservice.dto;

import java.util.List;

public class ResponseDto {
    long id;
    String name;
    List<Ride> rides;
    List<Payment> payments;
}

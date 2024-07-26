package com.ust.userservice.feign;


import com.ust.userservice.dto.Ride;
import com.ust.userservice.dto.RideResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "rideservice", url = "http://localhost:9095/ride")
public interface RideClient {
    @GetMapping("/userhistory/{userid}")
    public List<Ride> getRideByUser(@PathVariable long userid);


    @GetMapping("/response/{userid}")
    public List<RideResponseDto> getRideResponseByUser(@PathVariable long userid);



}

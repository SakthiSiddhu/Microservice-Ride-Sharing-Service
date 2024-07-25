package com.ust.paymentservice.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient(name = "ride-service", url = "http://localhost:9095/ride")
public interface RideClient {

    @GetMapping("/{rideid}")
    public Ride getRideById(@PathVariable long rideid);

    @PutMapping("/{rideid}")
    public String updateRide(@PathVariable long rideid);


}

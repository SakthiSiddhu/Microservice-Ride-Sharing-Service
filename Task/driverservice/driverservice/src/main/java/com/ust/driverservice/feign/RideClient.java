package com.ust.driverservice.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

@FeignClient(name = "rideservice", url = "http://localhost:9095/ride")
public interface RideClient {

    @GetMapping("/ongoing")
    public List<Ride> getOngoingRide();

    @GetMapping("/{rideid}")
    public Ride getRideById(@PathVariable long rideid);

    @PutMapping("/{rideid}/{driverid}")
    public String updateRidewithDriver(@PathVariable long rideid,
                                       @PathVariable long driverid);


}

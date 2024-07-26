package com.ust.rideservice.feign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@FeignClient(name = "driverservice",url="http://localhost:9096/drivers")
public interface DriverClient {

    @GetMapping("/ride/{rideid}")
    public Driver getDriverByRideid(@PathVariable long rideid);

    @GetMapping("id/{id}")
    public Driver getDriverById(@PathVariable long id);


}

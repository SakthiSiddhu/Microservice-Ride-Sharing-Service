package com.ust.paymentservice.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient(name ="driver-service",url = "http://localhost:9096/drivers")
public interface DriverClient {
    @GetMapping( "id/{id}")
    public Driver getDriver(@PathVariable long id);

    @PutMapping("/status/{driverid}")
    Driver updateDriver(@PathVariable long driverid);
/*
    @PutMapping("/status/{driverid}")
    Driver updateDriver(long driverid);*/
}

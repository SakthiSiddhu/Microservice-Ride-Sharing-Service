package com.ust.userservice.feign;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(url = "http://localhost:9095/ride")
public interface RideClient {

}

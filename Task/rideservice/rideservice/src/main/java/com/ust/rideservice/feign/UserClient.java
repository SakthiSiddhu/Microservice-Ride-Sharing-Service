package com.ust.rideservice.feign;

import com.ust.rideservice.client.User;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "userservice",url="http://localhost:9094/users")
public interface UserClient {

    @GetMapping("/{id}")
    public User getUserById(@PathVariable long id);

}

package com.ust.userservice.feign;

import com.ust.userservice.dto.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "paymentservice",url = "http://localhost:9097/payments")
public interface PaymentClient {
    @GetMapping("/history/{userid}")
    public List<Payment> getPaymentHistory(@PathVariable long userid);
}

package com.ust.paymentservice.controller;

import com.ust.paymentservice.dto.PaymentDto;
import com.ust.paymentservice.feign.Ride;
import com.ust.paymentservice.feign.RideClient;
import com.ust.paymentservice.model.Payment;
import com.ust.paymentservice.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @PostMapping("/makePayment/{rideid}")
    public Payment makePayment(@PathVariable long rideid,
                              @RequestBody PaymentDto paymentDto){
        return paymentService.makePayment(rideid,paymentDto);

    }

    @GetMapping("/history/{userid}")
    public List<Payment> getPaymentHistory(@PathVariable long userid){
        return paymentService.getPaymentHistory(userid);
    }
}

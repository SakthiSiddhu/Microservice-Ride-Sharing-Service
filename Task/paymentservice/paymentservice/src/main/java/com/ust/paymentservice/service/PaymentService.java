package com.ust.paymentservice.service;

import com.ust.paymentservice.Repository.PaymentRepository;
import com.ust.paymentservice.dto.PaymentDto;
import com.ust.paymentservice.feign.Driver;
import com.ust.paymentservice.feign.DriverClient;
import com.ust.paymentservice.feign.Ride;
import com.ust.paymentservice.feign.RideClient;
import com.ust.paymentservice.model.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class PaymentService {

    @Autowired
    PaymentRepository paymentRepository;

    @Autowired
    public RideClient rideClient;

    @Autowired
    public DriverClient driverClient;



    public Payment makePayment(long rideid, PaymentDto paymentDto) {
        Ride ride = rideClient.getRideById(rideid);

        Driver driver = driverClient.getDriver(ride.getDriverid());

        double fare = ride.getDistance()*2;

        if(paymentDto.getAmount()==fare &&
                !ride.getStatus().equalsIgnoreCase("completed") )
        {
            Payment payment = new Payment();
            payment.setUserid(ride.getUserid());
            payment.setRideid(rideid);
            payment.setAmount(fare);
            payment.setPaymentMode(paymentDto.getPaymentMode());
            rideClient.updateRide(ride.getRideid());
            driverClient.updateDriver(driver.getDriverId());

            return paymentRepository.save(payment);
        }
        return  null;
    }

    @GetMapping("/history/{userid}")
    public List<Payment> getPaymentHistory(long userid) {
        return paymentRepository.findByUserid(userid);
    }
}

package com.ust.userservice.service;

import com.netflix.discovery.converters.Auto;
import com.ust.userservice.dto.*;
import com.ust.userservice.feign.PaymentClient;
import com.ust.userservice.feign.RideClient;
import com.ust.userservice.model.User;
import com.ust.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PaymentClient paymentClient;

    @Autowired
    RideClient rideClient;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(long id) {

        return userRepository.findById(id).orElse(null);
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public List<User> createUsers(List<User> users)
    {
        return  userRepository.saveAll(users);
    }

    public List<Payment> paymentHistory(long userId) {

        return paymentClient.getPaymentHistory(userId);
    }

    public List<RideResponseDto> ridweithDriver(long userid)
    {
       return rideClient.getRideResponseByUser(userid);
    }


    public ResponseDto getFullResponse(long userid) {

        ResponseDto responseDto = new ResponseDto();
        responseDto.setId(userid);
        responseDto.setName(userRepository.findById(userid).get().getName());
        List<Payment> payments = paymentHistory(userid);
        List<PaymentDto> paymentDtos = new ArrayList<>();
        List<RideResponseDto> rideResponseDtos = ridweithDriver(userid);;
        paymentDtos = MapPaymentDto(payments);
        responseDto.setRides(rideResponseDtos);
        responseDto.setPayments(paymentDtos);
        return responseDto;

    }

    private static List<PaymentDto> MapPaymentDto(List<Payment> payments) {
        List<PaymentDto> paymentDtos = new ArrayList<>();
        for (Payment payment : payments) {
            PaymentDto paymentDto = new PaymentDto();
            paymentDto.setTransactionId(payment.getTransactionId());
            paymentDto.setRideid(payment.getRideid());
            paymentDto.setPaymentMode(payment.getPaymentMode());
            paymentDto.setAmount(payment.getAmount());
            paymentDtos.add(paymentDto);
        }
        return paymentDtos;
    }
}

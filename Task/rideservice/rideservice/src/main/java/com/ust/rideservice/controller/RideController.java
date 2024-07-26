package com.ust.rideservice.controller;

import com.ust.rideservice.dto.RideDto;
import com.ust.rideservice.dto.RideResponseDto;
import com.ust.rideservice.feign.Driver;
import com.ust.rideservice.feign.DriverClient;
import com.ust.rideservice.model.Ride;
import com.ust.rideservice.repository.RideRepository;
import com.ust.rideservice.service.RideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ride")
public class RideController {

    @Autowired
    RideService rideService;



    @PostMapping("/request/{userid}")
    public String requestRide(@RequestBody RideDto ride, @PathVariable long userid) {
        return rideService.requestRide(userid, ride);
    }

    @GetMapping("/userhistory/{userid}")
    public List<Ride> getRideByUser(@PathVariable long userid) {

        return rideService.getRideByUser(userid);
    }

    @GetMapping("/{rideid}")
    public Ride getRideById(@PathVariable long rideid) {
        return rideService.getRideById(rideid);
    }

    @GetMapping("/ongoing/")
    public List<Ride> getOngoingRides() {
        return rideService.getOngoingRides();
    }

    @PutMapping("/{rideid}")
    public String updateRide(@PathVariable long rideid) {
        return rideService.updateRide(rideid);
    }


    @PutMapping("/{rideid}/{driverid}")
    public String updateRidewithDriver(@PathVariable long rideid,
                                       @PathVariable long driverid) {
        return rideService.updateRidewithDriver(rideid,driverid);
    }

    @GetMapping("/res/{rideid}")
            public RideResponseDto getRideResponse(@PathVariable long rideid) {
        return rideService.getRideResponse(rideid);
    }

    @GetMapping("/response/{userid}")
    public List<RideResponseDto> getRideResponseByUser(@PathVariable long userid) {
        return rideService.getRideResponseByUser(userid);
    }

    @DeleteMapping("/cancel/{rideid}")
    public void cancelRide(@PathVariable long rideid) {
        rideService.cancelRide(rideid);
    }

    @GetMapping("/driver/{rideid}")
    public Driver getDriverByRideid(@PathVariable long rideid) {
        return rideService.getDriverByRideid(rideid);
    }
   
}


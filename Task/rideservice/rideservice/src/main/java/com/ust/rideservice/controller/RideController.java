package com.ust.rideservice.controller;

import com.ust.rideservice.client.Response;
import com.ust.rideservice.dto.RideDto;
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


    @DeleteMapping("/cancel/{rideid}")
    public void cancelRide(@PathVariable long rideid) {
        rideService.cancelRide(rideid);
    }
}


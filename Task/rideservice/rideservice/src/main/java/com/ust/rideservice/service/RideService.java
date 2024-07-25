package com.ust.rideservice.service;

import com.ust.rideservice.client.Response;
import com.ust.rideservice.dto.RideDto;
import com.ust.rideservice.feign.UserClient;
import com.ust.rideservice.model.Ride;
import com.ust.rideservice.repository.RideRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RideService {

    @Autowired
    RideRepository rideRepository;

    @Autowired
    UserClient userClient;

    public String requestRide(long userid, RideDto ride) {

        if(userClient.getUserById(userid)!=null) {
            Ride ride1 = new Ride();
            ride1.setUserid(userid);
            ride1.setSource(ride.getSource());
            ride1.setDest(ride.getDest());
            ride1.setDistance(ride.getDistance());
            ride1.setStatus("ongoing");
            rideRepository.save(ride1);
            return  "Ride accepted\n"+ride1.toString();
        }
        return  "User is not registered";
    }

    public List<Ride> getRideByUser(long userid) {

        return rideRepository.findByUserid(userid).orElse(null);
    }

    public void cancelRide(long rideid) {
        rideRepository.deleteById(rideid);
    }

    public List<Ride> getOngoingRides() {
        return rideRepository.getOngoingRides().get();
    }

    public Ride getRideById(long rideid) {
        return rideRepository.findById(rideid).orElse(null);
    }

    public String updateRide(long rideid) {
        Ride ride = rideRepository.findById(rideid).orElse(null);
        if(ride!=null) {
            ride.setStatus("completed");
            rideRepository.save(ride);
            return "Ride completed" + ride;
        }
        return "Ride not found";
    }
    public String updateRidewithDriver(long rideid,long driverid) {
        Ride ride = rideRepository.findById(rideid).orElse(null);
        if(ride!=null) {
            ride.setDriverid(driverid);
            ride.setStatus("assigned");
            rideRepository.save(ride);
            return "Ride assigned" + ride;
        }
        return "Ride not found";
    }

    public List<Ride> getByUserid(long userid){
        return rideRepository.findByUserid(userid).get();
    }
}

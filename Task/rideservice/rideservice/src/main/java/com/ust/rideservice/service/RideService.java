package com.ust.rideservice.service;

import com.ust.rideservice.dto.DriverDto;
import com.ust.rideservice.dto.RideDto;
import com.ust.rideservice.dto.RideResponseDto;
import com.ust.rideservice.feign.Driver;
import com.ust.rideservice.feign.DriverClient;
import com.ust.rideservice.feign.UserClient;
import com.ust.rideservice.model.Ride;
import com.ust.rideservice.repository.RideRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RideService {

    @Autowired
    RideRepository rideRepository;


    @Autowired
    UserClient userClient;

    @Autowired
    DriverClient driverClient;


    public String requestRide(long userid, RideDto ride) {

        if (userClient.getUserById(userid) != null) {
            Ride ride1 = new Ride();
            ride1.setUserid(userid);
            ride1.setSource(ride.getSource());
            ride1.setDest(ride.getDest());
            ride1.setDistance(ride.getDistance());
            ride1.setStatus("ongoing");
            rideRepository.save(ride1);
            return "Ride accepted\n" + ride1.toString();
        }
        return "User is not registered";
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
        if (ride != null) {
            ride.setStatus("completed");
            rideRepository.save(ride);
            return "Ride completed" + ride;
        }
        return "Ride not found";
    }

    public String updateRidewithDriver(long rideid, long driverid) {
        Ride ride = rideRepository.findById(rideid).orElse(null);
        if (ride != null) {
            ride.setDriverid(driverid);
            ride.setStatus("assigned");
            rideRepository.save(ride);
            return "Ride assigned" + ride;
        }
        return "Ride not found";
    }

    public List<Ride> getByUserid(long userid) {
        return rideRepository.findByUserid(userid).get();
    }

    public RideResponseDto getRideResponse(long rideid) {
        Ride ride = rideRepository.findByRideid(rideid).orElse(null);

        RideResponseDto rideResponseDto = MapRide(ride);

        return rideResponseDto;
    }


public Driver getDriverByRideid(long rideid) {
        return driverClient.getDriverByRideid(rideid);
    }

    private DriverDto MapDriver(long driverid) {

        if(driverid==0) return new DriverDto();
        Driver driver = driverClient.getDriverById(driverid);
        DriverDto driverDto = new DriverDto();

        driverDto.setDriverid(driver.getDriverId());
        driverDto.setName(driver.getName());
        driverDto.setLicensenumber(driver.getLicensenumber());
        return driverDto;
    }

    private  RideResponseDto MapRide(Ride ride) {
 RideResponseDto rideResponseDto = new RideResponseDto();
        rideResponseDto.setRideid(ride.getRideid());
        rideResponseDto.setSource(ride.getSource());
        rideResponseDto.setDest(ride.getDest());
        rideResponseDto.setDistance(ride.getDistance());
        rideResponseDto.setStatus(ride.getStatus());


            DriverDto driverDto = MapDriver(ride.getDriverid());
            rideResponseDto.setDriverDto(driverDto);

        return rideResponseDto;
    }


    public List<RideResponseDto>  getRideResponseByUser(long userid) {

        List<Ride> rides  = rideRepository.findByUserid(userid).get();
        List<RideResponseDto> rideResponseDtos = new ArrayList<>();
         for(Ride ride : rides)
         {
             rideResponseDtos.add(MapRide(ride));
         }
    return  rideResponseDtos;
    }
}

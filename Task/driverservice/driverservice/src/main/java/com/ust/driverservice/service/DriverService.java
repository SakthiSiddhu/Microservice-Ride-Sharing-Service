package com.ust.driverservice.service;

import com.ust.driverservice.Repository.DriverRepository;
import com.ust.driverservice.dto.DriverDto;
import com.ust.driverservice.feign.Ride;
import com.ust.driverservice.feign.RideClient;
import com.ust.driverservice.model.Driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DriverService {

    @Autowired
    public  DriverRepository driverRepository;

    @Autowired
    public  RideClient rideClient;

    public Driver addDriver(DriverDto driverdto) {
        Driver driver = new Driver();
        driver.setName(driverdto.getName());
        driver.setEmail(driverdto.getEmail());
        driver.setPhone(driverdto.getPhone());
        driver.setLicensenumber(driverdto.getLicensenumber());
        driver.setDriverstatus("available");
        return driverRepository.save(driver);
    }
    public String updateDriverStatus(Long rideid, long driverid){

        Driver driver =  driverRepository.findById(driverid).get();
        Ride ride =  rideClient.getRideById(rideid);
        if(driver.getDriverstatus().equalsIgnoreCase("available"))
        {
            ride.setDriverid(driverid);
            ride.setStatus("assigned");
            driver.setDriverstatus("busy");

            driver.setRideid(rideid);


            rideClient.updateRidewithDriver(rideid,driverid);
            driverRepository.save(driver);
            return "Driver \n"+ driver.getName() + "is assigned with \n "+ ride.getRideid()+
                    "\n for User"+ ride.getUserid();
        }
        return  "Driver is unavailable";
    }


    public Driver getDriverById(long id) {
        return driverRepository.findById(id).orElse(null);
    }

    public Driver updateDriver(long driverid) {
        Driver driver = driverRepository.findById(driverid).get();
        driver.setDriverstatus("available");
        driver.setRideid(0);
        return driverRepository.save(driver);
    }
}

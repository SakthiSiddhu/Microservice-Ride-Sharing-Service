package com.ust.driverservice.controller;

import com.ust.driverservice.dto.DriverDto;
import com.ust.driverservice.model.Driver;
import com.ust.driverservice.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/drivers")
public class DriverController {

    @Autowired
    public DriverService driverService;

    @PostMapping("/adddriver")
    public Driver addDriver(@RequestBody DriverDto driverDto) {

        return driverService.addDriver(driverDto);
    }

    @PutMapping()
    public String updateDriverStatus(@RequestParam("rideid") long rideid,
                                     @RequestParam("driverid") long driverid) {
        return driverService.updateDriverStatus(rideid, driverid);
    }

    @PutMapping("/status/{driverid}")
    Driver updateDriver(@PathVariable long driverid) {
        return driverService.updateDriver(driverid);
    }


    @GetMapping("/id/{id}")
    public Driver getDriver(@PathVariable long id) {

        return driverService.getDriverById(id);
    }



    @GetMapping("/{status}")
    public List<Driver>  getDriverByStatus(@PathVariable String status) {
        return driverService.getDriverByStatus(status);
    }

    @GetMapping("/ride/{rideid}")
    public Driver getDriverByRideid(@PathVariable long rideid) {
        return driverService.getDriverByRideid(rideid);
    }
}

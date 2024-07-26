package com.ust.driverservice.Repository;

import com.ust.driverservice.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Long>{


    Optional<Driver> findByRideid(long rideid);

    List<Driver> findByDriverstatus(String status);
}

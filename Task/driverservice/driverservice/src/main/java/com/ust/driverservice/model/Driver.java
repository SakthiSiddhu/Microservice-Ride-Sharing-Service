package com.ust.driverservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "driver_sequence")
    @SequenceGenerator(name = "driver_sequence", sequenceName = "driver_sequence", initialValue = 201,allocationSize = 1)
    private long driverId;
    private long rideid;
    private String name;
    private String email;
    private String phone;
    private String licensenumber;
    private String driverstatus;
}

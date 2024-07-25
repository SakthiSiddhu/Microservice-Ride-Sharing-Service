package com.ust.paymentservice.feign;


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
    private long driverId;
    private long rideid;
    private String name;
    private String email;
    private String phone;
    private String licensenumber;
    private String driverstatus;
}


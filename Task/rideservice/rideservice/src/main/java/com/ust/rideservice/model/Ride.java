package com.ust.rideservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Ride {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "ride_sequence")
    @SequenceGenerator(name = "ride_sequence",sequenceName = "ride_sequence",initialValue = 101)
    public  long rideid;
    public long userid;
    public long driverid;
    public  String source;
    public  String dest;
    public double distance;
    public String status;

    @Override
    public String toString() {
        return "Ride{" +
                "rideid=" + rideid +
                ", userid=" + userid +
                ",driverid="+driverid+
                ", source='" + source + '\'' +
                ", dest='" + dest + '\'' +
                ", distance=" + distance +
                ", status='" + status + '\'' +
                '}';
    }
}

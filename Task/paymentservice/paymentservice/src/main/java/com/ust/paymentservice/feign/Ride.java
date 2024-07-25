package com.ust.paymentservice.feign;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ride {
    @Id
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

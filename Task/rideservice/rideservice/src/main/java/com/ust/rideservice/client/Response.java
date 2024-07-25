package com.ust.rideservice.client;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Response {
    public String name;
    public String mobile;
    public long rideid;
    public String source;
    public String dest;
    public double distance;
}

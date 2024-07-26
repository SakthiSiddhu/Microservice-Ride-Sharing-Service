package com.ust.userservice.dto;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Driver
{
    @Id
    public long driverid;
    public String name;
    public String licensenumber;
}

package com.ust.userservice.dto;

import lombok.Data;

@Data
public class Payment {
    public long transactionId;
    public long  userid;
    public long rideid;
    public String paymentMode;
    public double amount;
}

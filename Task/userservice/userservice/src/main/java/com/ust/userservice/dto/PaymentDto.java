package com.ust.userservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDto
{
    public long transactionId;
    public long rideid;
    public String paymentMode;
    public double amount;
}

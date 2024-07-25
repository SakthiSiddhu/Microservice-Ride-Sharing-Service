package com.ust.paymentservice.model;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Payment
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator = "payseq")
    @SequenceGenerator(name = "payseq",sequenceName = "pay_seq",initialValue = 401)
    public long transactionId;
    public long  userid;
    public long rideid;
    public String paymentMode;
    public double amount;
}

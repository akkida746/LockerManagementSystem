package com.example.lockermanagement.service;

import com.example.lockermanagement.strategies.IOtpGenerator;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class OrderService {
    private final IOtpGenerator otpGenerator;
}

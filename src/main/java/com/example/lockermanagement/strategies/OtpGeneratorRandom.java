package com.example.lockermanagement.strategies;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class OtpGeneratorRandom implements IOtpGenerator{
    private final int otpLength;
    private final IRandomGenerator randomGenerator;

    @Override
    public String generateOtp() {
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0;i<otpLength;i++){
            stringBuilder.append(randomGenerator.getRandomNumber(10));
        }
        return stringBuilder.toString();
    }
}

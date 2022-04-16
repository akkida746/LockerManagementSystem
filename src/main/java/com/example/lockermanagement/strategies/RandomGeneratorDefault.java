package com.example.lockermanagement.strategies;

import lombok.NonNull;

public class RandomGeneratorDefault implements IRandomGenerator{

    @Override
    public int getRandomNumber(@NonNull int lessThanThis) {
        return (int) (Math.random()*lessThanThis);
    }
}

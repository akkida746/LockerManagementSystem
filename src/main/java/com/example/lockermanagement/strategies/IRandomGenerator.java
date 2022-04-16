package com.example.lockermanagement.strategies;

import lombok.NonNull;

public interface IRandomGenerator {
    int getRandomNumber(@NonNull int lessThanThis);
}

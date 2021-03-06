package com.example.lockermanagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Package implements LockerItem {
    private final String id;
    private final Size size;

    @Override
    public Size getSize() {
        return this.size;
    }
}

package com.example.lockermanagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public abstract class LockerUser {
    private final Contact contact;
}

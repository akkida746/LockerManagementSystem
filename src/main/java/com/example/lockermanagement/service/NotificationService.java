package com.example.lockermanagement.service;

import com.example.lockermanagement.model.LockerUser;
import com.example.lockermanagement.model.Slot;
import lombok.NonNull;

public class NotificationService {

    public void notifyUser(@NonNull final LockerUser user, @NonNull final String otp, @NonNull final Slot slot){
        System.out.println("Sending notification to user..");
    }
}

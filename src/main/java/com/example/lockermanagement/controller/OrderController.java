package com.example.lockermanagement.controller;

import com.example.lockermanagement.model.Buyer;
import com.example.lockermanagement.model.LockerItem;
import com.example.lockermanagement.model.Slot;
import com.example.lockermanagement.service.LockerService;
import com.example.lockermanagement.service.NotificationService;
import com.example.lockermanagement.service.OtpService;
import lombok.AllArgsConstructor;
import lombok.NonNull;

@AllArgsConstructor
public class OrderController{
    private final OtpService otpService;
    private final NotificationService notificationService;
    private final LockerService lockerService;

    public Slot allocateLocker(@NonNull final Buyer buyer, @NonNull final LockerItem lockerItem){
        Slot slot = lockerService.alloacateSlot(lockerItem);
        String otp = otpService.generateOtp(slot);
        notificationService.notifyUser(buyer, otp, slot);
        return slot;
    }
}

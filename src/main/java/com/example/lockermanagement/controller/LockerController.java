package com.example.lockermanagement.controller;

import com.example.lockermanagement.model.Locker;
import com.example.lockermanagement.model.Size;
import com.example.lockermanagement.model.Slot;
import com.example.lockermanagement.service.LockerService;
import com.example.lockermanagement.service.OtpService;
import lombok.AllArgsConstructor;
import lombok.NonNull;

import java.util.List;

@AllArgsConstructor
public class LockerController {
    private final LockerService lockerService;
    private final OtpService otpService;

    public Locker createLocker(@NonNull final String lockerId){
        return lockerService.createLocker(lockerId);
    }
    public Slot createSlot(@NonNull final Locker locker, @NonNull final Size size){
        return lockerService.createSlot(locker, size);
    }
    public List<Slot> getAvailableSlots(){
        return lockerService.getAvailableSlots();
    }
    public void unlockSlot(@NonNull final Slot slot){

    }
}

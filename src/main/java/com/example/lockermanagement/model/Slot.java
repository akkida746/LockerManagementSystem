package com.example.lockermanagement.model;

import com.example.lockermanagement.exception.SlotAlreadyOccupiedException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

import java.util.Date;

@Data
@AllArgsConstructor
public class Slot {
    private final String slotId;
    private final Size size;
    private final Locker locker;
    private Date allocationDate;
    private LockerItem lockerItem;

    synchronized public boolean isAvailable(){
        return this.lockerItem == null;
    }

    synchronized public void deallocateSlot(){
        this.lockerItem = null;
    }

    synchronized public void allocatePackage(@NonNull final LockerItem lockerItem){
        if(this.lockerItem != null){
            throw new SlotAlreadyOccupiedException();
        }
        this.allocationDate = new Date();
        this.lockerItem = lockerItem;
    }
}

package com.example.lockermanagement.model;

import com.example.lockermanagement.exception.SlotAlreadyOccupiedException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

import java.util.Date;

@Data
public class Slot {
    private final String slotId;
    private final Size size;
    private final Locker locker;
    private Date allocationDate;
    private LockerItem lockerItem;

    public Slot(@NonNull final String slotId, @NonNull final Size size, @NonNull final Locker locker) {
        this.slotId = slotId;
        this.size = size;
        this.locker = locker;
        this.lockerItem= null;
    }


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

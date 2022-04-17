package com.example.lockermanagement.service;

import com.example.lockermanagement.exception.NoSlotAvailableException;
import com.example.lockermanagement.model.Locker;
import com.example.lockermanagement.model.LockerItem;
import com.example.lockermanagement.model.Size;
import com.example.lockermanagement.model.Slot;
import com.example.lockermanagement.repository.ILockerRepository;
import com.example.lockermanagement.strategies.ISlotAssigmentStrategy;
import com.example.lockermanagement.strategies.ISlotFilterStrategy;
import lombok.AllArgsConstructor;
import lombok.NonNull;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
public class LockerService {
    private final ISlotAssigmentStrategy slotAssigmentStrategy;
    private final ILockerRepository lockerRepository;
    private final ISlotFilterStrategy slotFilterStrategy;

    public Locker createLocker(@NonNull final String lockerId){
        return lockerRepository.createLocker(lockerId);
    }

    public Slot createSlot(@NonNull final Locker locker, @NonNull final Size size){
        final Slot slot = new Slot(UUID.randomUUID().toString(), size, locker);
        locker.addSlot(slot);
        return slot;
    }

    public List<Slot> getAvailableSlots(){
        return lockerRepository.getAvailableSlots();
    }

    public Slot alloacateSlot(@NonNull final LockerItem lockerItem){
        List<Slot> availableSlots = lockerRepository.getAvailableSlots();
        List<Slot> filteredSlots = slotFilterStrategy.filterSlots(availableSlots, lockerItem);
        Slot slotToBeAllocated = slotAssigmentStrategy.pickSlot(filteredSlots);
        if(slotToBeAllocated == null){
            throw new NoSlotAvailableException();
        }
        slotToBeAllocated.allocatePackage(lockerItem);
        return slotToBeAllocated;
    }

    public void deallocateSlot(@NonNull final Slot slot){
        slot.deallocateSlot();
    }

}

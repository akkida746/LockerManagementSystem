package com.example.lockermanagement.strategies;

import com.example.lockermanagement.model.LockerItem;
import com.example.lockermanagement.model.Slot;
import lombok.NonNull;

import java.util.List;
import java.util.stream.Collectors;

public class SlotFilteringStrategySizeBased implements ISlotFilterStrategy{
    @Override
    public List<Slot> filterSlots(@NonNull List<Slot> slots, @NonNull LockerItem lockerItem) {
        return slots.stream().filter(slot -> slot.getSize().canAccomodate(lockerItem.getSize())).collect(Collectors.toList());
    }
}

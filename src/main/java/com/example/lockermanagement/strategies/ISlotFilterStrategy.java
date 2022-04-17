package com.example.lockermanagement.strategies;

import com.example.lockermanagement.model.LockerItem;
import com.example.lockermanagement.model.Slot;
import lombok.NonNull;

import java.util.List;

public interface ISlotFilterStrategy {
    public List<Slot> filterSlots(@NonNull final List<Slot> slots, @NonNull final LockerItem lockerItem);
}

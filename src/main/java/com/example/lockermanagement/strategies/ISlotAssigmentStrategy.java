package com.example.lockermanagement.strategies;

import com.example.lockermanagement.model.Slot;
import lombok.NonNull;

import java.util.List;

public interface ISlotAssigmentStrategy {

    Slot pickSlot(@NonNull List<Slot> slots);
}

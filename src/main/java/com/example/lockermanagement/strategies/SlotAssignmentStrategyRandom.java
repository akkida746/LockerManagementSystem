package com.example.lockermanagement.strategies;

import com.example.lockermanagement.model.Slot;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import java.util.List;

@AllArgsConstructor
public class SlotAssignmentStrategyRandom implements ISlotAssigmentStrategy{
    private final IRandomGenerator randomGenerator;

    @Override
    public Slot pickSlot(@NonNull List<Slot> slots) {
        if(slots.isEmpty()){
            return null;
        }
        int slotNum = randomGenerator.getRandomNumber(slots.size());
        return slots.get(slotNum);
    }
}

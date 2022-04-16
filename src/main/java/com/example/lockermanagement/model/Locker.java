package com.example.lockermanagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

@Data
public class Locker {
    private final String id;
    private final List<Slot> slots;

    public Locker(String id){
        this.id = id;
        this.slots = new ArrayList<>();
    }

    public void addSlot(@NonNull final Slot slot){
        this.slots.add(slot);
    }

    public List<Slot> getAvailableSlots(){
        final List<Slot> result = new ArrayList<>();
        for(Slot slot: this.slots){
            if(slot.isAvailable()){
                result.add(slot);
            }
        }
        return result;
    }
}

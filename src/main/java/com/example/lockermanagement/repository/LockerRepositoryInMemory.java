package com.example.lockermanagement.repository;

import com.example.lockermanagement.exception.LockerAlreadyExistsException;
import com.example.lockermanagement.model.Locker;
import com.example.lockermanagement.model.Slot;
import lombok.AllArgsConstructor;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class LockerRepositoryInMemory implements ILockerRepository{
    private final List<Locker> allLockers;

    public Locker getLocker(@NonNull final String id){
        for(Locker locker: this.allLockers){
            if(locker.getId().equals(id)){
                return locker;
            }
        }
        return null;
    }

    @Override
    public Locker createLocker(@NonNull String id) {
        if(getLocker(id)!=null){
            throw new LockerAlreadyExistsException();
        }
        final Locker newLocker = new Locker(id);
        allLockers.add(newLocker);
        return newLocker;
    }

    @Override
    public List<Slot> getAvailableSlots() {
        final List<Slot> result = new ArrayList<>();
        for(Locker locker: allLockers){
            result.addAll(locker.getAvailableSlots());
        }
        return result;
    }
}

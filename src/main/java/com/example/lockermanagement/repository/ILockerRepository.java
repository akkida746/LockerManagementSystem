package com.example.lockermanagement.repository;

import com.example.lockermanagement.model.Locker;
import com.example.lockermanagement.model.Slot;
import lombok.NonNull;

import java.util.List;

public interface ILockerRepository {
    Locker createLocker(@NonNull String id);
    List<Slot> getAvailableSlots();
}

package com.example.lockermanagement.repository;

import lombok.AllArgsConstructor;
import lombok.NonNull;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
public class SlotOtpRepositoryInMemory implements ISlotOtpRepository{
    private Map<String,String> slotIdOptMap = new HashMap<>();

    @Override
    public void addOtp(@NonNull String otp, @NonNull String slotId) {
        slotIdOptMap.put(slotId, otp);
    }

    @Override
    public String getOtp(@NonNull String slotId) {
        return slotIdOptMap.get(slotId);
    }
}

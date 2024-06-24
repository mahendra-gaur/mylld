package com.example.locker.strategies.impl;


import com.example.locker.model.Slot;
import com.example.locker.strategies.IRandomGenerator;
import com.example.locker.strategies.ISlotAssignmentStrategy;
import java.util.List;
import lombok.NonNull;

public class SlotAssignmentStrategyRandom implements ISlotAssignmentStrategy {

    private final IRandomGenerator randomGenerator;

    public SlotAssignmentStrategyRandom(@NonNull final IRandomGenerator randomGenerator) {
        this.randomGenerator = randomGenerator;
    }

    @Override
    public Slot pickSlot(@NonNull final List<Slot> slots) {
        if (slots.isEmpty()) {
            return null;
        }
        int slotNum = randomGenerator.getRandomNumber(slots.size());
        return slots.get(slotNum);
    }
}
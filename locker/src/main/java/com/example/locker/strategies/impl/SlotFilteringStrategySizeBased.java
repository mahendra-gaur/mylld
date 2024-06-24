package com.example.locker.strategies.impl;

import com.example.locker.model.LockerItem;
import com.example.locker.model.Slot;
import com.example.locker.strategies.ISlotFilteringStrategy;
import java.util.List;
import java.util.stream.Collectors;
import lombok.NonNull;

public class SlotFilteringStrategySizeBased implements ISlotFilteringStrategy {

    @NonNull
    @Override
    public List<Slot> filterSlots(@NonNull final List<Slot> slots, @NonNull final LockerItem lockerItem) {
        return slots.stream()
                .filter(slot -> slot.getSize().canAccommodate(lockerItem.getSize()))
                .collect(Collectors.toList());
    }
}

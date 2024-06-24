package com.example.locker.strategies;

import com.example.locker.model.LockerItem;
import com.example.locker.model.Slot;
import java.util.List;
import lombok.NonNull;

public interface ISlotFilteringStrategy {

    @NonNull
    List<Slot> filterSlots(@NonNull List<Slot> slots, @NonNull LockerItem lockerItem);
}
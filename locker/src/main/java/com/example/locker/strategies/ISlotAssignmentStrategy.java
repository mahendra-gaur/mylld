package com.example.locker.strategies;

import com.example.locker.model.Slot;
import java.util.List;
import lombok.NonNull;

public interface ISlotAssignmentStrategy {

    Slot pickSlot(@NonNull List<Slot> slots);
}
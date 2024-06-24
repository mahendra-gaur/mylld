package com.example.locker.service;

import com.example.locker.exceptions.NoSlotAvailableException;
import com.example.locker.model.Locker;
import com.example.locker.model.LockerItem;
import com.example.locker.model.Size;
import com.example.locker.model.Slot;
import com.example.locker.repository.ILockerRepository;
import com.example.locker.strategies.ISlotAssignmentStrategy;
import com.example.locker.strategies.ISlotFilteringStrategy;
import java.util.List;
import java.util.UUID;
import lombok.NonNull;

public class LockerService {

    private final ISlotAssignmentStrategy assignmentStrategy;
    private final ILockerRepository lockerRepository;
    private final ISlotFilteringStrategy slotFilteringStrategy;

    public LockerService(@NonNull final ISlotAssignmentStrategy assignmentStrategy,
            @NonNull final ILockerRepository lockerRepository,
            @NonNull final ISlotFilteringStrategy slotFilteringStrategy) {
        this.assignmentStrategy = assignmentStrategy;
        this.lockerRepository = lockerRepository;
        this.slotFilteringStrategy = slotFilteringStrategy;
    }

    @NonNull
    public Locker createLocker(@NonNull final String lockerId) {
        return lockerRepository.createLocker(lockerId);
    }

    @NonNull
    public Slot createSlot(@NonNull final Locker locker, @NonNull final Size slotSize) {
        final Slot slot = new Slot(UUID.randomUUID().toString(), slotSize, locker);
        locker.addSlot(slot);
        return slot;
    }

    @NonNull
    public List<Slot> getAllAvailableSlots() {
        return lockerRepository.getAllAvailableSlots();
    }

    @NonNull
    public Slot allocateSlot(@NonNull final LockerItem lockerItem) {

        final List<Slot> allAvailableSlots = lockerRepository.getAllAvailableSlots();
        final List<Slot> filteredSlots = slotFilteringStrategy.filterSlots(allAvailableSlots, lockerItem);
        final Slot slotToBeAllocated = assignmentStrategy.pickSlot(filteredSlots);

        if (slotToBeAllocated == null) {
            throw new NoSlotAvailableException();
        }

        slotToBeAllocated.allocatePackage(lockerItem);
        return slotToBeAllocated;
    }

    public void deallocateSlot(@NonNull final Slot slot) {
        slot.deallocateSlot();
    }
}